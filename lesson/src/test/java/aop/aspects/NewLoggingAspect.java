package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    private Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint point) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу.");
        Object targetMethodResult = null;
        try {
            targetMethodResult = point.proceed();

        } catch (Exception e) {
            System.out.println("Исключение " + e + " было залогировано.");
            throw e;
        }
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку вернули книгу.");
        return targetMethodResult;
    }
}
