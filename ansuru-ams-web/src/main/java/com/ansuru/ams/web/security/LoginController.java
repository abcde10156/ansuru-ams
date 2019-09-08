package com.ansuru.ams.web.security;

import com.ansuru.ams.svr.user.dto.request.RequestSvrUserGet;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrUserGet;
import com.ansuru.ams.web.security.dto.LoginRequest;
import com.ansuru.ams.web.security.dto.LoginResponse;
import com.ansuru.ams.svr.user.entity.EntityUser;
import com.ansuru.ams.svr.user.service.UserService;
import com.ansuru.ams.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public LoginResponse login(LoginRequest loginRequest) {
        RequestSvrUserGet requestSvrUserGet = new RequestSvrUserGet();
        requestSvrUserGet.setId(1L);
        ResponseSvrUserGet user = userService.findById(requestSvrUserGet);
        LoginResponse response = new LoginResponse();
        response.setStatus(0);
        return response;
    }
}
