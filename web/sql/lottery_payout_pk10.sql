CREATE OR REPLACE FUNCTION "lottery_payout_pk10"("lotteryresultjson" text, "lotteryparameter" json)
  RETURNS "pg_catalog"."varchar" AS $BODY$
/*
  版本更新说明
  版本   时间        作者   内容
--v1.01  2018/07/05  rambo  截取金额位数调整

  -- lotteryResultJson 开奖结果
  -- lotteryParameter 开奖参数
*/
DECLARE
lottery_expect text;
lottery_code text;
lottery_open_code text;
lotteryBetOrder RECORD;--开奖结果
resultJson VARCHAR;--单个中奖结果JSON串

p_expect VARCHAR;--期数
p_code VARCHAR;--彩种
p_play_code VARCHAR;--玩法
p_bet_code VARCHAR;--下注内容
p_winning_num VARCHAR;--中奖号码
winning_num_arr VARCHAR(3)[]; --组选中奖号码

ERROR_PARAMETER text:='01';--参数错误
ERROR_NOT_NEED text:='02';--无需派彩
ERROR_NOT_WINNING_RECORD text:='03';--无开奖结果
MSG_SUCCESS text:= 'success';--开奖成功
BEGIN
lottery_expect  = lotteryParameter->>'expect';
lottery_code = lotteryParameter->>'code';
lottery_open_code = lotteryParameter->>'opencode';
--判断是否需要开奖派彩
IF lottery_expect = ''  or lottery_code='' THEN
RETURN ERROR_PARAMETER;
END IF;

IF NOT EXISTS  (SELECT * FROM lottery_bet_order WHERE expect=lottery_expect AND code=lottery_code AND status='1' ) THEN
RETURN ERROR_NOT_NEED;
END IF;

IF lotteryResultJson is null or lotteryResultJson = '' THEN
  RETURN ERROR_NOT_WINNING_RECORD;
END IF;

for resultJson in select json_array_elements(lotteryResultJson::json)
loop
    select resultJson::json->>'expect' into p_expect;
    select resultJson::json->>'code' into p_code;
    select resultJson::json->>'play_code' into p_play_code;
    select resultJson::json->>'bet_code' into p_bet_code;
    select resultJson::json->>'winning_num' into p_winning_num;
    IF p_winning_num='平局' THEN
    UPDATE lottery_bet_order  SET c_payout = 0, b_payout = 0,payout_time = now(), status='2' WHERE expect=p_expect AND code=p_code AND status='1' AND play_code= p_play_code AND bet_code=p_bet_code;
	 ELSE
    UPDATE lottery_bet_order SET c_payout = trunc(bet_amount * c_odd1, 2), b_payout = trunc(bet_amount * b_odd1, 2), payout_time = now(), status = '2' WHERE expect = p_expect AND code = p_code AND status = '1' AND play_code = p_play_code AND bet_code = p_bet_code AND bet_num = p_winning_num;
	 END IF;
  END loop;

--中奖记录之外的投注派彩全部为0
UPDATE lottery_bet_order  SET c_payout = -bet_amount, b_payout = -bet_amount, payout_time = now(), status = '2' WHERE expect = p_expect AND code = p_code AND status = '1';

return MSG_SUCCESS;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

COMMENT ON FUNCTION "lottery_payout_pk10"("lotteryresultjson" text, "lotteryparameter" json) IS 'PK10派彩';