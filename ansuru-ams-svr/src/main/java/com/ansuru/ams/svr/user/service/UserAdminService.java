package com.ansuru.ams.svr.user.service;

import com.ansuru.ams.svr.user.dto.request.RequestSvrUserAdminFind;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrUserAdminFind;

public interface UserAdminService {

    ResponseSvrUserAdminFind findByUserName(RequestSvrUserAdminFind request);
}
