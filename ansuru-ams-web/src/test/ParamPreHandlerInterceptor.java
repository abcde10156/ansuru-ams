package com.ansuru.ams.web.security.interceptors;

import com.ansuru.ams.common.dto.Request;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

@Aspect
//@Component
public class ParamPreHandlerInterceptor implements MethodInterceptor {

    public ParamPreHandlerInterceptor() {
        System.out.println("123456 = " + true);
    }

//    @Pointcut("(execution(* (com.ansuru..*Controller).*(..)))")
//    private void pointCutMethod() {
//
//    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return invocation.proceed();
    }

//    @Around("pointCutMethod()")
//    public void invoke(ProceedingJoinPoint pjp) throws Throwable {
//        HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        Object[] args = pjp.getArgs();
//        int requestObjectCount = 0;
//        Request request = null;
//        for (Object arg : args) {
//            if (arg instanceof Request) {
//                requestObjectCount++;
//                request = (Request) arg;
//            }
//        }
//        if (requestObjectCount != 1) {
//
//        }
//        String traceno = httpRequest.getHeader("traceno");
//        request.setTraceNo(traceno);
//        pjp.proceed();
//    }
}
