package com.github.bruce_mig.aspect_oriented_programming.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before(
            value = "com.github.bruce_mig.aspect_oriented_programming.aspect.CommonPointCuts.inWebLayer()"
    )
    public void logWebBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Executing controller method: {}, with arguments: {}", methodName, Arrays.toString(args) );
    }

    @AfterReturning(
            pointcut = "com.github.bruce_mig.aspect_oriented_programming.aspect.CommonPointCuts.inWebLayer()",
            returning = "result")
    public void logWebAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Controller method: {} executed successfully. Result: {}", methodName, result);
    }

    @AfterThrowing(
            pointcut = "com.github.bruce_mig.aspect_oriented_programming.aspect.CommonPointCuts.inWebLayer()",
            throwing = "exception")
    public void logWebAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Controller method: " + methodName + " threw exception:" + exception);
    }

    @Before(
            value = "com.github.bruce_mig.aspect_oriented_programming.aspect.CommonPointCuts.serviceLayerExcludingSensitive()"
    )
    public void logServiceBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Executing service method: {}, with arguments: {}", methodName, Arrays.toString(args) );
    }

    @AfterReturning(
            pointcut = "com.github.bruce_mig.aspect_oriented_programming.aspect.CommonPointCuts.serviceLayerExcludingSensitive()",
            returning = "result")
    public void logServiceAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Service method: {} executed successfully. Result: {}", methodName, result);
    }

    @AfterThrowing(
            pointcut = "com.github.bruce_mig.aspect_oriented_programming.aspect.CommonPointCuts.serviceLayerExcludingSensitive()",
            throwing = "exception")
    public void logServiceAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Service method: " + methodName + " threw exception:" + exception);
    }
}
