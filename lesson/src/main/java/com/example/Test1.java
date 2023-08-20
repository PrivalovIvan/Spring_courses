package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext3.xml");

        Person person = context.getBean("personBean", Person.class);
        // person.callYourPet();
        // Cat myCat = context.getBean("catBean", Cat.class);
        // myCat.say();
        System.out.println("Name: " + person.getName() + "\nAge: " + person.getAge());
        context.close();
    }

}
