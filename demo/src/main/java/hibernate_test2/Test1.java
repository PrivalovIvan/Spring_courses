package hibernate_test2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate_test2.entity.Employee;
import hibernate_test2.entity.Detail;

public class Test1 {
    public static void main(String[] args) {

        Employee emp = new Employee("Veronika", "Potapova", "HR", 750);

        Detail detail = new Detail("Ekaterinburg", "7123456789", "mail@mail.com");
        emp.setEmpDetail(detail);
        addEmployeeInDB(emp);
        // addEmployeeInDB(emp);
        // addEmployeeInDB(emp2);
        // getEmployeeFromDBById(2);
        // showAllEmployees();
        // showAllEmployeesByNameIvan();
        // updateSalaryEmployeeInDB(1);
        removeObjectInDB(4);
    }

    public static SessionFactory sFactory() {
        return new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class)
                .buildSessionFactory();

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
        sFactory().close();

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
        sFactory().close();

    }

    public static void showAllEmployeesByNameIvan() {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        List<Employee> emps = session.createQuery("from Employee where name ='Ivan'").getResultList();
        for (Employee e : emps) {
            System.out.println(e);
        }
        session.getTransaction().commit();
        sFactory().close();

    }

    public static void updateSalaryEmployeeInDB(int id) {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        // Employee emp = session.get(Employee.class, id);
        // emp.setSalary(1300);

        session.createQuery(" update Employee set salary = 1000 where department ='IT'").executeUpdate();
        session.getTransaction().commit();
        sFactory().close();

    }

    public static void removeObjectInDB(int id) {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();
        // Employee emp = session.get(Employee.class, id);
        // session.remove(emp);

        session.createQuery("delete from Employee where salary = 1000").executeUpdate();
        session.getTransaction().commit();
        sFactory().close();

    }

}
