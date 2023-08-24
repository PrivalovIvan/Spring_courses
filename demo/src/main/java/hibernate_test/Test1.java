package hibernate_test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hibernate_test.entity.Employee;

public class Test1 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Employee emp2 = context.getBean("employee", Employee.class);
        emp2.setName("Aleksandr");
        emp2.setSurName("Popov");
        emp2.setDepartment("IT");
        emp2.setSalary(1100);
        // Employee emp = new Employee("Veronika", "Potapova", "HR", 750);
        // addEmployeeInDB(emp);
        // addEmployeeInDB(emp2);
        // getEmployeeFromDBById(2);
        // showAllEmployees();
        // showAllEmployeesByNameIvan();
        updateSalaryEmployeeInDB(1);
        context.close();
    }

    public static SessionFactory sFactory() {
        return new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

    }

    public static void addEmployeeInDB(Employee emp) {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(emp);
        session.getTransaction().commit();
        sFactory().close();
        getEmployeeFromDBById(emp.getId());
    }

    public static Employee getEmployeeFromDBById(int id) {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        System.out.println(employee);
        return employee;
    }

    public static void showAllEmployees() {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        List<Employee> emps = session.createQuery("from Employee").getResultList();
        for (Employee e : emps) {
            System.out.println(e);
        }
        session.getTransaction().commit();

    }

    public static void showAllEmployeesByNameIvan() {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        List<Employee> emps = session.createQuery("from Employee where name ='Ivan'").getResultList();
        for (Employee e : emps) {
            System.out.println(e);
        }
        session.getTransaction().commit();

    }

    public static void updateSalaryEmployeeInDB(int id) {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        // Employee emp = session.get(Employee.class, id);
        // emp.setSalary(1300);

        session.createQuery(" update Employee set salary = 1000 where department ='IT'").executeUpdate();
        session.getTransaction().commit();

    }

}
