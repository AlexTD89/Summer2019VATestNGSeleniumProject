package com.cybertek.tests.Day14_Framework_Design_properties_driver_class_test_base_class;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){
        //we provide the key (left side to the =) of the property to get the method
        String browser = ConfigurationReader.get("browser");
        System.out.println(browser);
//        Assert.assertEquals(browser, "firefox");  // chrome
        System.out.println(ConfigurationReader.get("url")); //https://qa3.vytrack.com/user/login
        //when we provide a key that does not exist, it returns null
        System.out.println(ConfigurationReader.get("myBrowser"));   //null, no such key in Configuration File
    }
}
