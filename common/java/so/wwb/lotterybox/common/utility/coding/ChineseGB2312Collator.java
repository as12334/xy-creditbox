package so.wwb.lotterybox.common.utility.coding;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Locale;

public class ChineseGB2312Collator {
    /**
     * @return a customized RuleBasedCollator with Chinese characters (GB2312) sorted correctly
     * 
     */
    public  static  final  RuleBasedCollator  getFixedGB2312Collator()
    {
        RuleBasedCollator  fixedGB2312Collator =null ;
        try
        {
            fixedGB2312Collator = new  RuleBasedCollator (
                    ChineseGB2312Collator.getGB2312SpecialChars() +
                    GB2312Chars
                    );
        }catch (ParseException  e)
        {
            e.printStackTrace();
        }
        return  fixedGB2312Collator;
    }
    
    /**
     * @return the special characters in GB2312 charset.
     * 
     */
    public  static  final  String  getGB2312SpecialChars()
    {
        RuleBasedCollator  zh_CNCollator = (RuleBasedCollator )Collator .getInstance(Locale .CHINA);
        //index 2125 is the last symbol "╋"
        return  zh_CNCollator.getRules().substring(0,2125);
    }
    
    /**
     * 6763 Chinese characters in GB2312 charset
     */
    public  static  final  String  GB2312Chars =
        "<吖<阿<啊< 锕<嗄<哎<哀<唉<埃<挨<锿<捱<皑<癌<嗳<矮<蔼< 霭<艾<爱<砹<隘<嗌<嫒<碍<暧<瑷<安<桉<氨<庵< 谙<鹌<鞍<俺<埯<铵<揞<犴<岸<按<案<胺<暗<黯< 肮<昂<盎<凹<坳<敖<嗷<廒<獒<遨<熬<翱<聱<螯< 鳌<鏖<拗<袄<媪<岙<傲<奥<骜<澳<懊<鏊"  +
        "<八<巴<叭< 扒<吧<岜<芭<疤<捌<笆<粑<拔<茇<菝<跋<魃<把< 钯<靶<坝<爸<罢<鲅<霸<灞<掰<白<百<佰<柏<捭< 摆<呗<败<拜<稗<扳<班<般<颁<斑<搬<瘢<癍<阪< 坂<板<版<钣<舨<办<半<伴<扮<拌<绊<瓣<邦<帮< 梆<浜<绑<榜<膀<蚌<傍<棒<谤<蒡<磅<镑<勹<包< 孢<苞<胞<煲<龅<褒<雹<宝<饱<保<鸨<堡<葆<褓< 报<抱<豹<趵<鲍<暴<爆<陂<卑<杯<悲<碑<鹎<北< 贝<狈<邶<备<背<钡<倍<悖<被<惫<焙<辈<碚<蓓< 褙<鞴<鐾<奔<贲<锛<本<苯<畚<坌<笨<崩<绷<嘣< 甭<泵<迸<甏<蹦<逼<荸<鼻<匕<比<吡<妣<彼<秕< 俾<笔<舭<鄙<币<必<毕<闭<庇<畀<哔<毖<荜<陛< 毙<狴<铋<婢<庳<敝<萆<弼<愎<筚<滗<痹<蓖<裨< 跸<辟<弊<碧<箅<蔽<壁<嬖<篦<薜<避<濞<臂<髀< 璧<襞<边<砭<笾<编<煸<蝙<鳊<鞭<贬<扁<窆<匾< 碥<褊<卞<弁<忭<汴<苄<拚<便<变<缏<遍<辨<辩< 辫<灬<杓<彪<标<飑<髟<骠<膘<瘭<镖<飙<飚<镳< 表<婊<裱<鳔<憋<鳖<别<蹩<瘪<宾<彬<傧<斌<滨< 缤<槟<镔<濒<豳<摈<殡<膑<髌<鬓<冫<冰<兵<丙< 邴<秉<柄<炳<饼<禀<并<病<摒<拨<波<玻<剥<钵< 饽<啵<脖<菠<播<伯<孛<驳<帛<泊<勃<亳<钹<铂< 舶<博<渤<鹁<搏<箔<膊<踣<薄<礴<跛<簸<擘<檗< 逋<钸<晡<醭<卜<卟<补<哺<捕<不<布<步<怖<钚< 部<埠<瓿<簿"  ;
}
