package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    // @Before("execution(public void get*())")
    public void beforeGetBookAdvace() {
        System.out.println("beforeGetBookAdvace: попытка получить книгу.\n");
    }

    // @Before("execution(public void return*())")
    public void beforeReturnBookAdvace() {
        System.out.println("beforeReturnBookAdvace: попытка вернуть книгу.\n");
    }

    @Before("execution(* *())")
    public void beforeForever() {
        System.out.println("Я тут\n");
    }

}
