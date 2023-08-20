package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dogBean")
@Scope("singleton")
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

    @PostConstruct
    public void init() {
        System.out.println("Class dog: method init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class dog: method destroy");
    }
}
