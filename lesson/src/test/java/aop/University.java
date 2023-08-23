package aop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudent() {
        Student st1 = new Student("Privalov ivan", 3, 9);
        Student st2 = new Student("Petrov Oleg", 4, 8.5);
        Student st3 = new Student("Smirnov Igor", 2, 7.5);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents() {
        System.out.println("Information from method getStudents: ");
        System.out.println(students);
        return students;
    }
}
