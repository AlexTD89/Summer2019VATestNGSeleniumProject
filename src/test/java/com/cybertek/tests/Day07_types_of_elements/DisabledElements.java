package com.cybertek.tests.Day07_types_of_elements;


/*

    Disabled Element: is an element that you can't interact with it.

        isEnables   -->> comes from WebElement class and returns true if element Enabled (User can't interact with it)

        Wen we try to interact with disabled element 2 things can happen:
            >   no action will be taken but code will not fail.
            >   no action will be takes and ElementNotInteractableException    will be thrown


       For disabled elements, look into the html code, for that element which is disabled. find attribute 'disabled' you can delete it to make it available (for fun)


how to find element from parent to child
#input-example>input
   1) #input-example  --> any element that has id input example
   2) >input  -> child of that element with tag input





 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DisabledElements {


    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement green = driver.findElement(By.id("green"));
        System.out.println("Is element enabled: "+green.isEnabled());   //Is element enabled:false
        green.click();

        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement input = driver.findElement(By.cssSelector("#input-example>input"));
        System.out.println("Is element enabled: "+input.isEnabled());   // Is element enabled: false
//        input.sendKeys("asdadascaf"); // throws error, since it can't input anything because the element is disabled




//        driver.quit();
    }
}
