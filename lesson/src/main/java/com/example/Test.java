package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("personBean", Person.class);
        // person.callYourPet();
        System.out.println(person.getName() + "\n" + person.getAge());

        // Pet cat = context.getBean("catBean", Pet.class);
        // cat.say();
        context.close();
    }
}
