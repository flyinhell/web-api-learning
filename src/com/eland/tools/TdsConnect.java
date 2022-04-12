package com.eland.tools;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


public class TdsConnect {
    /**
     * 向指定 URL發送POST
     *
     * @param url    URL
     * @param params name1=value1&name2=value2
     * @return 網頁回應
     */
    public String sendPost(String url, String params) {
        Logger logger = Log4j.getInstance().loggerWeb();
        PrintWriter out = null;
        BufferedReader br = null;
        String result = "";
        String line;
        try {
            URL realURL = new URL(url);
            URLConnection conn = realURL.openConnection();

            //設定向TDS輸出，默認為false，改成true，表示以POST的方式
            conn.setDoOutput(true);
            conn.setDoInput(true);

            out = new PrintWriter(conn.getOutputStream());

            out.print(params);
            out.flush();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            while ((line = br.readLine()) != null) {
                result += line;
            }


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return result;
    }


    public String urlEncode(String source, String encode) {
        Logger logger = Log4j.getInstance().loggerWeb();
        String result;
        logger.info("urlEncode");
        try {
            result = java.net.URLEncoder.encode(source, encode);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
            return "0";
        }
        return result;
    }

    public String urlEncodeGBK(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "0";
        }
        return result;
    }


    public String httpRequest(String req_url) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(req_url);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();


            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();

            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * 取得返回的值
     *
     * @param requestUrl
     * @return InputStream
     */
    public InputStream httpRequestIO(String requestUrl) {
        InputStream inputStream = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            inputStream = httpUrlConn.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }


    /**
     * URL GET
     *
     * @param url   URL
     * @param param name1=value1&name2=value2
     * @return URL 網頁回應
     */
    public String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);

            URLConnection connection = realUrl.openConnection();



            connection.connect();

            Map<String, List<String>> map = connection.getHeaderFields();

            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }

            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
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
}
