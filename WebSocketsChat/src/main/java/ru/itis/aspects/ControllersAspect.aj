package ru.itis.aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllersAspect {

    @Around("execution(* ru.itis.controllers.FilesController.handleFileUpload(..))")
    public void beforeSampleCreation(ProceedingJoinPoint joinPoint) {
        System.out.println(joinPoint);
    }
}
