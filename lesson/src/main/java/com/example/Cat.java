package com.example;

import org.springframework.stereotype.Component;

@Component("catBean") // Если не прописывать id, то по умолчанию id будет равен названию класса с
                      // маленькой буквы. Если в начале класса 2+ заглавных буквы, тогда id будет
                      // равен такому же названию класса без изменений.
public class Cat implements Pet {
    Cat() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Meow");
    }

}
