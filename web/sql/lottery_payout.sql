DROP FUNCTION "lottery_payout"("lottery_expect" text,"lottery_type" text, "lottery_code" text, "opencode" text, "winrecordjson" text);
CREATE OR REPLACE FUNCTION "lottery_payout"("lottery_expect" text,"lottery_type" text, "lottery_code" text, "opencode" text, "winrecordjson" text)
  RETURNS "pg_catalog"."varchar" AS $BODY$
/*版本更新说明
  版本   	时间        	作者   	内容
  --v1.00  	未知  		未知  	初版派彩
  --v1.01  	2018/07/15  	rambo  	返点结算后返还
  --v1.02  	2018/12/20  	marz  	player_game_order更新增加stat_time字段值
	--v1.03   2019/06/04    rambo   添加耗时输出日志
	--v1.04   2019/06/19    rambo   派彩资金记录,钱包更新优化
	--v1.05   2019/07/07    rambo   player_game_order-bet_detail 添加开奖号码

  -- lottery_expect 期数
  -- lottery_code 彩种代号
  -- lottery_type 彩种类型
  -- opencode 开奖号码
  -- winrecordjson 中奖记录字符串
*/

DECLARE

	lotteryParameter json;--优惠活动信息
	reslut_value varchar;--返回结果
	lotteryBetOrder RECORD;--开奖结果

	MSG_FAILD text:= 'faild';--开奖失败
	MSG_SUCCESS text:= 'success';--开奖成功
	MSG_NOT_NEED text:='not_need';--无需派彩
	NOW_TIME TIMESTAMP:= now();--同一个函数里面，系统当前时间是一样的
	testtime TIMESTAMP;
	testtime1 TIMESTAMP;
	time1 int4;
	time2 int4;
	time3 int4;
	time4 int4;
	time5 int4;
	time6 int4;

BEGIN
	IF lottery_expect = ''  or lottery_type='' or lottery_code='' or opencode='' or winRecordJson is null or winRecordJson = '' THEN
		return MSG_FAILD;
	END IF;

	IF NOT EXISTS  (SELECT * FROM lottery_bet_order WHERE expect=lottery_expect AND code=lottery_code AND status = '1') THEN
		RETURN MSG_NOT_NEED;
	END IF;

	lotteryParameter = json_build_object('expect',lottery_expect,'type',lottery_type,'code',lottery_code,'opencode',opencode);

	raise notice '中奖记录为:%', winRecordJson;
	raise notice '开奖参数为:%', lotteryParameter;
	--v1.03   2019/06/04    rambo   添加耗时输出日志
	select clock_timestamp() INTO testtime;

-- 	if lottery_type = 'pk10' then
		SELECT lottery_payout_pk10(winRecordJson,lotteryParameter) INTO reslut_value;
-- 	ELSEIF lottery_code like '%lhc' then
-- 		SELECT lottery_payout_lhc(winRecordJson,lotteryParameter) INTO reslut_value;
-- 	ELSEIF lottery_code like '%ssc' OR lottery_code='xyft' then
-- 		SELECT lottery_payout_ssc(winRecordJson,lotteryParameter) INTO reslut_value;
-- 	ELSEIF lottery_code like '%k3' then
-- 		SELECT lottery_payout_k3(winRecordJson,lotteryParameter) INTO reslut_value;
-- 	ELSEIF lottery_code = 'cqxync' or lottery_code = 'gdkl10' then
-- 		SELECT lottery_payout_sfc(winRecordJson,lotteryParameter) INTO reslut_value;
-- 	ELSEIF lottery_code = 'fc3d' or lottery_code = 'tcpl3' then
-- 		SELECT lottery_payout_pl3(winRecordJson,lotteryParameter) INTO reslut_value;
-- 	ELSEIF lottery_code = 'bjkl8' then
-- 		SELECT lottery_payout_keno(winRecordJson,lotteryParameter) INTO reslut_value;
-- 	ELSEIF lottery_code = 'xy28' then
-- 		SELECT lottery_payout_xy28(winRecordJson,lotteryParameter) INTO reslut_value;
-- 	ELSE
	--其它彩种待处理
-- 	end if;
	--v1.03   2019/06/04    rambo   添加耗时输出日志
	select clock_timestamp() INTO testtime1;
	SELECT floor(extract(epoch from((testtime1 - testtime)*1000))) INTO time1;

