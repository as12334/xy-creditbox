package so.wwb.creditbox.model.enums.common;

import org.soul.commons.enums.ICodeEnum;

/**
 * Created by Cherry on 16-7-4.
 */
public enum TimezoneEnum implements ICodeEnum {
    GMT0100("GMT-01:00", "(GMT-1)亚速尔、佛得角"),
    GMT0200("GMT-02:00", "(GMT-2)中大西洋"),
    GMT0300("GMT-03:00", "(GMT-3)巴西、阿根廷"),
    GMT0400("GMT-04:00", "(GMT-4)大西洋时间"),
    GMT0500("GMT-05:00", "(GMT-5)美东时间"),
    GMT0600("GMT-06:00", "(GMT-6)美中时间"),
    GMT0700("GMT-07:00", "(GMT-7)山地时间"),
    GMT0800("GMT-08:00", "(GMT-8)美西时间"),
    GMT0900("GMT-09:00", "(GMT-9)阿拉斯加"),
    GMT1000("GMT-10:00", "(GMT-10)夏威夷"),
    GMT1100("GMT-11:00", "(GMT-11)萨摩亚群岛、中途岛"),
    GMT1200("GMT-12:00", "(GMT-12)日界线西"),
    GMT0000("GMT+00:00", "(GMT0)西欧时间、伦敦"),
    GMT2100("GMT+01:00", "(GMT+1)中欧时间、巴黎"),
    GMT2200("GMT+02:00", "(GMT+2)东欧时间、赫尔辛基"),
    GMT2300("GMT+03:00", "(GMT+3)巴格达、莫斯科"),
    GMT2400("GMT+04:00", "(GMT+4)阿布扎比、巴库"),
    GMT2500("GMT+05:00", "(GMT+5)伊斯兰堡、卡拉奇"),
    GMT2600("GMT+06:00", "(GMT+6)阿拉木图、科伦坡"),
    GMT2700("GMT+07:00", "(GMT+7)河内、曼谷"),
    GMT2800("GMT+08:00", "(GMT+8)北京、香港"),
    GMT2900("GMT+09:00", "(GMT+9)首尔、东京"),
    GMT3000("GMT+10:00", "(GMT+10)悉尼、关岛"),
    GMT3100("GMT+11:00", "(GMT+11)马加丹、索罗门群岛"),
    GMT3200("GMT+12:00", "(GMT+12)惠灵顿、堪察加半岛");


    private String code;
    private String trans;

    TimezoneEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }
}
