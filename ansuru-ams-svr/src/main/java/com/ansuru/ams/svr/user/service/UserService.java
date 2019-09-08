package com.ansuru.ams.svr.user.service;

import com.ansuru.ams.svr.user.dto.request.RequestSvrUserFind;

import com.ansuru.ams.svr.user.dto.request.RequestSvrUserGet;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrUserFind;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrUserGet;

public interface UserService {
    ResponseSvrUserGet findById(RequestSvrUserGet id);

    ResponseSvrUserFind find(RequestSvrUserFind entityUser);
}
