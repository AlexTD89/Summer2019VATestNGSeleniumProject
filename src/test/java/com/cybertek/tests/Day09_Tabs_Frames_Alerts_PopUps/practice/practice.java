package com.cybertek.tests.Day09_Tabs_Frames_Alerts_PopUps.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class practice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
       driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/iframe");

        //switch to the frame
        driver.switchTo().frame("mce_0_ifr");
        //find text input box and insert text
        driver.findElement(By.id("tinymce")).sendKeys("Hello");

        //go back to the first frame
        driver.switchTo().defaultContent();

        //find a frame by index
        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).sendKeys("lallala");

        // go back to parent frame
        driver.switchTo().parentFrame();

        //find by WebElement
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.id("tinymce")).sendKeys("ggogogoo");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        System.out.println(driver.getTitle());

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

    }

}
