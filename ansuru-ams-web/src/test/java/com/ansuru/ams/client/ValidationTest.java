package com.ansuru.ams.client;

import com.ansuru.ams.common.utils.ValidationUtils;
import com.ansuru.ams.web.security.dto.request.RequestWebLogin;

public class ValidationTest {
    public static void main(String[] args) {
        RequestWebLogin webLogin = new RequestWebLogin();
        webLogin.setUsername("你好你好你你好1好你");
        webLogin.setPassword("123456");
        ValidationUtils.validate(webLogin);
    }
}
