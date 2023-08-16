package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        // Pet pet = new Dog();
        // Person p = new Person(pet);
        // p.callYourPet();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        // Pet dog = context.getBean("myDog", Pet.class);
        Person p = context.getBean("myPerson", Person.class);
        p.callYourPet();
        context.close();
    }
}
