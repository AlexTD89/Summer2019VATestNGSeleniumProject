package com.cybertek.tests.Day14_Framework_Design_properties_driver_class_test_base_class;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1(){
//        Singleton s = new Singleton();    // compile error, can create an object of the Singleton class (the constructor is private)

        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        /*
                    str is null. assign value
                    it already has a value
                    s1 = ice cream was good
                    s2 = ice cream was good
         */

    }

    @Test
    public void test2(){
        //this is how we create webdriver object from now on
        // the type of the driver will come from the properties file
        WebDriver driver = Driver.get();
        String url = ConfigurationReader.get("url");
        driver.get(url);
        // this is the logic now we will use to get the getTitle or other functions
        System.out.println(Driver.get().getTitle());    //Login

        //we use this method to close the driver
        Driver.closeDriver();

    }
}
