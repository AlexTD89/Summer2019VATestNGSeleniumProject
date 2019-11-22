package com.cybertek.tests.Day12_review;

/*
    Test Case 6
    Go to google.com
    Search for something
    In the next page verify number results is displayed
    Go back home page
    Search for something else
    In the next page verify number results is displayed
 */


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://google.com");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("helooo"+ Keys.ENTER);
//        driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
    }

}
