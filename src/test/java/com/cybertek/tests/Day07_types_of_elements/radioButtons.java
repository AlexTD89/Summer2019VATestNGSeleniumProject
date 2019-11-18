package com.cybertek.tests.Day07_types_of_elements;


/*
        RADIO BUTTON:
            Type of elements in which only one can be selected. In a group of radio buttons, we should not be able to select 2 or more radio buttons.


       Methods:
        isSelected()    -->> comes from WebElement class and returns true if element is selected.  verified if the element is selected
        Assert.assertTrue() -->>    returns true if condition is true
        Assert.assertFalse()    -->>    returns true if condition is false

 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class radioButtons {

    @BeforeMethod
    public void setUp(){
        System.out.println("setUP");
    }


    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blue = driver.findElement(By.id("blue"));
        WebElement red = driver.findElement(By.id("red"));

        System.out.println("is blue selected: "+blue.isSelected()); //is blue selected: true
        System.out.println("is red selected: "+red.isSelected());   //is red selected: false

        //Verify if blue button is selected
        Assert.assertTrue(blue.isSelected());   // if it's true, it will not show or return anything, until it's false
        //Assert.assertTrue(!blue.isSelected());    // it will return false and show an error with details.

        //Verify if red is not selected
        Assert.assertFalse(red.isSelected());   // if it's true, it will not show or return anything, until it's false

        //clicking on red
        red.click();
        Assert.assertTrue(red.isSelected());    // it will return an error with details if it's false
        System.out.println("is red selected: "+red.isSelected());   // is red selected: true
        System.out.println("is blue selected: "+blue.isSelected()); // is blue selected: false
        Assert.assertFalse(blue.isSelected());  // doesn't return anything because it's true


        driver.quit();

    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("teardown");
    }


}
