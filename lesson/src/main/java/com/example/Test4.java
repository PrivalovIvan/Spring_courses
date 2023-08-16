package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext2.xml");
        // Bean scope prototype
        Dog myDog = context.getBean("myDog", Dog.class);
        myDog.setName("Belka");
        Dog yourDog = context.getBean("myDog", Dog.class);
        yourDog.setName("Strelka");
        System.out.println(myDog.getName() + " и " + yourDog.getName());
        System.out.println("Ссылаются ли эти переменные на один и тот же объект: " + (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);

        context.close();
    }
}
