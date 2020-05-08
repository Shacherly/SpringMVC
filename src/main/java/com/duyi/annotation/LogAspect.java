package com.duyi.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.duyi.annotation.Log)")
    public void logPointCut() {}

    @Around("logPointCut()")
    public Object log(ProceedingJoinPoint point) throws Throwable {

        Signature signature = point.getSignature();
        System.out.println("around");
        Object proceed = point.proceed();
        return proceed;
    }

    @Before("logPointCut()")
    public void before(JoinPoint point) {
        System.out.println("before");

        String declaringTypeName = point.getSignature().getDeclaringTypeName();
        String name = point.getSignature().getName();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        System.out.println("请求来源：" + request.getRemoteAddr());
        System.out.println("请求URL：" + request.getRequestURL());
        System.out.println("请求方式：" + request.getMethod());
        System.out.println("请求的类：" + point.getSignature().getDeclaringType());
        System.out.println("请求的service方法：" + point.getSignature());
        System.out.println("请求的service方法：" + point.getSignature().getName());
        System.out.println("请求参数：" + point.getArgs());
        System.out.println(point.getKind());
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
