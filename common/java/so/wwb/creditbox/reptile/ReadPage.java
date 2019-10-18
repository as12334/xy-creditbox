package so.wwb.creditbox.reptile;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadPage {
    private static final Log log = LogFactory.getLog(ReadPage.class);

    //region read page by URLConnection --- mode 1
    public static String ReadPageUrl(String strUrl) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(strUrl);
            URLConnection connection = realUrl.openConnection();
            connection.setReadTimeout(10000);
            connection.setUseCaches(true);
            connection.setAllowUserInteraction(true);
            connection.connect();

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
        } catch (Exception e) {
            System.out.println("send get request exception:" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    private static String RegexString(String strTarget, String patternStr) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(strTarget);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
    //endregion

    //region read page jsoup --- mode 2
    private static Document ReadPageJsoup(String strUrl) {
        try {
            Document document = Jsoup.connect(strUrl).get();
            return document;
        } catch (IOException e) {
            log.error("error information: ", e);
        }
        return null;
    }

    private static String FilterDocument(Document document, String strFilter1, String strFilter2) {
        Elements elements = document.select(strFilter1).select(strFilter2);
        if (null != elements && elements.size() > 0) {
            for (int i = 0; i < elements.size(); i++) {
                Elements newElements = elements.get(i).getAllElements();
            }
        }
        return "";
    }
    //endregion

    //region read page http client --- mode 3
    private static String ReadPageHttpClient(String strUrl) {
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(strUrl);
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 10000);
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        try {
            getMethod.addRequestHeader("Content-Type", "text/html; charset=UTF-8");
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                return "";
            }
            byte[] responseBody = getMethod.getResponseBody();
            String content = new String(responseBody, "UTF-8");
            return content;
        } catch (IOException e) {
            log.error("error information: ", e);
        }
        return "";
    }
    //endregion

    //region main
    public static void main(String[] args) {
        String url = "http://www.baidu.com";

        //mode: 1
        String result = ReadPageUrl(url);
        String imgSrc = RegexString(result, "src=\'(.+?)\'");

        //mode: 2
        Document document = ReadPageJsoup(url);
        if (null != document) {
            String strFilter1 = "div[class=s_form_wrapper]";
            String strFilter2 = "div";
            String result2 = FilterDocument(document, strFilter1, strFilter2);
        }

        //mode: 3
        String result3 = ReadPageHttpClient(url);
    }
    //endregion
}
