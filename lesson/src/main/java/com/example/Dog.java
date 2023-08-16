package com.example;

public class Dog implements Pet {
    Dog() {
        System.out.println("Dog bean is created!");

    }

    @Override
    public void say() {
        System.out.println("Bow-wow");
    }
}
