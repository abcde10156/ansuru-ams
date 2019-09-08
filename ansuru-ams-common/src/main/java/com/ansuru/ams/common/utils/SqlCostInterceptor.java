package com.ansuru.ams.common.utils;

import java.lang.invoke.MethodHandles;
import java.util.Properties;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({@org.apache.ibatis.plugin.Signature(type=org.apache.ibatis.executor.Executor.class, method="update", args={MappedStatement.class, Object.class}), @org.apache.ibatis.plugin.Signature(type=org.apache.ibatis.executor.Executor.class, method="query", args={MappedStatement.class, Object.class, org.apache.ibatis.session.RowBounds.class, org.apache.ibatis.session.ResultHandler.class})})
public class SqlCostInterceptor
        implements Interceptor
{
    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private Properties properties;

    public Object intercept(Invocation invocation)
            throws Throwable
    {
        MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
        String sqlId = mappedStatement.getId();

        long start = System.currentTimeMillis();
        Object returnValue = invocation.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
//        if (time > 1L) {
            logger.debug("+++++ SQL Time = " + Double.toString((end - start) / 1000.0D) + "s == " + sqlId);
//        }
        return returnValue;
    }

    public Object plugin(Object target)
    {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties0) {
        this.properties = properties0;
    }
}
