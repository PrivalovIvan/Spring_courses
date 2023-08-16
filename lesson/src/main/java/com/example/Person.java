package com.example;

public class Person {
    private Pet pet;

    Person(Pet pet) {
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Hello,my lovely Pet");
        pet.say();
    }
}
