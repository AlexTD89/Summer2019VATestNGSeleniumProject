package com.cybertek.tests.D06_testing;


/*
    @Test   -->> this is annotation.This means a test method
            -->> allows to run the method without main method

     @Ignore    -->> ignore the following method. don't run the following method, skip it.

 */


import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNGTest {


    @Test
    public void test1(){
        System.out.println("this is the first test");
    }

//    @Ignore
    @Test
    public void test2(){
        System.out.println("this is the 2nd test");
    }

}
