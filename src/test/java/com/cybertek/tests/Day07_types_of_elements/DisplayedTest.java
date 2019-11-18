package com.cybertek.tests.Day07_types_of_elements;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
    isDisplayed()   -->> a method that returns true if the element is visible
                        also can help to find out if a hidden element is displayed


 */
public class DisplayedTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blue = driver.findElement(By.id("blue"));

        //verify if element is displayed
        System.out.println(blue.isDisplayed()); //true
        //right way to test
        Assert.assertTrue(blue.isDisplayed());  // doesn't return anything since condition is true


        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        // VERIFY ELEMENT IS DISPLAYED

        WebElement home = driver.findElement(By.linkText("Home"));
        Assert.assertTrue(home.isDisplayed());

        // VERIFY ELEMENT NOT DISPLAYED
        WebElement blue1 = driver.findElement(By.id("username"));

        // verify if element is displayed on screen, verify if visible
        Assert.assertTrue(blue1.isDisplayed());




        driver.quit();
    }
}
