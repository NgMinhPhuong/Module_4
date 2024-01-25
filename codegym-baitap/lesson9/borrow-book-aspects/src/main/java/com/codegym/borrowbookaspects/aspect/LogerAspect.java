package com.codegym.borrowbookaspects.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Aspect
@Component
public class LogerAspect {
    @AfterReturning(pointcut = "execution(public * com.codegym.borrowbookaspects.controller.BorrowBookController.*(..))")
    public void log(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        if(name.equals("borrow")){
            System.out.println(LocalDateTime.now() + " muon sach co code la " + (String) args[0]);
        }
        if(name.equals("back")){
            System.out.println(LocalDateTime.now() + " tra sach code la " + (String) args[0]);
        }
    }

}
