package com.wqh.student.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求的AOP处理类
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义切点
     */
    @Pointcut("execution(public * com.wqh.student.controller.*.*(..))")
    public void log(){

    }
    @Before("log()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes  =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //获取URL
        logger.info("url={}",request.getRequestURI());
        //获取请求方式
        logger.info("method={}",request.getMethod());
        //获取ip
        logger.info("ip={}",request.getRemoteAddr());
        //获取请求方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //获取参数
        logger.info("args={}",joinPoint.getArgs());

//        logger.info("前置通知");
    }

    @After("log()")
    public void after(){
        logger.info("后置通知");
    }

    /**
     * 获取方法的返回值
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterRrturn(Object object){
//        logger.info("return={}",object.toString());
    }
}
