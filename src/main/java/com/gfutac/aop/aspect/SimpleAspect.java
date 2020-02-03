package com.gfutac.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {
    private static final Logger log = LoggerFactory.getLogger(SimpleAspect.class);

    // methods of MyService annotated with @PerformanceLog
    @Pointcut("execution(@com.gfutac.aop.aspect.PerformanceLog * com.gfutac.aop.logic.MyService.*(..))")
    public void myPointcut() {}

    @Around("myPointcut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        log.info("Before method call {}", jp.getSignature().getName());
        Object result = jp.proceed();
        log.info("After method {}", jp.getSignature().getName());

        return result;
    }
}
