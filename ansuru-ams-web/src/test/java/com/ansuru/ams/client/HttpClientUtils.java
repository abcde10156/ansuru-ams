package com.ansuru.ams.client;

import com.ansuru.ams.common.utils.ExceptionUtils;
import com.ansuru.ams.common.utils.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * author : luotao-work
 * time   : 2016/12/23 16:29
 */
public class HttpClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    public static String doGet(String request_url, Map<String, String> params) throws RuntimeException {
        return doGet(request_url, params, "UTF-8", 5000, 5000);
    }

    public static String doGet(String request_url, Map<String, String> params, String charset) throws RuntimeException {
        return doGet(request_url, params, charset, 5000, 5000);
    }


    public static String doGet(String request_url, Map<String, String> params, String charset, int timeout_conn, int timeout_read) throws RuntimeException {
        if (StringUtils.isEmpty(request_url)) {
            return null;
        }
        String result;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<>(params.size());
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value));
                    }
                }
                request_url += (request_url.contains("?") ? "&" : "?") + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
            }

            logger.info("get url : " + request_url);
            httpClient = HttpClientBuilder.create().build();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout_read).setConnectTimeout(timeout_conn).build();//设置请求和传输超时时间
            HttpGet httpGet = new HttpGet(request_url);
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                logger.error("HttpClient,error status code :" + statusCode);
                throw new RuntimeException(statusCode+"");
            }
            HttpEntity entity = response.getEntity();
            result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
        } catch (IOException e) {
            ExceptionUtils.printException(e);
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    ExceptionUtils.printException(e);
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    ExceptionUtils.printException(e);
                }
            }

        }
        logger.info("result : " + result);
        return result;

    }

    public static String doGet(String request_url, String request_id, Map<String, String> params,
                               int timeout_conn, int timeout_read) throws RuntimeException {
        if (StringUtils.isEmpty(request_url)) {
            return null;
        }
        String result;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<>(params.size());
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value));
                    }
                }
//                request_url += (request_url.contains("?") ? "&" : "?") + Joiner.on("&").withKeyValueSeparator("=").join(params);
            }

            logger.info("get url : " + request_url);
            httpClient = HttpClientBuilder.create().build();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(timeout_read)
                    .setConnectTimeout(timeout_conn).build();
            HttpGet httpGet = new HttpGet(request_url);
            httpGet.setConfig(requestConfig);
            httpGet.addHeader("requestid", request_id);
            response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                logger.error("HttpClient,error status code :" + statusCode);
                throw new RuntimeException(statusCode+"");
            }
            HttpEntity entity = response.getEntity();
            result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
        } catch (IOException e) {
            ExceptionUtils.printException(e);
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    ExceptionUtils.printException(e);
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    ExceptionUtils.printException(e);
                }
            }

        }
        logger.info("result : " + result);
        return result;

    }

    public static byte[] postJSON(String url, String request, Map<String, String> header, int timeout_conn, int timeout_read) {
        logger.info("url :" + url + " , req:" + request);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout_read).setConnectTimeout(timeout_conn).build();//设置请求和传输超时时间
            StringEntity s = new StringEntity(request);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            httppost.addHeader(new BasicHeader("requestid", MDC.get("id")));
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httppost.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            }
            httppost.setEntity(s);
            httppost.setConfig(requestConfig);
            response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            byte[] bytes = EntityUtils.toByteArray(entity);
            logger.info("url :" + url + " , res:" + new String(bytes));
            return bytes;

        } catch (Exception e) {
            ExceptionUtils.printException(e);
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    ExceptionUtils.printException(e);
                }
            }
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    ExceptionUtils.printException(e);
                }
            }
        }
    }

    public static String postJson(String url, Map<String, String> params, String request_id, int timeout_conn, int timeout_read) {
        logger.info("url :" + url + " , req:" + params);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(timeout_read)
                    .setConnectTimeout(timeout_conn)
                    .build();//设置请求和传输超时时间
            StringEntity strEntity = new StringEntity(JsonUtils.toJson(params));
            strEntity.setContentEncoding("UTF-8");
            strEntity.setContentType("application/json");
            httppost.setEntity(strEntity);
            httppost.addHeader(new BasicHeader("traceno", request_id));
            httppost.setConfig(requestConfig);

            response = httpclient.execute(httppost);

            HttpEntity entity = response.getEntity();
            String data = EntityUtils.toString(entity, "UTF-8");
            logger.info("url :" + url + " , res:" + data);
            EntityUtils.consume(entity);
            return data;
        } catch (Exception e) {
            ExceptionUtils.printException(e);
            throw new RuntimeException("");
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    ExceptionUtils.printException(e);
                }
            }
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    ExceptionUtils.printException(e);
                }
            }
        }
    }


    public static byte[] postForm(String url, Map<String, Object> request, boolean is_post) {
        logger.info("url :" + url + " , req:" + request);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpRequestBase httpRequestBase;
        if (!is_post) {
            httpRequestBase = new HttpGet(url);
        } else {
            // 创建httppost
            httpRequestBase = new HttpPost(url);
        }
        CloseableHttpResponse response = null;
        try {
            if (is_post) {
                List<NameValuePair> formparams = new ArrayList<>();
                for (Map.Entry<String, Object> entry : request.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        formparams.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof ArrayList) {
                        List<String> list = (List<String>) value;
                        for (String s : list) {
                            formparams.add(new BasicNameValuePair(entry.getKey(), s));
                        }
                    } else {
                        logger.warn("value is not string,name : " + entry.getKey() + ",value : " + value);
                    }

                }
                logger.info("post param:" + formparams);
                UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
                HttpPost httpPost = (HttpPost) httpRequestBase;
                httpPost.setEntity(uefEntity);
            }
            httpRequestBase.addHeader(new BasicHeader("is_vm_for_pad", "1"));
            httpRequestBase.addHeader(new BasicHeader("requestid", System.currentTimeMillis() + ""));
            response = httpclient.execute(httpRequestBase);
//            System.out.println("response.getStatusLine() = " + response.getStatusLine());

            HttpEntity entity = response.getEntity();

            byte[] bytes = EntityUtils.toByteArray(entity);
            logger.info("result : " + new String(bytes));
            return bytes;

        } catch (Exception e) {
//            e.printStackTrace();
            ExceptionUtils.printException(e);
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception ex) {
                    ExceptionUtils.printException(ex);
                }
            }
        }
    }


    public static String postForm(String url, Map<String, String> params, int connTimeOut, int readTimeOut) {
        logger.info("url :" + url + " ,connTimeOut:" + connTimeOut + ", readTimeOut:" + readTimeOut + " , params:" + params);
        if (params == null) {
            logger.info("params is null");
            return null;
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String body = null;
        try {
            List<NameValuePair> paramLt = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                paramLt.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(connTimeOut)
                    .setSocketTimeout(readTimeOut)
                    .build();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(config);
            httpPost.setEntity(new UrlEncodedFormEntity(paramLt, "UTF-8"));

            response = httpclient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            if (200 == statusLine.getStatusCode()) {
                body = EntityUtils.toString(response.getEntity());
                logger.info("body={}", body);
            } else {
                logger.info("status_code={}", statusLine.getStatusCode());
            }
        } catch (Exception ex) {
            ExceptionUtils.printException(ex);
            throw new RuntimeException(ex);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception ex) {
                    ExceptionUtils.printException(ex);
                }
            }
        }
        return body;
    }

    public static void main(String[] args) {

    }
}
