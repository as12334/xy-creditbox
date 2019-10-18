package so.wwb.lotterybox.web.tools;

import com.google.gson.Gson;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.error.ErrorCodeEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author:wilson
 * @function:common_function_for_web_common_business
 */
public class CommonTool {
    private static final Log log = LogFactory.getLog(CommonTool.class);
    private static final Gson gson = new Gson();


    //region check execution result
    private static boolean checkString(String strResult) {
        strResult = strResult.trim();
        if (strResult.length() <= 0) return false;
        else if (strResult.endsWith("500")) return false;
        else return !strResult.endsWith("404");
    }

    private static boolean checkExecutionResult(Object result) {
        Boolean executionResult = false;
        if (result instanceof Boolean) {
            if ((Boolean) result) executionResult = true;
        } else if (result instanceof Map) {
            executionResult = ((Map) result).get("auditResult").equals("success");
        } else if (result instanceof String) {
            executionResult = checkString((String) result);
        }
        return executionResult;
    }

    //region response write to browser
//    public static void responseWriteApi(HttpServletResponse response, ApiCodeEnum apiCodeEnum) {
//        try {
////            ErrorEnvelope errorEnvelope = new ErrorEnvelope();
////            errorEnvelope.setCodeEnum(apiCodeEnum);
//            response.setContentType("text/html;charset=utf-8");
////            response.getWriter().write(JsonTool.toJson(errorEnvelope));
//            response.getWriter().flush();
//            response.getWriter().close();
//        } catch (IOException ex) {
//            log.error("IO Exception happened, details: ", ex);
//        }
//    }

    public static void responseWriteWeb(HttpServletResponse response, ErrorCodeEnum errorCodeEnum) {
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(JsonTool.toJson(errorCodeEnum));
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException ex) {
            log.error("IO Exception happened, details: ", ex);
        }
    }
    //endregion

    //region get http
    public static String getHttp(HttpServletRequest request) {
        String strHttp = request.getHeader("X-Forwarded-Scheme");
        if (StringTool.isEmpty(strHttp)) strHttp = request.getScheme();
        return strHttp;
    }
    //endregion

    //region get port
    public static String getPort(HttpServletRequest request) {
        String strPort = request.getHeader("X-Forwarded-Port");
        if (StringTool.isEmpty(strPort)) strPort = String.valueOf(request.getServerPort());
        return strPort;
    }
    //endregion
}