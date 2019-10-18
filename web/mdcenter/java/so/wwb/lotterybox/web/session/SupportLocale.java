package so.wwb.lotterybox.web.session;

import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.CommonBeanFactory;
import org.soul.web.locale.ISupportLocale;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.manager.site.po.SiteLanguage;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SupportLocale implements ISupportLocale {
    private final static Log LOG = LogFactory.getLog(SupportLocale.class);
    @Override
    public Set<String> getSupportLocale() {
        Set<String> locales = new HashSet<>();
        if (CommonContext.get()!= null && CommonContext.get().getSiteId() != null) {
            Map<String, SiteLanguage> map = CacheBase.getSiteLanguage();
            for (String s : map.keySet()) {
                locales.add(map.get(s).getLanguage());
            }
        } else {
            locales.add(CommonBeanFactory.getCommonConf().getDefaultLocal().toString());
        }
        return locales;
    }

    public static String encodingFileName(String pFileName,HttpServletRequest request){
        String filename = null;
        try{
            String agent = request.getHeader("USER-AGENT");
            if (null != agent){
                if (-1 != agent.indexOf("Firefox")) {//Firefox
                    filename = "=?UTF-8?B?" + (new String(org.apache.commons.codec.binary.Base64.encodeBase64(pFileName.getBytes(StandardCharsets.UTF_8))))+ "?=";
                }else if (-1 != agent.indexOf("Chrome")) {//Chrome
                    filename = new String(pFileName.getBytes(), "ISO8859-1");
                } else {//IE7+
                    filename = java.net.URLEncoder.encode(pFileName, "UTF-8");
                    filename = StringTool.replace(filename, "+", "%20");//替换空格
                }
            } else {
                filename = pFileName;
            }
        }catch (UnsupportedEncodingException ex){
            filename = pFileName;
            LOG.error(ex,"转换下载文件名称出错");
        }

        return filename;
    }
}