package com.haiming.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
                " || within(@org.springframework.stereotype.Service * ) " +
                " || within(@org.springframework.web.bind.annotation.RestController *) ")
    public void springBeanPointCut(){

    }

    @Pointcut("execution(* CreateCourse(..))")
    public void onlyControllerCreate(){

    }

    @Around(value = "springBeanPointCut() && applicationPackagePointcut()")
    public Object logBeforeRequest(ProceedingJoinPoint joinPoint) throws Throwable{
        log.debug("Enter: {}.{}() with arguments[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), result);
        return result;
    }

    @Around("onlyControllerCreate()")
    public Object logOnlyCreateModel(ProceedingJoinPoint joinPoint) throws Throwable{
        log.debug("logOnlyCreateModel");
        return this.logBeforeRequest(joinPoint);
    }

    @Pointcut("within(com.haiming.controller..*)")
    public void applicationPackagePointcut(){

    }

    public String toString(){
        return "foobar";
    }
}
