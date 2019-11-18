package com.cybertek.tests.D0_FirstClass;

import com.github.javafaker.Faker;

public class FirstClass {
    public static void main(String[] args) {
        System.out.println("helloo");

        Faker faker = new Faker();

        System.out.println(faker.name().fullName());
        System.out.println(faker.chuckNorris().fact());
    }
}
