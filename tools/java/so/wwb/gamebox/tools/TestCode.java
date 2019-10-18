package so.wwb.gamebox.tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.soul.commons.bean.Pair;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.init.context.Const;
import org.soul.commons.lang.string.RandomStringTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.net.IpTool;
import org.soul.commons.security.Base36;
import sun.misc.Unsafe;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 16-4-6.
 */
public class TestCode {


    private static final Pattern SCRIPT_PREFIX = Pattern.compile("<\\s*script\\s*>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static final Pattern SCRIPT_SUBFIX = Pattern.compile("<\\s*/\\s*script\\s*>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static final Pattern SPECIAL_CHARACTER_SUBFIX = Pattern.compile("\\(");
    private static List<Pattern> filters = new ArrayList<>(3);
    static {
        filters.add(SCRIPT_PREFIX);
        filters.add(SCRIPT_SUBFIX);
        filters.add(SPECIAL_CHARACTER_SUBFIX);
    }

    private static int index = 0;

    /**
     * 将被解码的字符
     */
    private static String[][] BE_DECODE_CHARS = {
            {"%","%25"},
            {">","&gt;"},
            {"<","&lt;"},
            {"&","&amp;"},
            {"\"","&quot;"},
            {"'","&#x27;"},
            {"/","&#x2f;"}
    };

    public static void main(String[] args) {
      /*  String MG_JACKPOT_REQUEST_URL ="http://www.tickerassist.co.uk/ProgressiveTickers/WebServiceProgressiveTickerXMLAll.asmx/tickerXMLFeedAll";
        String xmlResult  = HttpClientTool.sync(new HttpClientParam(MG_JACKPOT_REQUEST_URL,null, HttpRequestMethod.GET));
        System.out.println(xmlResult);*/
//        testPattern();
//        testIpTool();
//        encryptIgnoreCase("dsd6tw"+3698);
//        decryptIgnoreCase("AIFC52FM1MH");
//        testExecutor();
//        testObjectAddress();
//        testApiJsonDs();
    }

    private static void testObjectAddress() {
        ApiResult a = new ApiResult();
        List list = new ArrayList<>();
        try {
            list.add(a);
            System.out.println("==========");
            System.out.println(addressOf(a));
            System.out.println(addressOf(list));
            System.out.println(addressOf(list.get(0)));
            a = new ApiResult();
            list.add(a);
            System.out.println("==========");
            System.out.println(addressOf(a));
            System.out.println(addressOf(list));
            System.out.println("第一个元素地址："+addressOf(list.get(0)));
            System.out.println("第二个元素地址："+addressOf(list.get(1)));
            a = new ApiResult();
            list.add(a);
            System.out.println("==========");
            System.out.println(addressOf(a));
            System.out.println(addressOf(list));
            System.out.println("第一个元素地址："+addressOf(list.get(0)));
            System.out.println("第二个元素地址："+addressOf(list.get(1)));
            System.out.println("第三个元素地址："+addressOf(list.get(2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Unsafe unsafe;

    static
    {
        try
        {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static long addressOf(Object o)
            throws Exception
    {
        Object[] array = new Object[] {o};

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize)
        {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }

        return(objectAddress);
    }



    private static void testApiJson(){
        String resultJson = " {\"betId\":\"67215204\",\"betTime\":\"2016-11-28T02:23:50.693-04:00\",\"memberCode\":\"119_nu9r5lsrgu\",\"matchDateTime\":\"2016-11-28T02:25:30-04:00\",\"sportsName\":\"Virtual Basketba\n" +
                "ll\",\"matchID\":\"6036076\",\"leagueName\":\"Virtual Basketball League\",\"homeTeam\":\"Dallas\",\"awayTeam\":\"Oklahoma\",\"favouriteTeamFlag\":\"H\",\"betType\":\"1STHALFOU\",\"selection\":\"H\",\"handicap\":\"94.50\",\"od\n" +
                "dsType\":\"HK\",\"odds\":\"1.3800\",\"currency\":\"RMB\",\"betAmt\":99.0,\"result\":-99.0,\"htHomeScore\":\"54\",\"htAwayScore\":\"40\",\"ftHomeScore\":null,\"ftAwayScore\":null,\"betHomeScore\":\"0\",\"betAwayScore\":\"0\",\"s\n" +
                "ettled\":\"1\",\"betCancelled\":\"0\",\"bettingMethod\":\"INTERNET\",\"btStatus\":null,\"btCommision\":null,\"parlayBetDetails\":null}";
        String resultJson1= "{\"betId\":\"65749319\",\"betTime\":\"2016-10-30T22:53:15.31-04:00\",\"memberCode\":\"119_P1605178L6RIPWWW\",\"matchDateTime\":\"2016-10-31T11:05:00-04:00\",\"sportsName\":\"Soccer\",\"matchID\":\"0\",\"leagueName\":\"\",\"homeTeam\":null,\"awayTeam\":null,\"favouriteTeamFlag\":null,\"betType\":\"PARLAYALL\",\"selection\":null,\"handicap\":null,\"oddsType\":\"EURO\",\"odds\":\"0.0000\",\"currency\":\"RMB\",\"betAmt\":5.0,\"result\":16.3,\"htHomeScore\":null,\"htAwayScore\":null,\"ftHomeScore\":null,\"ftAwayScore\":null,\"betHomeScore\":\"0\",\"betAwayScore\":\"0\",\"settled\":\"1\",\"betCancelled\":\"0\",\"bettingMethod\":\"INTERNET\",\"btStatus\":null,\"btCommision\":null,\"parlayBetDetails\":[{\"betId\":\"65749319\",\"parlaySign\":\"-\",\"parlayBetType\":\"FT - Handicap\",\"parlayBetOn\":\"H\",\"parlayHandicap\":\"1.00\",\"parlayOdds\":\"2.1300\",\"parlayFavoriteTeamFlag\":\"H\",\"parlayLeagueName\":\"Australia A-League\",\"parlayBetCancelled\":\"0\",\"parlayTeamAway\":\"Wellington Phoenix FC\",\"parlayTeamHome\":\"Melbourne Victory FC\",\"parlayBetTime\":\"2016-10-30T22:53:15.31-04:00\",\"parlayMatchDateTime\":\"2016-10-31T04:55:00-04:00\",\"parlaySportName\":\"Soccer\",\"parlayHTHomeScore\":\"2\",\"parlayHTAwayScore\":\"0\",\"parlayFTHomeScore\":\"6\",\"parlayFTAwayScore\":\"1\",\"parlayBetHomeScore\":\"0\",\"parlayBetAwayScore\":\"0\",\"matchId\":\"5792564\"},{\"betId\":\"65749319\",\"parlaySign\":\"-\",\"parlayBetType\":\"FT - Handicap\",\"parlayBetOn\":\"H\",\"parlayHandicap\":\"0.25\",\"parlayOdds\":\"2.0000\",\"parlayFavoriteTeamFlag\":\"H\",\"parlayLeagueName\":\"Russia Premier League\",\"parlayBetCancelled\":\"0\",\"parlayTeamAway\":\"Krylia Sovetov\",\"parlayTeamHome\":\"FC Orenburg\",\"parlayBetTime\":\"2016-10-30T22:53:15.31-04:00\",\"parlayMatchDateTime\":\"2016-10-31T10:00:00-04:00\",\"parlaySportName\":\"Soccer\",\"parlayHTHomeScore\":\"0\",\"parlayHTAwayScore\":\"0\",\"parlayFTHomeScore\":\"1\",\"parlayFTAwayScore\":\"0\",\"parlayBetHomeScore\":\"0\",\"parlayBetAwayScore\":\"0\",\"matchId\":\"5807322\"},{\"betId\":\"65749319\",\"parlaySign\":\"+\",\"parlayBetType\":\"FT - Handicap\",\"parlayBetOn\":\"A\",\"parlayHandicap\":\"0.00\",\"parlayOdds\":\"2.2000\",\"parlayFavoriteTeamFlag\":\"H\",\"parlayLeagueName\":\"Germany Regionalliga North\",\"parlayBetCancelled\":\"0\",\"parlayTeamAway\":\"FC St. Pauli II\",\"parlayTeamHome\":\"Eintracht Braunschweig II\",\"parlayBetTime\":\"2016-10-30T22:53:15.31-04:00\",\"parlayMatchDateTime\":\"2016-10-31T11:05:00-04:00\",\"parlaySportName\":\"Soccer\",\"parlayHTHomeScore\":\"0\",\"parlayHTAwayScore\":\"1\",\"parlayFTHomeScore\":\"2\",\"parlayFTAwayScore\":\"2\",\"parlayBetHomeScore\":\"0\",\"parlayBetAwayScore\":\"0\",\"matchId\":\"5820488\"}]}";
        JSONObject object = JSONObject.parseObject(resultJson);

        JSONObject object1 = JSONObject.parseObject(resultJson1);
        String betType = object1.getString("betType");
        String selection = object1.getString("selection");
        String handicap = object1.getString("handicap");
        ApiResult apiResult = new ApiResult();
        apiResult.setBetType(betType);
        apiResult.setSelection(selection);
        apiResult.setHandicap(handicap);
        List<ApiResult> apiResultList = new ArrayList<>();
        if (StringTool.isNotBlank(object1.getString("parlayBetDetails"))){
            JSONArray jsonArray = JSONObject.parseArray(object1.getString("parlayBetDetails"));
            System.out.println(jsonArray.size());
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
//                System.out.println(obj.getString("parlayBetType"));
                String parlayBetType = obj.getString("parlayBetType");
                String parlayBetOn = obj.getString("parlayBetOn");
                String parlayHandicap = obj.getString("parlayHandicap");
                ApiResult apiResult1 = new ApiResult();
                apiResult1.setBetType(parlayBetType);
                apiResult1.setSelection(parlayBetOn);
                apiResult1.setHandicap(parlayHandicap);
                apiResultList.add(apiResult1);
            }
            apiResult.setApiResultList(apiResultList);

        }
        System.out.println(JSONObject.toJSON(apiResult));
        System.out.println(JsonTool.toJson(apiResult));

    }


    private static void testApiJsonDs(){
        String resultJson = " {\"id\":122955648,\"sequenceNo\":54066,\"userName\":\"98phynfif8\",\"currency\":\"CNY\",\"gameType\":\"BULL_BULL\",\"tableInfoId\":10,\"shoeInfoId\":1,\"gameInfoId\":127388,\"tableName\":\"09\n" +
                "\",\"issueNo\":\"127388\",\"bankerResult\":\"[2,12,0,21,0,9,25,1,7,24,1]~[[3],[35,44,12,2,45],[33,6,21,41,47],[4,28,25,20,19],[24,9,46,23,14]]\",\"resultList\":[2,12,0,21,0,9,25,1,7,24,1],\"pokerList\":[[\n" +
                "3],[35,44,12,2,45],[33,6,21,41,47],[4,28,25,20,19],[24,9,46,23,14]],\"stakeAmount\":30.0,\"validStake\":30.0,\"winLoss\":-30.0,\"comm\":0,\"balanceAfter\":140.75,\"endTime\":1480153526000,\"ip\":\"1.196.223\n" +
                ".10\",\"resultImgName\":\"tableId=11&fileName=a7cc8873-7af7-470a-b048-137cb6dd854c.jpg\",\"tips\":0,\"liveMemberReportDetails\":[{\"betType\":\"BB_PALYER1_EQUAL\",\"betAmount\":30.0,\"winLossAmount\":-30.0,\"b\n" +
                "etTime\":1480153419000}]}";
        JSONObject object = JSONObject.parseObject(resultJson);

        JSONArray jsonArray1  = JSONObject.parseArray(object.getString("liveMemberReportDetails"));
        for (int i = 0; i < jsonArray1.size(); i++) {
            JSONObject obj = jsonArray1.getJSONObject(i);
            System.out.println(obj.getString("betType"));
        }

        JSONArray jsonArray = JSONObject.parseArray(object.getString("pokerList"));
        ApiResult apiResult = new ApiResult();
        Set set = new LinkedHashSet<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONArray j = jsonArray.getJSONArray(i);
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < j.size(); k++) {
                list.add(j.getInteger(k));
            }
            set.add(list);
        }
        apiResult.setPorkerList(set);
//        System.out.println(JSONObject.toJSON(apiResult));
//        System.out.println(JsonTool.toJson(apiResult));
    }

    public static Map<String,Integer> porkerMap = new HashMap<>();

    private static void testApiJsonGd(){
        String resultJson = " {\"no\":\"12\",\"userID\":\"nu9ryj9tuq\",\"betTime\":\"11/28/2016 14:51:57\",\"balanceTime\":\"11/28/2016 14:52:34\",\"productID\":\"Baccarat\",\"gameInterface\":\"3D Baccarat\",\"betID\":\"b5e\n" +
                "dd046-a59e-4850-a6c3-89c9e258919e\",\"betType\":\"single\",\"betAmount\":30.0,\"winLoss\":0.0,\"betResult\":\"Loss\",\"startBalance\":null,\"endBalance\":null,\"transactionID\":null,\"odds\":null,\"betArrays\":[{\"g\n" +
                "ameID\":\"B51611281516\",\"subBetType\":\"Player\",\"gameResult\":\"P CLUB 3 HEART 7 CLUB J B HEART 2 CLUB 4\",\"winningBet\":\"Banker, Big, Super6\",\"tableID\":\"B5\",\"dealerID\":\"416\"}]}";
        JSONObject object = JSONObject.parseObject(resultJson);
        System.out.println(object.get("betArrays"));
        JSONArray jsonArray1  = JSONObject.parseArray(object.getString("betArrays"));
        List<Integer> porkerList = new ArrayList<>();
        Set<List<Integer>> porkerListSet = new LinkedHashSet<>();
        for (int i = 0; i < jsonArray1.size(); i++) {
            JSONObject obj = jsonArray1.getJSONObject(i);
            String gameResult = obj.getString("gameResult");
            System.out.println(obj.getString("gameResult"));
            String [] result = gameResult.split(" ");
            Pair<String,String> pair = new Pair<>();
            Map<String,List> porkerListMap = new HashMap<>();
            List<Pair> list = null;
            for (int j = 0; j < result.length; j++) {
                if ("P".equals(result[j])){
                    list = new ArrayList<>();
                    porkerListMap.put(result[j],list);
                    continue;
                }
                if ("B".equals(result[j])){
                    list = new ArrayList<>();
                    porkerListMap.put(result[j],list);
                    continue;
                }
                if (StringTool.isBlank(pair.getKey())){
                    pair.setKey(result[j]);
                }else if (StringTool.isBlank(pair.getValue())){
                    pair.setValue(result[j]);
                    list.add(pair);
                    pair = new Pair<>();
                }
            }
        }
        System.out.println(porkerList);
        System.out.println(porkerListSet);

    }

    private static void testApiJsonBb(){
        String resultJson = "{\"UserName\":\"p1605078l6r23wbp\",\"WagersID\":\"9014291465\",\"WagersDate\":\"2016-05-29 22:45:53\",\"SerialID\":\"86202868\",\"RoundNo\":\"16-83\",\"GameType\":\"3011\",\"WagerDetail\":\"4,1\n" +
                ":2.6,5.00,-5.00\",\"GameCode\":\"1\",\"Result\":\"3 White 1 Red\",\"Card\":\"\",\"BetAmount\":\"5\",\"Origin\":null,\"Commissionable\":\"5\",\"Payoff\":\"-5\",\"Currency\":\"RMB\",\"ExchangeRate\":\"1.000000\",\"ResultType\":\" \"\n" +
                ",\"Commission\":\"0\",\"ModifiedDate\":\"2016-05-29 22:46:17\"}";
        JSONObject object = JSONObject.parseObject(resultJson);
        System.out.println(object.get("Result"));
        String [] json = object.getString("Result").split(" ");
        System.out.println(json[0]);
        System.out.println(json[1]);

    }

    private static void testExecutor(){
        final ExecutorService executor = Executors.newFixedThreadPool(5);
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue(2048);
        for (int i = 0; i < 5; i++) {
            try {
                queue.put(String.valueOf(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for ( int i=0 ; i<=10 ;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            System.out.println("线程" +Thread.currentThread().getName() + "运行中！");
                            String s = queue.take();
                            System.out.println("消费对象："+s);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }


    private static void registCode(){
        String registCode = RandomStringTool.randomAlphanumeric(6).toLowerCase();
        System.out.println(registCode);
    }


    private static void decryptIgnoreCase(String recommendRegisterCode){
        String decryptCode = Base36.decryptIgnoreCase(recommendRegisterCode);
        System.out.println(decryptCode);
    }

    private static void encryptIgnoreCase(String recommendRegisterCode){
        String encryptCode = Base36.encryptIgnoreCase(recommendRegisterCode);
        System.out.println(encryptCode);
    }

    private static synchronized int testSyn(){

        index = count(index);
        if (index<2){
            testSyn();
        }
        System.out.println("继续调用"+ Thread.currentThread());
        return index;
    }

    private static int count(int i){
        System.out.println("调用"+i);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//        }
        return i+1;
    }

    private static void testIpTool(){
        //210.4.101.230-3523503590
        //AS_PH___
        //AS_HK_810000_810000_
        //220.168.54.181-3702011573
        //AS_CN_430000_430100_电信
        String ip = "220.168.54.181";
        long ipLong =  3523503590l;
        System.out.println(IpTool.ipv4StringToLong(ip));
        System.out.println(IpTool.ipv4LongToString(ipLong));
    }


    private static void testPattern(){
        String name = "apiId";
        String value = "\" onMouseOver=alert(3554)//";
        System.out.println(filterIllegalChars(name,value));
    }


    private static String filterIllegalChars(final String name,final String value) {
        try {
            StringBuffer sb = new StringBuffer();
            String temp = value;
            for (Pattern p : filters) {
                Matcher matcher = p.matcher(temp);
                while (matcher.find()){
                    System.out.println("==============匹配啦");
                    String matchStr = value.substring(matcher.start(), matcher.end());
                    temp = matcher.replaceAll("");
                    sb.append(matchStr);
                }
//                if (matcher.matches()) {
//                    System.out.println("==============匹配啦");
//                    String matchStr = value.substring(matcher.start(), matcher.end());
//                    temp = matcher.replaceAll("");
//                    sb.append(matchStr);
//                }
            }
            String v = decode(temp);
            return v.trim();
        } catch (UnsupportedEncodingException e) {
//            LogFactory.getLog().error(e);
        } catch (IllegalArgumentException e) {
//            LogFactory.getLog().error(e);
        }
        return null;
    }

    private static String decode(String value) throws UnsupportedEncodingException {
        String result = value;
        boolean isMatch = false;
        for( int i = 0; i < BE_DECODE_CHARS.length; i++) {
            String chars = BE_DECODE_CHARS[i][0];
            String replace = BE_DECODE_CHARS[i][1];
            if (result.indexOf(chars) != -1) {
                result = result.replaceAll(chars,replace);
                isMatch = true;
            }
        }
        if (isMatch) {
            result = URLDecoder.decode(result, Const.DEFAULT_CHARACTER);
        }
        return result;
    }
}



