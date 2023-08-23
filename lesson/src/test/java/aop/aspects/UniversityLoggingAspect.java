package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UniversityLoggingAspect {

    // @Before("execution(* getStudents())")
    // public void beforeGetStudentsLoggingAdvice() {
    // System.out.println(
    // "beforeGetStudentsLoggingAdvice: логируем получение списка студентов перед
    // методом getStudents.");
    // }

    // @AfterReturning(pointcut = "execution(* getStudents())", returning =
    // "students")
    // public void afterGetStudentsLoggingAdvice(List<Student> students) {
    // Student firstStudent = students.get(0);
    // firstStudent.setNameSurname("Mr." + firstStudent.getNameSurname());
    // firstStudent.setAvgGrade(7.2);
    // System.out.println(
    // "afterGetStudentsLoggingAdvice: логируем получение списка студентов после
    // работы метода getStudents.");
    // }
    // @AfterThrowing(pointcut = "execution(* getStudents())", throwing =
    // "exception")
    // public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
    // System.out.println(
    // "afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения: " +
    // exception.getMessage());
    // }
    // @After("execution(* getStudents())")
    // public void afterGetStudntsLoggingAdvice() {

    // System.out.println(
    // "afterGetStudntsLoggingAdvice: логируем нормальное окончание работы метода
    // или выброс исключения.");
    // }
}
