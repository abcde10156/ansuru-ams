package com.ansuru.ams.web.security;

import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter implements Filter {

    private final int time = 20 * 24 * 60 * 60;

    /**
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */

    @Override

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    /**
     * 28
     *
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     * 29
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String traceno = req.getHeader("traceno");
        MDC.put("id",traceno);
        // 添加参数，允许任意domain访问
        resp.setHeader("Access-Control-Allow-Origin", "*");
        // 这个allow-headers要配为*，这样才能允许所有的请求头 --- update by zxy  in 2018-10-19
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        resp.setHeader("Access-Control-Max-Age", time + "");
        chain.doFilter(request, resp);
    }


    @Override

    public void destroy() {

    }
}
