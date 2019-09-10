package com.ansuru.ams.web.security;

import com.ansuru.ams.common.dto.Response;
import com.ansuru.ams.svr.user.dto.request.RequestSvrUserGet;
import com.ansuru.ams.svr.user.dto.request.RequestSvrUserAdminFind;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrUserAdminFind;
import com.ansuru.ams.web.security.dto.request.RequestWebLogin;
import com.ansuru.ams.web.security.dto.response.ResponseWebLogin;
import com.ansuru.ams.svr.user.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    UserAdminService userAdminService;

    @RequestMapping("login")
    @ResponseBody
    public Response login(@RequestBody RequestWebLogin loginRequest) {
        RequestSvrUserAdminFind request = new RequestSvrUserAdminFind();
        request.setLoginName(loginRequest.getUsername());
        ResponseSvrUserAdminFind userAdmin = userAdminService.findByUserName(request);
        if(userAdmin.getUserAdmin()==null){
            return new Response(-1,"user does not exists");
        }
        ResponseWebLogin response = new ResponseWebLogin();
        response.setUser(userAdmin.getUserAdmin());
        return response;
    }
}
