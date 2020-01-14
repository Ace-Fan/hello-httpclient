package com.wufan.hello.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/13 20:25
 */
public class MyTest {
    public static void main(String[] args) {
        get();
    }
    private static void get(){
        //创建httpclient客户端，打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建get请求
        HttpGet httpGet = new HttpGet("http://localhost:8082/user/page?draw=1&start=0&length=10");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Cookie", "JSESSIONID=33BAB1EF56B681F0EF90CD93D0430391");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36");

        //发送请求，回车
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(httpEntity));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void post(){
        //创建httpclient客户端，打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建post请求，输入url
        HttpPost httpPost = new HttpPost("http://localhost:8082/user/page");
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.setHeader("Cookie", "JSESSIONID=38F5C62EB6A34435BE210960670BC6CB");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36");

        //创建请求参数
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("draw", "1"));
        params.add(new BasicNameValuePair("start", "0"));
        params.add(new BasicNameValuePair("length", "10"));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(httpEntity));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
