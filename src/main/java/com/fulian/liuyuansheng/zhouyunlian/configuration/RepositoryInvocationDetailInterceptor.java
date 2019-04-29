package com.fulian.liuyuansheng.zhouyunlian.configuration;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * RepositoryInvocationDetailIntercepter
 *
 * @author liuqiang
 * @date 2019/4/28
 */
@Aspect
@Slf4j
@Configuration
public class RepositoryInvocationDetailInterceptor {

//
    @Around("execution(* com.fulian.liuyuansheng.zhouyunlian.service..*.*(..))")
    public Object   logInterceptor(JoinPoint joinPoint)throws Throwable {
        MethodInvocationProceedingJoinPoint invocation =   (MethodInvocationProceedingJoinPoint)joinPoint;
        long startMs = System.currentTimeMillis();
        Object  o = invocation.proceed();
        long endMs = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder(invocation.getSignature().toString());
        stringBuilder.append(" execute time ");
        stringBuilder.append(" (");
        stringBuilder.append(endMs - startMs);
        stringBuilder.append(" )");
        stringBuilder.append(" ms ");
        log.info(stringBuilder.toString());
        return o;
    }

    @Bean
    public CustomizableTraceInterceptor customizableTraceInterceptor () {
        CustomizableTraceInterceptor cti = new CustomizableTraceInterceptor();
        cti.setEnterMessage("Entering " + CustomizableTraceInterceptor.PLACEHOLDER_TARGET_CLASS_SHORT_NAME +".$[methodName]($[arguments])");
        cti.setExitMessage("Exiting " + CustomizableTraceInterceptor.PLACEHOLDER_TARGET_CLASS_SHORT_NAME + ".$[methodName]($[arguments]) " +
                        "execute time : $[invocationTime] ms");
        return cti;
    }
    @Bean
    public Advisor jpaRepositoryAdvisor( CustomizableTraceInterceptor customizableTraceInterceptor) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.fulian.liuyuansheng.zhouyunlian.service..*.*(..))");
        return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor);
    }
}
