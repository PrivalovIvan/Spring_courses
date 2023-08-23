package aop.aspects;

import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import aop.Student;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println(
                "beforeGetStudentsLoggingAdvice: логируем получение списка студентов перед методом getStudents.");
    }

    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterGetStudentsLoggingAdvice(List<Student> students) {
        Student firstStudent = students.get(0);
        firstStudent.setNameSurname("Mr." + firstStudent.getNameSurname());
        firstStudent.setAvgGrade(7.2);
        System.out.println(
                "afterGetStudentsLoggingAdvice: логируем получение списка студентов после работы метода getStudents.");
    }
}
