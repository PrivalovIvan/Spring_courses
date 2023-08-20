package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext3.xml");
        Dog dog = context.getBean("dogBean", Dog.class);
        Dog dog2 = context.getBean("dogBean", Dog.class);

        // System.out.println("Переменные ссылаются на один объект? " + (dog == dog2));

        Cat cat = context.getBean("catBean", Cat.class);
        Cat cat2 = context.getBean("catBean", Cat.class);

        // System.out.println("Переменные ссылаются на один объект? " + (cat == cat2));

        context.close();
    }
}
