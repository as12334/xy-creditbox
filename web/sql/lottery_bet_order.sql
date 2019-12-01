/*
Navicat PGSQL Data Transfer

Source Server         : lb-dev
Source Server Version : 100400
Source Host           : 192.168.0.88:5504
Source Database       : lb-sites
Source Schema         : lb-site-6

Target Server Type    : PGSQL
Target Server Version : 100400
File Encoding         : 65001

Date: 2019-12-01 21:32:03
*/


-- ----------------------------
-- Table structure for lottery_bet_order
-- ----------------------------
DROP TABLE IF EXISTS "lb-site-6"."lottery_bet_order";
CREATE TABLE "lb-site-6"."lottery_bet_order" (
"id" int4 DEFAULT nextval('"lb-site-6".lottery_bet_order_id_seq1'::regclass) NOT NULL,
"user_id" int4,
"hid" varchar(128) COLLATE "default" NOT NULL,
"username" varchar(32) COLLATE "default",
"code" varchar(32) COLLATE "default",
"expect" varchar(32) COLLATE "default",
"handicap" int4,
"bet_time" timestamp(6),
"bet_name" varchar(32) COLLATE "default" NOT NULL,
"bet_code" varchar(32) COLLATE "default",
"play_code" varchar(32) COLLATE "default",
"bet_num" varchar(32) COLLATE "default" NOT NULL,
"bet_sort" varchar(32) COLLATE "default",
"c_odd1" numeric(20,4) DEFAULT 0,
"c_odd2" numeric(20,4) DEFAULT 0,
"b_odd1" numeric(20,4) DEFAULT 0,
"b_odd2" numeric(20,4) DEFAULT 0,
"bet_amount" numeric(20,4) DEFAULT 0,
"c_payout" numeric(20,4) DEFAULT 0,
"b_payout" numeric(20,4) DEFAULT 0,
"payout_time" timestamp(6),
"status" varchar(32) COLLATE "default",
"terminal" varchar(32) COLLATE "default",
"memo" varchar(50) COLLATE "default",
"rebate8" numeric(20,4) DEFAULT 0,
"rebate7" numeric(20,4) DEFAULT 0,
"rebate6" numeric(20,4) DEFAULT 0,
"rebate5" numeric(20,4) DEFAULT 0,
"rebate4" numeric(20,4) DEFAULT 0,
"rebate3" numeric(20,4) DEFAULT 0,
"rebate2" numeric(20,4) DEFAULT 0,
"occupy7" numeric(20,4) DEFAULT 0,
"occupy6" numeric(20,4) DEFAULT 0,
"occupy5" numeric(20,4) DEFAULT 0,
"occupy4" numeric(20,4) DEFAULT 0,
"occupy3" numeric(20,4) DEFAULT 0,
"occupy2" numeric(20,4) DEFAULT 0,
"agent_id" int4,
"distributor_id" int4,
"shareholder_id" int4,
"branch_id" int4,
"company_id" int4,
"owner_user_type" varchar(5) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "lb-site-6"."lottery_bet_order" IS '投注记录表';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."id" IS '主键';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."user_id" IS '主键';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."hid" IS '主键';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."username" IS '玩家账号';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."code" IS '投注彩种';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."expect" IS '期数';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."handicap" IS '盘口 1 A盘、2 B盘 3 C盘';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."bet_time" IS '投注时间';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."bet_name" IS '彩种玩法';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."play_code" IS '投注小类代码';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."bet_num" IS '投注小类';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."bet_sort" IS '投注号码';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."c_odd1" IS '(公司)赔率';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."c_odd2" IS '(公司)连码赔率中调用第二个赔率';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."b_odd1" IS '(分公司)赔率';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."b_odd2" IS '(分公司)连码赔率中调用第二个赔率';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."bet_amount" IS '投注金额';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."c_payout" IS '(公司)派彩';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."b_payout" IS '(分公司)派彩';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."status" IS '结算状态(待结算，已结算，已撤单，已撤销) ';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."terminal" IS '终端标示';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."memo" IS '投注内容描述';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."rebate8" IS '代理退会员';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."rebate7" IS '总代理退代理';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."rebate6" IS '股东退总代理';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."rebate5" IS '分公司退股东';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."rebate4" IS '总监退分公司';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."rebate3" IS '总公司退水';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."occupy7" IS '代理占成';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."occupy6" IS '总代理占成';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."occupy5" IS '股东占成';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."occupy4" IS '分公司占成';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."occupy3" IS '总监占成';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."occupy2" IS '总公司占成';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."agent_id" IS '代理ID';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."distributor_id" IS '总代理ID';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."shareholder_id" IS '股东ID';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."branch_id" IS '分公司ID';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."company_id" IS '公司ID';
COMMENT ON COLUMN "lb-site-6"."lottery_bet_order"."owner_user_type" IS '上級用戶类型';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table lottery_bet_order
-- ----------------------------
CREATE INDEX "fk_lottery_bet_order_bet_time" ON "lb-site-6"."lottery_bet_order" USING btree ("bet_time");
CREATE INDEX "fk_lottery_bet_order_expect" ON "lb-site-6"."lottery_bet_order" USING btree ("expect");
CREATE INDEX "fk_lottery_bet_order_status" ON "lb-site-6"."lottery_bet_order" USING btree ("status");

-- ----------------------------
-- Primary Key structure for table lottery_bet_order
-- ----------------------------
ALTER TABLE "lb-site-6"."lottery_bet_order" ADD PRIMARY KEY ("id");
