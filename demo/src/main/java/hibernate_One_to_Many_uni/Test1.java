package hibernate_One_to_Many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_One_to_Many_uni.entity.Department;
import hibernate_One_to_Many_uni.entity.Employee;

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
        Employee employee2 = new Employee("Oleg", "Pupkin", 1000);

        Department dep = new Department("HR", 500, 1500);

        Session session = sFactory().getCurrentSession();

        session.beginTransaction();

        dep.addEmployeeToDepartment(employee);
        dep.addEmployeeToDepartment(employee2);

        session.persist(dep);
        session.getTransaction().commit();
        sFactory().close();
    }

    public static void showEmpAndDep() {
        Session session = sFactory().getCurrentSession();
        session.beginTransaction();

        Department department = session.get(Department.class, 2);
        System.out.println(department.getList());

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

        session.remove(session.get(Department.class, 2));

        session.getTransaction().commit();
        sFactory().close();
    }

}
