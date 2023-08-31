package hibernate_One_to_Many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_One_to_Many_bi.entity.Department;
import hibernate_One_to_Many_bi.entity.Employee;

public class Test1 {
    public static void main(String[] args) {

        Session session = sFactory().getCurrentSession();

        session.beginTransaction();
        System.out.println("Get Department");
        Department department = session.get(Department.class, 3);
        System.out.println("Show Department");
        System.out.println(department);
        System.out.println("Show Employees");
        System.out.println(department.getList());
        session.getTransaction().commit();
    }

    public static SessionFactory sFactory() {
        return new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class)
                .buildSessionFactory();
    }

    public static void add() {
        Employee employee = new Employee("Nikolay", "Sidorov", 800);
        Employee employee2 = new Employee("Ivan", "Privalov", 1500);
        Employee employee3 = new Employee("Oleg", "Sidorov", 1000);

        Department dep = new Department("Sales", 800, 1500);

        Session session = sFactory().getCurrentSession();
        session.beginTransaction();

        dep.addEmployeeToDepartment(employee);
        dep.addEmployeeToDepartment(employee2);
        dep.addEmployeeToDepartment(employee3);

        session.persist(dep);

        session.getTransaction().commit();
        sFactory().close();
    }

    public static void showEmpAndDep() {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();

        Department department = session.get(Department.class, 1);
        System.out.println(department.getList());
        System.out.println("-----------------------------");

        Employee emp = session.get(Employee.class, 1);
        System.out.println(emp);
        System.out.println(emp.getDepartment());

        session.getTransaction().commit();
        sFactory().close();
    }

    public static void remove() {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();

        session.remove(session.get(Employee.class, 1));

        session.getTransaction().commit();
        sFactory().close();
    }

}
