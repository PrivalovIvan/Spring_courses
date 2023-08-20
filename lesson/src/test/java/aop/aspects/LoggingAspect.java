package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(public void getBook())")
    public void beforeGetBookAdvace() {
        System.out.println("beforeGetBookAdvace: попытка получить книгу.");
    }

}
