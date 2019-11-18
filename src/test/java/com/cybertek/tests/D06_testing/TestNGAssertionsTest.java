package com.cybertek.tests.D06_testing;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

/*

    Assert -->> this is a class in TestNG, it has methods used to do assertions like when we compare values (if else)

    assertEquals()  ->> takes 2 parameters, it will verify if they are equal.
        > When assertion fails we get AssertionError

     In testing if any assertion fails, rest of the methods will not execute, it will be ignored/ skip

     If we still want to rnu the of the code even if assertion fail, we will use soft assertions. When soft assertion fails, code keeps running.
     If any assertion fails it will not affect other methods

     assertNotEquals()  -->> takes 2 parameters, it will verify if they are not equal
     assertTrue()   -->> takes one argument , and returns a boolean if it's true

     if the test fails, the AfterMethod will still run, so it will close the browser no matter what is the result of the test or assertion

     In assertion we can provide messages in case something fails. These messages are used to provide more context, information about that specific assertion
        Ex: assertEquals(1,23, "The given numbers are not equal")   -->> the text from double quotes will be displayed in case if the result is false

 */
public class TestNGAssertionsTest {

    @Test
    public void test1(){
        System.out.println("first assertion");
        Assert.assertEquals("one","one");   // pass

        System.out.println("second assertion");
//        Assert.assertEquals("one","ONE");   //fail

        System.out.println("third assertion");
        Assert.assertEquals(1,23, "The given numbers are not equal");  // fail
        // the third one will not run, second test fails, program stops their

    }

    @Test
    public void test2(){
        Assert.assertNotEquals("one","two");
    }

    @Test
    public void test3(){

//        Assert.assertTrue(1==1);
//        Assert.assertTrue(1==2);        // will throw error

        String expectedTitle = "Cbt";
        String actualTitle = "Cbt";
        Assert.assertTrue(expectedTitle.equals(actualTitle));   // true

        String expectedTitle1 = "Cbt";
        String actualTitle1 = "NMG";
//        Assert.assertTrue(expectedTitle1.equals(actualTitle1));   // fail

        Assert.assertTrue("hello".contains("h"));   // true
    }

    @Test
    public void test5(){
        Assert.assertEquals("Cbt", "CCbt","Title did not match");
    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("close browser");
    }

}
