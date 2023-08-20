package com.example;

import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog implements Pet {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Dog() {
        System.out.println("Dog bean is created!");

    }

    @Override
    public void say() {
        System.out.println("Bow-wow");
    }

    public void init() {
        System.out.println("Class dog: method init");
    }

    public void destroy() {
        System.out.println("Class dog: method destroy");
    }
}
