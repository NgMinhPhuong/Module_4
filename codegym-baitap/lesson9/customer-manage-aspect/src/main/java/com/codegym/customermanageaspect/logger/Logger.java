package com.codegym.customermanageaspect.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @AfterThrowing(pointcut = "execution(public * com.codegym.customermanageaspect.service.impl.CustomerService.*(..))", throwing = "e")
    public void logClass(JoinPoint joinPoint, Exception e) {
        System.out.println("ten phuong thuc: " + joinPoint.getSignature().getName());
        System.out.println("[CMS] co loi xay ra: "+ e.getMessage());
    }
}
