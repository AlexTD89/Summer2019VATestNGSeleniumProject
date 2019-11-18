package com.cybertek.tests.D06_testing;


/*


@BeforeMethod   -->> it doesn't have a run button, but it will run every time after each method (but it's written once)

@AfterMethod    -->> it's a method that will run   automatically after each method(test)
@BeforeClass   -->> it will run only one time before everything in this class , before all other methods
@AfterClass     -->>    it will run one time after everything in this class, after all other methods

@Ignore     -->> doesn't run a specific method. doesn't work with the class



 */

import org.testng.annotations.*;

public class BeforeAfterTests {


    @Test
    public void test1(){
        System.out.println("this is test one");
    }

    @Test
    public void test2(){
        System.out.println("this is second test");
    }


    @BeforeMethod
    public void setupMethod(){
        System.out.println("BEFORE METHOD");
        System.out.println("Opening Chrome");
    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("After METHOD");
        System.out.println("Closing Chrome");
    }

    @BeforeClass
    public void setupClass(){
        System.out.println("Before class: running only one time");
    }

    @AfterClass
    public void teardownClass(){
        System.out.println("AFTER CLASS: RUNNING ONLY ONE TIME");
    }

    /*
                        Before class: running only one time


                        BEFORE METHOD
                        Opening Chrome


                        this is test one


                        After METHOD
                        Closing Chrome


                        BEFORE METHOD
                        Opening Chrome


                        this is second test


                        After METHOD
                        Closing Chrome


                        AFTER CLASS: RUNNING ONLY ONE TIME

     */





}
