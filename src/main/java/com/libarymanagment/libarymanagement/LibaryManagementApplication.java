package com.libarymanagment.libarymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class LibaryManagementApplication {

    public static void main(String[] args) {
//        SpringApplication.run(LibaryManagementApplication.class, args);

        A a = new A();
        B b = new B();

        a.getEngine();
        b.getEngine();


        A obj = new B();
        obj.getEngine();

    }

}
