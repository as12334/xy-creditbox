package so.wwb.creditbox.common.utility.security;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClientTool  extends org.soul.commons.net.http.HttpClientTool {

    private static final Log LOG = LogFactory.getLog(HttpClientTool.class);

    public static String doPut(String url, String params) {
        LOG.info("API请求 -> 请求地址{0}\n参数{1}", url, params);
        HttpClient httpClient = new HttpClient();
        PutMethod put = new PutMethod(url);
        put.setRequestBody(params);
        put.setRequestHeader(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        put.setRequestHeader("Content-Type","application/json");

        try {
            LOG.info("API请求 -> 执行请求");
            httpClient.executeMethod(put);
        } catch (HttpException he) {
            LOG.error(he, "API请求 -> 执行请求HTTP异常：{0}", he.getMessage());
        } catch (IOException ie) {
            LOG.error(ie, "API请求 -> 执行请求IO异常：{0}", ie.getMessage());
        }

        String res = "";
        try {
            LOG.info("API请求 -> 读取请求结果");
            res = put.getResponseBodyAsString();
        } catch (IOException ie) {
            LOG.error(ie,"API请求 -> 读取请求结果异常：{0}", ie.getMessage());
        }
        LOG.info("API请求 -> 得到请求结果：{0}", res);
        return res;
    }

    public static String doLogin(String url, String params, HttpServletRequest request) {
        LOG.info("API请求 -> 请求地址{0}\n参数{1}", url, params);
        HttpClient httpClient = new HttpClient();
        PutMethod put = new PutMethod(url);
        put.setRequestBody(params);
        put.setRequestHeader(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        put.setRequestHeader("Content-Type","application/json");
        put.setRequestHeader("User-Agent", request.getHeader("User-Agent"));

        try {
            LOG.info("API请求 -> 执行请求");
            httpClient.executeMethod(put);
        } catch (HttpException he) {
            LOG.error(he, "API请求 -> 执行请求HTTP异常：{0}", he.getMessage());
        } catch (IOException ie) {
            LOG.error(ie, "API请求 -> 执行请求IO异常：{0}", ie.getMessage());
        }

        String res = "";
        try {
            LOG.info("API请求 -> 读取请求结果");
            res = put.getResponseBodyAsString();
        } catch (IOException ie) {
            LOG.error(ie,"API请求 -> 读取请求结果异常：{0}", ie.getMessage());
        }
        LOG.info("API请求 -> 得到请求结果：{0}", res);
        return res;
    }

    public static String doPut2(String path, String params) {
        LOG.info("API请求 -> 请求地址{0}，参数{1}", path, params);
        try {
            URL url = new URL(path);
            HttpURLConnection conn;
            StringBuffer sb = new StringBuffer();
            //添加 请求内容
            conn = (HttpURLConnection) url.openConnection();
            //设置http连接属性
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("PUT"); // 可以根据需要 提交 GET、POST、DELETE、PUT等http提供的功能

            conn.setRequestProperty("Host", url.getHost());
            conn.setRequestProperty("Content-Type", " application/json");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("X-Auth-Token", "token");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Transfer-Encoding", "chunked");
            conn.setRequestProperty("Content-Length", String.valueOf(params.getBytes().length));

            conn.setReadTimeout(10000);//设置读取超时时间
            conn.setConnectTimeout(10000);//设置连接超时时间
            conn.connect();
            //向对象输出流写出数据，这些数据将存到内存缓冲区中
            OutputStream out = conn.getOutputStream();
            out.write(params.getBytes());
            out.flush();
            out.close();

            //读取响应
            LOG.info("API请求 -> 请求返回状态{0}", conn.getResponseCode());
            if (conn.getResponseCode() == 200) {
                // 从服务器获得一个输入流
                InputStreamReader inputStream = new InputStreamReader(conn.getInputStream());
                //调用HttpURLConnection连接对象的getInputStream()函数, 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
                BufferedReader reader = new BufferedReader(inputStream);

                String lines;
                sb = new StringBuffer();

                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), StandardCharsets.UTF_8);
                    sb.append(lines);
                }
                reader.close();
            } else {
                LOG.error("API请求 -> 请求失败: {0}", conn.getResponseCode());
            }
            //断开连接
            conn.disconnect();

            LOG.info("API请求 -> 请求结果{0}", sb.toString());
            return sb.toString();
        } catch (IOException e) {
            LOG.error(e, "API请求 -> 请求出现IO异常");
        }
        return null;
    }

}