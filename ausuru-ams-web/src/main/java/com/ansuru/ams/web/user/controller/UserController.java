package com.ansuru.ams.web.user.controller;

import com.ansuru.ams.common.utils.JsonUtils;
import com.ansuru.ams.svr.user.dto.request.RequestSvrUserFind;
import com.ansuru.ams.web.user.dto.RequestWebUserFind;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrUserFind;
import com.ansuru.ams.web.user.dto.ResponseWebUserFind;
import com.ansuru.ams.svr.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("pager")
    @ResponseBody
    public ResponseWebUserFind findByPager(RequestWebUserFind userFindRequest) {
        RequestSvrUserFind requestUserFind = new RequestSvrUserFind();
        requestUserFind.setPageNo(userFindRequest.getPageNo());
        requestUserFind.setPageSize(userFindRequest.getPageSize());
        ResponseSvrUserFind entityUserPageInfo = userService.find(requestUserFind);
        ResponseWebUserFind responseWebUserFind = new ResponseWebUserFind();
        responseWebUserFind.setPageResult(entityUserPageInfo.getPageResult());
        logger.info(JsonUtils.toJson(responseWebUserFind));
        return responseWebUserFind;
    }
}
