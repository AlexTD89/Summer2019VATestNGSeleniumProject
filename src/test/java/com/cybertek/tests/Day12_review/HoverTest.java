package com.cybertek.tests.Day12_review;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/*
   TEst case 1
   Open chrome
   Go to http://practice.cybertekschool.com/hovers
   Hover over each image
   Verify that test user1, user2, user3 appears on the bottom of respective images
   close chrome

 */
public class HoverTest {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/hovers");
        actions = new Actions(driver);
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



    @Test
    public void test1(){
       //hover over each image
       //verify text user1, user2 , user3

        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (int i=0; i<3;i++){
            System.out.println(i);
            WebElement image = images.get(i);   // using List commands
//            WebElement image = driver.findElement(By.xpath("(//img)["+i+"]"));    // using iteration command
            actions.moveToElement(image).perform();

            actions.pause(2000); // thread.sleep like in Selenium

            WebElement text = driver.findElement(By.xpath("//h5[.='name: user"+(i+1)+"']"));
            Assert.assertTrue(text.isDisplayed());
        }

        //find all images outside the loop


    }

}
