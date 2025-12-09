package tn.esprit.twin3.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectConfig {

                    //* tn.esprit.twin3.service.*.*(..))")
    @After("execution(* tn.esprit.twin3.controller..*(..))")
    void trace(JoinPoint joinPoint) throws Throwable {
        log.info("la methode consomme dans"+joinPoint.getClass().getPackageName()+"est le nom de la methode est :"+joinPoint.getSignature().getName());
    }
}
