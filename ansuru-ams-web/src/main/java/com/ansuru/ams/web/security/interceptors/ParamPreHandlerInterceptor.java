package com.ansuru.ams.web.security.interceptors;

import com.ansuru.ams.common.dto.Request;
import com.ansuru.ams.common.dto.Response;
import com.ansuru.ams.common.utils.*;
import com.ansuru.ams.web.common.ErrorCodeWeb;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class ParamPreHandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ParamPreHandlerInterceptor.class);

    public ParamPreHandlerInterceptor() {
    }

    @Pointcut("(execution(* (com.ansuru..*Controller).*(..)))")
    private void pointCutMethod() {

    }

    @Around("pointCutMethod()")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String traceno = httpRequest.getHeader("traceno");
        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String nn = headerNames.nextElement();
            String value = httpRequest.getHeader(nn);
            logger.debug("header:[{}:{}]", nn, value);
        }


        Object[] args = pjp.getArgs();
        int requestObjectCount = 0;
        Request request = null;
        for (Object arg : args) {
            if (arg instanceof Request) {
                requestObjectCount++;
                request = (Request) arg;
                setTraceNo(traceno, arg);
            }
        }
        if (requestObjectCount != 1) {
            Response response = Response.makeErrorResponse(ErrorCodeWeb.ERROR_INTERNAL.getCode(), ErrorCodeWeb.ERROR_INTERNAL.getErrorMessage());
            response.getMeta().setTraceNo(traceno);
            logger.info("o:{}", JsonUtils.toJson(response));
            return response;
        }
        logger.info("i:" + JsonUtils.toJson(request));

        String validateError = ValidationUtils.validate(request);
        if (StringUtils.hasText(validateError)) {
            Response response = Response.makeErrorResponse(ErrorCodeWeb.ERROR_INPUT.getCode(), validateError);
            response.getMeta().setTraceNo(traceno);
            logger.info("o:{}", JsonUtils.toJson(response));
            return response;
        }

        request.setTraceNo(traceno);
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            ExceptionUtils.printException(throwable);
            if (throwable instanceof BizException) {
                BizException bizException = (BizException) throwable;
                Response response;
                if (bizException.getData() != null) {
                    response = Response.makeErrorResponse(bizException.getCode(), bizException.getMsg(), bizException.getData());
                } else {
                    response = Response.makeErrorResponse(bizException.getCode(), bizException.getMsg());
                }
                response.getMeta().setTraceNo(traceno);
                return response;
            }
            throw throwable;
        }
        setTraceNo(traceno, proceed);
        logger.info("o:{}", JsonUtils.toJson(proceed));
        return proceed;
    }

    public void setTraceNo(String traceNo, Object o) {
        if (o instanceof Request) {
            Request request = (Request) o;
            request.setTraceNo(traceNo);
            return;
        }
        if (o instanceof Response) {
            Response request = (Response) o;
            request.getMeta().setTraceNo(traceNo);
            return;
        }
        throw new RuntimeException("not instance of request or response");
    }
}
