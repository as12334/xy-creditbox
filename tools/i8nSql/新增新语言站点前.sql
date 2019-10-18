/**
 * 以下脚本均在gb-companies库, 请注意修改对应语言（语言代号，货币代号）
 */
-- 字典：支持货币
INSERT INTO sys_dict ("module", "dict_type", "dict_code", "order_num", "remark", "parent_code", "active")
SELECT 'common', 'currency', 'JPY', '4', '货币代码：JPY日元', NULL, TRUE WHERE NOT EXISTS (SELECT "id" FROM sys_dict WHERE dict_type = 'currency' AND dict_code = 'JPY');

-- 字典：语言类型
INSERT INTO sys_dict ("module", "dict_type", "dict_code", "order_num", "remark", "parent_code", "active")
SELECT 'common', 'language', 'ja_JP', '4', '语言类型：日语', NULL, TRUE WHERE NOT EXISTS (SELECT "id" FROM sys_dict WHERE dict_type = 'language' AND dict_code = 'ja_JP');

-- 站点经营地区
INSERT INTO site_operate_area ("site_id", "code", "status", "area_ip", "open_time")
SELECT -1, 'JP', '1', '', now() WHERE NOT EXISTS (SELECT "id" FROM site_operate_area WHERE site_id = -1 AND code = 'JP');

-- 站点语言
INSERT INTO site_language ("site_id", "language", "status", "logo", "open_time")
SELECT -1, 'ja_JP', '1', 'images/language/japan.png', now() WHERE NOT EXISTS (SELECT "id" FROM site_language WHERE site_id = -1 AND language = 'ja_JP');

-- 站点货币
INSERT INTO site_currency ("site_id", "code", "status")
SELECT -1, 'JPY', '1' WHERE NOT EXISTS (SELECT "id" FROM site_currency WHERE site_id = -1 AND code = 'JPY');

-- 系统货币
INSERT INTO sys_currency (id, code, status, center_id, currency_sign)
SELECT 3, 'JPY', TRUE, -3, '￥' WHERE NOT EXISTS (SELECT "id" FROM sys_currency WHERE code = 'JPY');