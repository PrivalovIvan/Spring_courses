package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext3.xml");
        Cat myCat = context.getBean("catBean", Cat.class);
        myCat.say();

        context.close();
    }

}
