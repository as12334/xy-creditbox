package so.wwb.lotterybox.web.tools;

import org.soul.commons.lang.string.I18nTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.LogFactory;
import org.soul.web.session.SessionManagerBase;

import java.text.MessageFormat;
import java.util.Map;

public class IpRegionTool {
    /**
     * 将IpRegionCode转换成国际化的字符
     * @param ipRegionCode
     * @return 将IpRegionCode转换成国际化的字符
     */
    public static String getIpRegion(String ipRegionCode) {
        if(StringTool.isNotBlank(ipRegionCode)){
            try{
                String[] arr=ipRegionCode.split("_",-1);
                if(arr.length>=4) {
                    Map<String, Map<String, Map<String, String>>> map = I18nTool.getDictsMap(SessionManagerBase.getLocale().toString());
                    String state = "";
                    String city = "";
                    String delta = map.get("region").get("delta").get(arr[0]);
                    String region = map.get("region").get("region").get(arr[1]);
                    if (StringTool.isNotBlank(arr[1]) && map.get("state").containsKey(arr[1])) {
                        state = map.get("state").get(arr[1]).get(arr[2]);
                    }
                    if (StringTool.isNotBlank(arr[1]) && StringTool.isNotBlank(arr[2]) && map.get("city").containsKey(arr[1] + "_" + arr[2])) {
                        city = map.get("city").get(arr[1] + "_" + arr[2]).get(arr[3]);
                    }

                    return MessageFormat.format("{0}{1}{2}{3}{4}",
                            StringTool.isBlank(delta) ? "" : delta,
                            StringTool.isBlank(region) ? "" : region,
                            StringTool.isBlank(state) ? "" : state,
                            StringTool.isBlank(city) ? "" : city,
                            arr.length == 4 ? "" : arr[4]);
                }
            }catch (Exception ex){
                LogFactory.getLog(IpRegionTool.class).error("IP地区转换错误:{0}",ipRegionCode);
                return "";
            }
        }
        return "";
    }


    /**
     * 将IpRegionCode转换成国际化的字符(不包括七大洲)
     * @param ipRegionCode
     * @return 将IpRegionCode转换成国际化的字符(不包括七大洲)
     */
    public static String getShortIpRegion(String ipRegionCode) {
        if(StringTool.isNotBlank(ipRegionCode)){
            try{
                String[] arr=ipRegionCode.split("_",-1);
                if(arr.length>=4){
                    Map<String, Map<String,Map<String,String>>> map=I18nTool.getDictsMap(SessionManagerBase.getLocale().toString());
                    String state="";
                    String city="";
                    String region= map.get("region").get("region").get(arr[1]);
                    if(StringTool.isNotBlank(arr[1]) && map.get("state").containsKey(arr[1])) {
                        state = map.get("state").get(arr[1]).get(arr[2]);
                    }
                    if(StringTool.isNotBlank(arr[1]) && StringTool.isNotBlank(arr[2]) && map.get("city").containsKey(arr[1] + "_" + arr[2])) {
                        city = map.get("city").get(arr[1] + "_" + arr[2]).get(arr[3]);
                    }
                    if(StringTool.isBlank(state)&&StringTool.isBlank(city)){
                        return MessageFormat.format("{0}{1}",StringTool.isBlank(region)?"":region,arr.length==4?"":arr[4]);
                    }else{
                        return MessageFormat.format("{0}{1}{2}",
                                StringTool.isBlank(state)?"":state,
                                StringTool.isBlank(city)?"":city,
                                arr.length==4?"":arr[4]);
                    }
                }
            }catch (Exception ex){
                LogFactory.getLog(IpRegionTool.class).error("IP地区转换错误:{0}",ipRegionCode);
                return "";
            }

        }
        return "";
    }
}
