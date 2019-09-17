package com.ansuru.ams.http;


import com.ansuru.ams.client.HttpClientUtils;

import java.util.HashMap;
import java.util.Map;

public class TestHttpLogin {
    public static void test1() {
        Map<String,String> param = new HashMap<>();
        param.put("username","admin1");
        param.put("password","password");
        String s = HttpClientUtils.postJson("http://localhost:7000/login"
                , param, System.currentTimeMillis()+""
                , 60000, 60000);
        System.out.println("s = " + s);
    }

    public static void test2() {
        Map<String,String> param = new HashMap<>();
        param.put("username","admin");
        param.put("password","password");
        String s = HttpClientUtils.postForm("http://localhost:7000/login", param,  10000, 10000);
        System.out.println("s = " + s);
    }

    public static void main(String[] args) {
        test1();
    }
}
