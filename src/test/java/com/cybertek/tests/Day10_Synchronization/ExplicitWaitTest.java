package com.cybertek.tests.Day10_Synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000); // pause the quit, just to see the result
        driver.quit();
    }

    @Test
    public void testWaitForVisible(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        //click on start
        driver.findElement(By.tagName("button")).click();

        WebElement username = driver.findElement(By.id("username"));

        //Create explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //actually wait command
        //waiting for specific element to be visible
        wait.until(ExpectedConditions.visibilityOf(username));
        //line 46 && 49 is Explicit Wait

        //click on the element that is not visible
        username.sendKeys("userNameDO");

    }

    @Test
    public void test2ToBeEnabled(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));

        //click Enable button to enable input box
        driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();

        // set up the explicit wait for the specific element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait until element to be clickable/ enabled
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        //input text
        inputBox.sendKeys("Alexandru");
    }
}
