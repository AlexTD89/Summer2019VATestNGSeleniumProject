package com.cybertek.tests.Day14_Framework_Design_properties_driver_class_test_base_class;

public class Singleton {
    //Singleton class will have private constructor
    //other class can not be able to create an object of this class, idea is: if you need one I'll create on for you

    private Singleton(){

    }

    static String str;

    public static String getInstance(){
        // if str has no value, initialize it and return
        if(str == null){
            System.out.println("str is null. assign value");
            str = "ice cream was good";
        }
        // else just return
        else {
            System.out.println("it already has a value");
        }
        return str;
    }
}
