package com.ansuru.ams.web.common;

import com.ansuru.ams.common.dto.Response;
import com.ansuru.ams.common.utils.BizException;

public class BaseController {
    public Response success(Object result) {
        return Response.makeResponse(result);
    }

    public Response fail(int code, String msg) {
        throw new BizException(code, msg);
    }
}
