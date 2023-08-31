package hibernate_Many_to_Many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_Many_to_Many.entity.Child;
import hibernate_Many_to_Many.entity.Section;

public class Test {
    public static void main(String[] args) {
        task5();
    }

    public static void task1() {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class).buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Section section1 = new Section("Football");

            Child child1 = new Child("Petr", 13);
            Child child2 = new Child("Ivan", 12);
            Child child3 = new Child("Maxim", 7);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.persist(section1);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public static void task2() {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class).buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Section section1 = new Section("Basketball");
            Section section2 = new Section("Volleyball");
            Section section3 = new Section("Math");

            Child child1 = new Child("Masha", 8);

            child1.addSectionToChild(section1);
            child1.addSectionToChild(section2);
            child1.addSectionToChild(section3);

            session.beginTransaction();

            session.persist(child1);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public static void task3() {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class).buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Child child = session.get(Child.class, 4);
            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public static void task4() {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class).buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Section section = session.get(Section.class, 1);

            System.out.println(section);
            System.out.println(section.getChildren());

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public static void task5() {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class).buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Section section = session.get(Section.class, 1);

            session.remove(section);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
