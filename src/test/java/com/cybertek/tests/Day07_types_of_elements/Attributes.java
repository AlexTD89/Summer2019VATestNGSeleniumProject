package com.cybertek.tests.Day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
    getAttribute("attribute")    -->> returns the value of the given attribute of the element


 */

public class Attributes {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blue = driver.findElement(By.id("blue"));

        //  getAttribute("attribute")
        System.out.println(blue.getAttribute("id"));    // blue
        System.out.println(blue.getAttribute("name"));  // color
        System.out.println(blue.getAttribute("href"));  // null     -->> means this element does not have such element
        System.out.println(blue.getAttribute("class")); // empty -->> no such element

        //print an attribute that doesn't have a value
        System.out.println(blue.getAttribute("checked"));   // true


        System.out.println(blue.getAttribute("outerHTML")); // returns the whole html element information:   <input type="radio" id="blue" name="color" checked="">


        // returns the text of the element
        System.out.println(blue.getAttribute("value")); // on
        System.out.println(blue.getAttribute("innerHTML"));
        //or
        System.out.println(blue.getText());


//        driver.quit();
    }
}
