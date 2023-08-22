package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(30)
public class ExceptionHandlingAspect {
    @Before("aop.aspects.MyPointcuts.allGetMethod()")
    public void beforeGetExceptionHandlingAdbice() {
        System.out.println(
                "beforeGetExceptionHandlingAdbice: ловим/обрабатываем исключения при попытке получить книгу/журнал.");
    }
}
