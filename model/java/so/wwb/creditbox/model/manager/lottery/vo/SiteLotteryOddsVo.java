package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.manager.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.manager.lottery.so.SiteLotteryOddsSo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 值对象
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
//region your codes 1
public class SiteLotteryOddsVo extends BaseObjectVo<SiteLotteryOdds, SiteLotteryOddsSo, SiteLotteryOddsVo.SiteLotteryOddsQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 1512323731168965695L;

    //可用彩种集合
    private  List<SiteLottery> siteLotteryList;
    //赔率设置集合
    private Map<String,SiteLotteryOdds> oddsMap;



    //赔率设置保存一行数据，要对应更改数据库多行记录
    public static Map<String,Map<String,String>> betSortMap = new LinkedHashMap<>();

    static {
        //对应的bet_sort
        Map<String,String> map= new LinkedHashMap<>();
//        1-5單碼
        map.put("1_1","1_10,4_16,4_19,7_30,7_33,7_37,10_50,13_59,1_3,1_9,4_15,1_7,4_17,4_18,4_20,4_21,7_29,7_31,7_32,7_34,7_36,7_38,10_43,10_44,10_45,10_48,10_49,10_52,13_57,13_58,13_60,13_62,13_64,13_66,1_1,1_2,1_4,1_5,1_6,1_8,4_22,4_23,4_24,7_35,10_46,10_47,10_51,13_61,13_63,13_65");
//        1-5大小
        map.put("2_11","11_54,14_67,2_11,2_12,5_25,5_26,8_39,8_40,11_53,14_68");
//        1-5單雙
        map.put("3_13","9_42,3_14,6_27,12_55,15_69,3_13,6_28,9_41,12_56,15_70");
//        總和大小
        map.put("16_71","16_72,16_71");
//        總和單雙
        map.put("17_73","17_73,17_74");
//        龍虎
        map.put("18_75","18_75,18_76");
//        和
        map.put("18_77","18_77");
//        豹子
        map.put("19_78","20_83,19_78,21_88");
//        順子
        map.put("19_79","21_89,19_79,20_84");
//        對子
        map.put("19_80","20_85,21_90,19_80");
//        半順
        map.put("19_81","19_81,20_86,21_91");
//        雜六
        map.put("19_82","19_82,21_92,20_87");
        betSortMap.put(LotteryEnum.CQSSC.getCode(),map);

        map= new LinkedHashMap<>();
//        1-10單碼
        map.put("1_1","1_10,4_19,7_33,7_37,9_42,10_50,11_54,14_67,16_72,20_83,21_89,1_3,1_9,1_7,4_17,4_18,4_20,4_21,5_25,5_26,7_34,7_36,7_38,8_39,8_40,10_49,10_52,11_53,12_55,13_57,13_58,13_66,14_68,15_69,16_71,17_73,19_81,19_82,20_84,20_85,20_86,21_88,21_90,1_1,1_2,1_4,1_5,1_6,1_8,4_22,4_23,4_24,7_35,9_41,10_51,12_56,13_65,15_70,17_74,20_87");
//        1-10大小
        map.put("2_11","25_105,6_27,10_43,10_44,2_11,2_12,18_75,18_76,22_91,22_92,25_106,28_119,28_120,31_133,31_134,6_28,14_59,14_60,34_147,34_148");
//        1-10單雙
        map.put("3_13","23_93,3_13,19_77,19_78,23_94,26_107,26_108,29_121,29_122,32_135,32_136,3_14,7_29,7_30,11_45,11_46,15_61,15_62,35_149,35_150");
//        1-5龍虎
        map.put("4_15","20_80,8_32,16_64,4_15,20_79,4_16,8_31,12_47,12_48,16_63");
//        冠亞大
        map.put("37_168","37_168");
//        冠亞小
        map.put("37_169","37_169");
//        冠亞單
        map.put("38_170","38_170");
//        冠亞雙
        map.put("38_171","38_171");
        betSortMap.put(LotteryEnum.BJPK10.getCode(),map);
        betSortMap.put(LotteryEnum.XYFT.getCode(),map);


        map= new LinkedHashMap<>();
        map.put("1_1","81_9,81_1,81_5,81_15,86_37,86_43,91_58,91_69,91_75,96_86,96_93,96_99,101_115,101_114,101_123,101_126,101_130,101_131,106_141,106_147,106_154,111_170,111_176,111_182,116_198,116_206,116_213,81_2,81_3,81_4,81_6,81_7,81_8,81_10,81_11,81_12,81_17,81_18,81_19,81_20,86_29,86_33,86_34,86_35,86_36,86_38,86_39,86_40,86_41,86_42,86_44,86_45,86_46,86_47,86_48,91_57,91_59,91_60,91_61,91_62,91_63,91_64,91_70,91_71,91_72,91_73,91_74,91_76,96_85,96_89,96_90,96_91,96_92,96_94,96_95,96_96,96_97,96_98,96_100,96_101,96_102,96_103,96_104,101_113,101_116,101_117,101_118,101_119,101_120,101_121,101_124,101_125,101_127,101_128,101_129,101_132,106_142,106_143,106_144,106_145,106_146,106_148,106_149,106_150,106_151,106_152,106_153,106_155,106_156,106_157,106_159,106_160,111_169,111_171,111_172,111_173,111_174,111_175,111_177,111_178,111_179,111_180,111_181,111_184,111_185,111_186,111_187,111_188,116_197,116_199,116_200,116_201,116_202,116_203,116_204,116_207,116_209,116_210,116_211,116_212,116_214,116_215,116_216,81_13,81_14,81_16,86_30,86_31,86_32,91_65,91_66,91_67,91_68,96_87,96_88,101_122,106_158,111_183,116_205,116_208");
        map.put("82_21","82_22,87_49,107_161,112_190,11_246,82_21,87_50,92_77,97_106,102_134,107_162,112_189,117_217,117_218,92_78,97_105,102_133,11_245");
        map.put("83_23","88_51,98_107,118_220,11_246,12_247,12_248,83_23,83_24,88_52,93_79,93_80,98_108,103_135,103_136,108_163,108_164,113_191,113_192,118_219,11_245");
        map.put("121_251","123_256,127_264,129_267,133_276,135_281,121_253,121_254,129_269,121_251,121_252,123_255,123_257,123_258,125_259,125_260,125_261,125_262,127_263,127_265,127_266,129_268,129_270,131_272,131_273,131_274,133_275,133_277,133_278,135_279,135_280,135_282,131_271");
//                1-8尾大小
        map.put("84_27","94_83,109_168,114_196,94_84,84_27,89_55,89_56,99_111,99_112,104_139,104_140,109_167,114_195,119_223,119_224,84_28");
//                1-8合單雙
        map.put("85_25","95_82,110_166,115_194,85_25,85_26,90_54,95_81,100_110,105_138,110_165,115_193,120_221,120_222,90_53,100_109,105_137");
//                1-8中發白-中發
        map.put("122_283","124_287,128_292,132_299,134_301,122_283,122_284,124_286,126_289,126_290,128_293,130_295,130_296,132_298,134_302,136_304,136_305");
//                1-8中發白-白
        map.put("122_285","122_285,126_291,136_306,124_288,128_294,130_297,132_300,134_303");
//                總和大小
        map.put("11_245","11_245,11_246");
//                總和單雙
        map.put("12_247","12_247,12_248");
//                總和尾大小
        map.put("13_249","13_249,13_250");
//                總和龍虎
        map.put("80_307","80_307,80_308");


//                任選二
        map.put("72_1","72_1,72_5,72_9,72_17,72_2,72_6,72_10,72_14,72_3,72_7,72_11,72_15,72_19,72_8,72_12,72_16,72_20,72_13,72_18,72_4");
//                選二連組
        map.put("74_1","74_9,74_7,74_1,74_5,74_13,74_17,74_2,74_6,74_10,74_14,74_18,74_3,74_11,74_15,74_19,74_4,74_8,74_12,74_16,74_20");
//                任選三
        map.put("75_1","75_5,75_6,75_11,75_16,75_1,75_9,75_13,75_17,75_2,75_10,75_14,75_18,75_3,75_7,75_15,75_19,75_4,75_8,75_12,75_20");
//                選三前組
        map.put("77_1","77_1,77_5,77_9,77_13,77_17,77_6,77_10,77_14,77_18,77_3,77_7,77_11,77_15,77_4,77_8,77_12,77_16,77_20,77_2,77_19");
//                任選四
        map.put("78_1","78_1,78_5,78_9,78_17,78_2,78_6,78_10,78_18,78_3,78_7,78_11,78_15,78_4,78_8,78_12,78_16,78_20,78_13,78_14,78_19");
//                任選五
        map.put("79_1","79_5,79_9,79_13,79_17,79_6,79_10,79_14,79_18,79_3,79_11,79_15,79_19,79_4,79_8,79_16,79_20,79_1,79_2,79_7,79_12");

        betSortMap.put(LotteryEnum.GDKL10.getCode(),map);
    }

    private String lotteryOddsJson;

    private String[] betSorts;

    public String getLotteryOddsJson() {
        return lotteryOddsJson;
    }

    public void setLotteryOddsJson(String lotteryOddsJson) {
        this.lotteryOddsJson = lotteryOddsJson;
    }

    public String[] getBetSorts() {
        return betSorts;
    }

    public void setBetSorts(String[] betSorts) {
        this.betSorts = betSorts;
    }

    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class SiteLotteryOddsQuery extends AbstractQuery<SiteLotteryOddsSo> {

        //region your codes 6
        private static final long serialVersionUID = -8595652773641667966L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    public List<SiteLottery> getSiteLotteryList() {
        return siteLotteryList;
    }

    public void setSiteLotteryList(List<SiteLottery> siteLotteryList) {
        this.siteLotteryList = siteLotteryList;
    }

    public Map<String, SiteLotteryOdds> getOddsMap() {
        return oddsMap;
    }

    public void setOddsMap(Map<String, SiteLotteryOdds> oddsMap) {
        this.oddsMap = oddsMap;
    }



    //endregion your codes 4

}