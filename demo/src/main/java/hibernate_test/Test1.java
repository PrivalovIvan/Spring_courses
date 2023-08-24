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
        emp2.setName("Marina");
        emp2.setSurName("Smirnova");
        emp2.setDepartment("Finance");
        emp2.setSalary(1000);
        // Employee emp = new Employee("Veronika", "Potapova", "HR", 750);
        // addEmployeeInDB(emp);
        // addEmployeeInDB(emp2);
        // getEmployeeFromDBById(2);
        // getAllEmployees();
        getAllEmployeesByNameIvan();
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

    public static void getEmployeeFromDBById(int id) {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        System.out.println(employee);
    }

    public static void getAllEmployees() {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        List<Employee> emps = session.createQuery("from Employee").getResultList();
        for (Employee e : emps) {
            System.out.println(e);
        }
        session.getTransaction().commit();

    }

    public static void getAllEmployeesByNameIvan() {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        List<Employee> emps = session.createQuery("from Employee where name ='Ivan'").getResultList();
        for (Employee e : emps) {
            System.out.println(e);
        }
        session.getTransaction().commit();

    }

}
