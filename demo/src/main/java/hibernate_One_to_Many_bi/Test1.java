package hibernate_One_to_Many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_One_to_Many_bi.entity.Department;
import hibernate_One_to_Many_bi.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        remove();
    }

    public static SessionFactory sFactory() {
        return new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class)
                .buildSessionFactory();
    }

    /* Добавляю работников в департамент cascadeType.ALl */
    public static void add() {
        Employee employee = new Employee("Nikolay", "Sidorov", 700);
        Employee employee2 = new Employee("Ivan", "Privalov", 500);

        Department dep = new Department("IT", 300, 1000);

        Session session = sFactory().getCurrentSession();
        session.beginTransaction();

        dep.addEmployeeToDepartment(employee);
        dep.addEmployeeToDepartment(employee2);

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

    /*
     * Удаление cascade = { CascadeType.DETACH, CascadeType.MERGE,
     * CascadeType.PERSIST, CascadeType.REFRESH }
     */
    public static void remove() {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();

        session.remove(session.get(Employee.class, 1));

        session.getTransaction().commit();
        sFactory().close();
    }

}
