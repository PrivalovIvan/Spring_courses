package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("catBean") // Если не прописывать id, то по умолчанию id будет равен названию класса с
                      // маленькой буквы. Если в начале класса 2+ заглавных буквы, тогда id будет
                      // равен такому же названию класса без изменений.
@Scope("prototype")
public class Cat implements Pet {
    Cat() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Meow");
    }

    @PostConstruct
    public void init() {
        System.out.println("Class CAT: method init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class CAT: method destroy");
    }

}
