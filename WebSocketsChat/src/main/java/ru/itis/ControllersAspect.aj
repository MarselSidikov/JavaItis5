package ru.itis;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllersAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllersAspect.class);

    @AfterReturning("execution(* ru.itis.controllers.*.*(..)) && args(token,..)")
    public void beforeSampleCreation(String token) {
        System.out.println(token);
        // LOGGER.info(token);
    }
}
