package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    @Autowired
    private Pet pet;
    private String name;
    private int age;

    // @Autowired
    // Person(Pet pet) {
    // System.out.println("Person bean is created!");
    // this.pet = pet;
    // }
    Person() {
        System.out.println("Person bean is created!");

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void callYourPet() {
        System.out.println("Hello,my lovely Pet");
        pet.say();
    }

    // @Autowired
    // Di c помощью Сеттера.
    public void setPet(Pet pet) {
        System.out.println("Class Person: set Pet");
        this.pet = pet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
