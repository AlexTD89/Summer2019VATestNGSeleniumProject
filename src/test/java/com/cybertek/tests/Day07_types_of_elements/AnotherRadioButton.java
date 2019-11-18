package com.cybertek.tests.Day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnotherRadioButton {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement basketball = driver.findElement(By.id("basketball"));
        WebElement football =   driver.findElement(By.id("football"));

        //verify if both radio buttons are not selected
        Assert.assertFalse(basketball.isSelected());
        Assert.assertFalse(football.isSelected());

        //how to check if my test is working -->> make test fail
//        Assert.assertTrue(basketball.isSelected());   //>> it will fail, since condition is false
        //or..
//        Assert.assertFalse(!basketball.isSelected());


        driver.quit();

    }



}
