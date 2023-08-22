package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

    // @Pointcut("execution(* aop.UniLibrary.*(..))")
    // private void allMethodsFromUniLibrary() {
    // }

    // @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
    // private void returnMagazineFromUnilibrary() {
    // }

    // @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUnilibrary()")
    // private void allMethodsExceptReturnMagazineFromUnilibrary() {
    // }

    // @Before("allMethodsExceptReturnMagazineFromUnilibrary()")
    // public void beforeAllMethodsExceptReturnMagazineAdvice() {
    // System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing Log
    // #10");
    // }
    // -------------------------------------------------------------------------------------------------------------

    // @Pointcut("execution(* aop.UniLibrary.get*())")
    // private void allGetMethodFromUniLibrary() {
    // }

    // @Pointcut("execution(* aop.UniLibrary.return*())")
    // private void allReturnMethodFromUniLibrary() {
    // }

    // @Pointcut("allGetMethodFromUniLibrary() || allReturnMethodFromUniLibrary()")
    // private void allReturnAndGetMethodFromUniLibrary() {
    // }

    // @Before("allGetMethodFromUniLibrary()")
    // public void beforeGetLoggingAdvace() {
    // System.out.println("allGetMethodFromUniLibrary: writing Log #1");
    // }

    // @Before("allReturnMethodFromUniLibrary()")
    // public void beforeReturnLoggingAdvace() {
    // System.out.println("allReturnMethodFromUniLibrary: writing Log #2");
    // }

    // @Before("allReturnAndGetMethodFromUniLibrary()")
    // public void beforeGetAndReturnLoggingAdvace() {
    // System.out.println("allReturnAndGetMethodFromUniLibrary: writing Log #3");

    // }
    // -------------------------------------------------------------------------------------------------------------

    @Before("aop.aspects.MyPointcuts.allGetMethod()")
    public void beforeGetLoggingAdvace() {
        System.out.println("beforeGetBookAdvace: логирование попытки получить книгу/журнал.");
    }

    // // @Before("execution(public void return*())")
    // public void beforeReturnBookAdvace() {
    // System.out.println("beforeReturnBookAdvace: попытка вернуть книгу.");
    // }

    // // @Before("execution(* *())")
    // public void beforeForever() {
    // System.out.println("Я тут\n");
    // }

}
