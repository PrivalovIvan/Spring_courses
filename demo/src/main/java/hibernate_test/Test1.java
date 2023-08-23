package hibernate_test;

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
        Employee emp = new Employee("Ivan", "Privalov", "IT", 500);
        addEmployeeInDB(emp);
        addEmployeeInDB(emp2);
        context.close();
    }

    public static void addEmployeeInDB(Employee emp) {
        SessionFactory sf = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.persist(emp);
        session.getTransaction().commit();
        sf.close();
    }
}
