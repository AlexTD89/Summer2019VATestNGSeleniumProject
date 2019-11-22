package com.cybertek.tests.Day11_file_upload_action_class;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void click(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement element = driver.findElement(By.linkText("Home"));
        //creating an object in JS
        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        executeScript   -->> method used to pass js command
//        first string argument is the javaScript code
//        second argument is the webelement on which the action will be taken
        jse.executeScript("arguments[0].click();", element);
    }

    @Test
    public void typeOnDisabledField() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement element = driver.findElement(By.xpath("//form/input"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String str = "hello";
        Thread.sleep(2000);
        jse.executeScript("arguments[0].setAttribute('value','" + str + "')",element);

        /*
            with JS we can type or interact with elements that are disabled

         */

    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll using JS
//        jse.executeScript("scroll(0, 250);");
        for(int i=0; i<5;i++){
            jse.executeScript("scroll(0, 250);");
            Thread.sleep(1000);
        }
    }
}
