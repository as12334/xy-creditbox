package so.wwb.lotterybox.web.passport.captcha;

import com.google.code.kaptcha.util.Config;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.web.shiro.common.captcha.ICaptchaStyleResolver;
import so.wwb.lotterybox.model.base.ParamTool;
import so.wwb.lotterybox.web.captcha.DefaultCaptchaConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by longer on 12/22/15.
 */
public class CaptchaStyleResovler implements ICaptchaStyleResolver {

    private DefaultCaptchaConfig defaultCaptchaConfig;

    @Override
    public String getStyle(ContextParam contextParam) {
        return ParamTool.getCaptchaStyle();
    }

    @Override
    public Config custom(Config config) {
        String exclude = ParamTool.getCaptchaExclusion();
        if (StringTool.isBlank(exclude)) {
            return config;
        }
        return new MyConfig(config,exclude);
    }

    @Override
    public Config getDefault() {
        return defaultCaptchaConfig.getConfig();
    }

    class MyConfig extends Config{

        private Config config = null;
        private String exclude = null;

        public MyConfig(Properties properties) {
            super(properties);
        }

        public MyConfig(Config config,String exclude) {
            super(config.getProperties());
            this.config = config;
            this.exclude = exclude;
        }

        @Override
        public char[] getTextProducerCharString() {
            char[] chars = config.getTextProducerCharString();
            if (StringTool.isBlank(exclude)){
                return chars;
            }

            List<Integer> characters = new ArrayList<>();
            for (char aChar : chars) {
                int idx = ArrayTool.indexOf(exclude.toCharArray(),aChar);
                if (idx == -1) {
                    characters.add(Integer.valueOf((int)aChar));
                }
            }
            char[] rs = new char[characters.size()];
            for (int i = 0; i < rs.length; i++ ) {
                rs[i] = (char)characters.get(i).intValue();
            }
            return rs;
        }

    }

    public void setDefaultCaptchaConfig(DefaultCaptchaConfig defaultCaptchaConfig) {
        this.defaultCaptchaConfig = defaultCaptchaConfig;
    }
}
