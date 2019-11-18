package com.cybertek.tests.Day08_Select_List;



    /*

    List of elements:
    in selenium to locate a group of elements we use the findElements() method.
        this method returns a list of elements.



     */


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    @Test
    public void test(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //store all button elements in a List
        List<WebElement> buttons = driver.findElements(By.tagName("button"));   // we are storing multiple values in an List of WebElements.
        System.out.println(buttons.size()); //6

        Assert.assertEquals(buttons.size(), 6, "Test FAIL size is different");

        // we are iterating through the list of elements
        for( WebElement button: buttons){
            System.out.println(button.getText());
        }
                    /*

                Result:

                    Button 1
                    Button 2
                    Button 3
                    Button 4
                    Button 5
                    Don't click!

                     */


//        driver.quit();

    }


    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //store all button elements in a List
        List<WebElement> buttons = driver.findElements(By.tagName("utton"));
        System.out.println(buttons.size()); // 0
        //  this method returns a list pf elements. When we use the findElements method with wrong locator, NoSuchElement exception will not be thrown. Instead it will return an empty list.
        Assert.assertEquals(buttons.size(), 6, "Test FAIL size is different");  //throws Assertion Error
        /*
                    java.lang.AssertionError: Test FAIL size is different expected [6] but found [0]
                            Expected :6
                            Actual   :0
         */


        driver.quit();
    }

}