-- 	IF reslut_value = MSG_SUCCESS THEN
-- 		--添加交易表
-- 		--v1.04   2019/06/19    rambo   派彩资金记录,钱包更新优化
-- 		INSERT INTO lottery_transaction (user_id,username,transaction_type,money,balance,transaction_time,terminal,source_id,memo)
-- 			SELECT  lbo.user_id ,lbo.username , '2', lbo.payout, ((select p.money from player_api p where p.player_id=lbo.user_id and p.api_id=22 FOR UPDATE) + sum(payout) over(partition by lbo.user_id order by lbo.id)) as balance ,
-- 				lbo.payout_time,lbo.terminal,lbo.id,'开奖派彩' from lottery_bet_order lbo WHERE lbo.expect = lottery_expect and lbo.code = lottery_code and lbo.status='2' AND lbo.payout>0
-- 																																							and lbo.payout_time = NOW_TIME order by  lbo.user_id ,lbo.id;
--
-- 		--v1.03   2019/06/04    rambo   添加耗时输出日志
-- 		select clock_timestamp() INTO testtime;
-- 		SELECT floor(extract(epoch from((testtime - testtime1)*1000))) INTO time2;
-- 		--更新钱包
-- 		--v1.04   2019/06/19    rambo   派彩资金记录,钱包更新优化
-- 		UPDATE player_api u SET money = COALESCE(money,0) + COALESCE( lbo.payout,0)
-- 		FROM (SELECT "sum"(payout) payout,user_id FROM lottery_bet_order where expect = lottery_expect and code = lottery_code AND status='2' AND payout>0 and payout_time = NOW_TIME GROUP BY user_id) lbo
-- 		where u.api_id=22 and u.player_id=lbo.user_id;
--
--
--
-- 		--v1.03   2019/06/04    rambo   添加耗时输出日志
-- 		select clock_timestamp() INTO testtime1;
-- 		SELECT floor(extract(epoch from((testtime1 - testtime)*1000))) INTO time3;
-- 		--添加返点交易
-- 		--v1.04   2019/06/19    rambo   派彩资金记录,钱包更新优化
-- 		INSERT INTO lottery_transaction (user_id,username,transaction_type,money,balance,transaction_time,terminal,source_id,memo)
-- 			SELECT  lbo.user_id ,lbo.username , '5', trunc(lbo.rebate*lbo.bet_amount,3), ((select p.money from player_api p where p.player_id=lbo.user_id and p.api_id=22 FOR UPDATE) + sum(trunc(lbo.rebate*lbo.bet_amount,3)) over(partition by lbo.user_id order by lbo.id)) as balance ,
-- 				lbo.payout_time,lbo.terminal,lbo.id,'投注下单返点' from lottery_bet_order lbo WHERE lbo.expect = lottery_expect and lbo.code = lottery_code and lbo.status='2' AND lbo.rebate>0
-- 																																				and lbo.payout_time = NOW_TIME order by  lbo.user_id ,lbo.id;
-- 		--v1.03   2019/06/04    rambo   添加耗时输出日志
-- 		select clock_timestamp() INTO testtime;
-- 		SELECT floor(extract(epoch from((testtime - testtime1)*1000))) INTO time4;
-- 		--返点更新钱包
-- 		--v1.04   2019/06/19    rambo   派彩资金记录,钱包更新优化
-- 		UPDATE player_api u SET money = COALESCE(money,0) + COALESCE( lbo.rebate,0)
-- 		FROM (SELECT COALESCE(SUM(trunc(rebate*bet_amount,3)),0) rebate,user_id FROM lottery_bet_order where expect = lottery_expect and code = lottery_code AND status='2' AND rebate>0 and payout_time = NOW_TIME GROUP BY user_id) lbo
-- 		where u.api_id=22 and u.player_id=lbo.user_id;
--
-- 		--v1.03   2019/06/04    rambo   添加耗时输出日志
-- 		select clock_timestamp() INTO testtime1;
-- 		SELECT floor(extract(epoch from((testtime1 - testtime)*1000))) INTO time5;
-- 		--更新player_game_order的同时更新未稽核中间表
-- 	  --v1.02  	2018/12/20  	marz  	player_game_order更新增加stat_time字段值
-- 		--v1.05   2019/07/07    rambo   player_game_order->bet_detail 添加开奖号码
-- 		with pgo as (
-- 			update player_game_order po set profit_amount=(COALESCE(lo.payout,0)-COALESCE(lo.effective_trade_amount,0)),payout_time=lo.payout_time,effective_trade_amount=lo.effective_trade_amount,
-- 				update_time=NOW_TIME,order_state='settle',is_profit_loss=((COALESCE(lo.payout,0)-COALESCE(lo.bet_amount,0))!=0),bet_detail=(select array_to_json(array_agg(row_to_json(t))) json from (select string_to_array('', ',') as apiLotteryResultVoList,
-- 				o.id,o.expect,o.username,extract(epoch from o.bet_time) bet_time,o.code,o.play_code,o.bet_code,o.bet_num,o.odd,o.bet_amount,o.payout,extract(epoch from o.payout_time) payout_time,o.status,o.terminal,o.memo,o.user_id,o.effective_trade_amount,
-- 				o.odd2,o.odd3,o.bonus_model,o.play_model,o.rebate,o.multiple,o.bet_count,opencode as open_code from lottery_bet_order o where o.id=lo.id) t),stat_time=now()
-- 			FROM lottery_bet_order lo  WHERE po.api_id=22 AND po.bet_id=lo.id::VARCHAR AND lo.code=lottery_code AND lo.expect=lottery_expect AND lo.payout_time=NOW_TIME
-- 			RETURNING po.id, po.api_id, po.bet_id, po.player_id, po.effective_trade_amount, po.payout_time, po.order_state
-- 		)
-- 		INSERT INTO player_game_order_not_audit (id, api_id, bet_id, player_id, effective_trade_amount, payout_time, order_state)
-- 			SELECT id, api_id, bet_id, player_id, effective_trade_amount, payout_time, order_state
-- 			FROM pgo
-- 		ON CONFLICT (id)
-- 			DO UPDATE
-- 				SET player_id= excluded.player_id,
-- 					effective_trade_amount = excluded.effective_trade_amount,
-- 					payout_time = excluded.payout_time,
-- 					order_state = excluded.order_state;
--
-- 	--v1.03   2019/06/04    rambo   添加耗时输出日志
-- 	select clock_timestamp() INTO testtime;
-- 	SELECT floor(extract(epoch from((testtime - testtime1)*1000))) INTO time6;
-- 	END IF;
	raise notice '调用过程结果：%',reslut_value;
	return reslut_value ||';'|| time1 || ';'|| time2 || ';'|| time3 || ';'|| time4 || ';'|| time5 || ';'|| time6;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;


COMMENT ON FUNCTION "lottery_payout"("lottery_expect" text,"lottery_type" text, "lottery_code" text, "opencode" text, "winrecordjson" text) IS '彩票派彩';