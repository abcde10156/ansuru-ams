package com.ansuru.ams.web.security;


import com.ansuru.ams.common.dto.Response;
import com.ansuru.ams.common.utils.BizException;
import com.ansuru.ams.svr.user.dto.request.RequestSvrUserAdminFind;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrUserAdminFind;
import com.ansuru.ams.svr.user.entity.UserAdmin;
import com.ansuru.ams.svr.user.service.UserAdminService;
import com.ansuru.ams.web.common.BaseController;
import com.ansuru.ams.web.common.ErrorCode;
import com.ansuru.ams.web.security.dto.request.RequestWebLogin;
import com.ansuru.ams.web.security.dto.response.ResponseWebLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class LoginController extends BaseController {

    @Autowired
    UserAdminService userAdminService;

    public void setUserAdminService(UserAdminService userAdminService) {
        this.userAdminService = userAdminService;
    }

    @RequestMapping("login")
    @ResponseBody
    public Response login(@Valid @RequestBody RequestWebLogin loginRequest, BindingResult result) {

        RequestSvrUserAdminFind request = new RequestSvrUserAdminFind();
        request.setLoginName(loginRequest.getUsername());
//        ResponseSvrUserAdminFind userAdmin = userAdminService.findByUserName(request);
//        if(userAdmin.getUserAdmin()==null){
//            return new Response(-1,"user does not exists");
//        }
        ResponseWebLogin response = new ResponseWebLogin();
//        response.setUser(userAdmin.getUserAdmin());
        if (loginRequest.getUsername().equals("admin")) {
            return fail(10000, "eeeoruser");
        }
        return success(response);
    }

    @RequestMapping("login1")
    @ResponseBody
    public Object login1(@Valid @RequestBody RequestWebLogin loginRequest, BindingResult result) {
        System.out.println("result = " + result);
        if (result.hasErrors()) {
            System.out.println("loginRequest = " + loginRequest);
        }
        RequestSvrUserAdminFind request = new RequestSvrUserAdminFind();
        request.setLoginName(loginRequest.getUsername());
//        ResponseSvrUserAdminFind userAdmin = userAdminService.findByUserName(request);
//        if(userAdmin.getUserAdmin()==null){
//            return new Response(-1,"user does not exists");
//        }
        ResponseWebLogin response = new ResponseWebLogin();
//        response.setUser(userAdmin.getUserAdmin());

        return new Object();
    }
}
