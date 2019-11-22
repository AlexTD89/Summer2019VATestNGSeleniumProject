package com.cybertek.tests.Day09_Tabs_Frames_Alerts_PopUps.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class practice2 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMethod(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
        driver.findElement(By.xpath("//span[.='No']")).click();

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //trigger 1st alert
        driver.findElement(By.xpath("//button[1]")).click();

        //accept alert
        //create alert object in order to interact with the alert
        Alert alert = driver.switchTo().alert();
        //accept the alert (click ok automatically)
        alert.accept();

        //trigger 2nd alert
        driver.findElement(By.xpath("//button[2]")).click();
        //switch to new alert
        alert=driver.switchTo().alert();
        //dismiss alert
        alert.dismiss();

        //trigger 3rd alert and input some text
        driver.findElement(By.xpath("//button[3]")).click();
        alert = driver.switchTo().alert();
        //send keys to alert
        alert.sendKeys("alexT");
        //accept alert
        alert.accept();
        //print the input text that was accepted by alert
        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());   // You entered: alexT
    }

    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("before new window was opened: "+driver.getTitle());

        //open new window
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        //save all current window handles in a list
        Set<String> windowHandles = driver.getWindowHandles();
        String currentWindowHandle = driver.getWindowHandle();

        //switch to new window
        for(String each: windowHandles){
            if(!currentWindowHandle.equals(each))
                driver.switchTo().window(each);
        }

        //display the title
        System.out.println(driver.getTitle()); //New Window

    }

    @Test
    public void test4(){
        driver.get("http://practice.cybertekschool.com/windows");
        String targetTitle = "New Window";
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getWindowHandles().size()); //2

        for(String each: driver.getWindowHandles()){
            driver.switchTo().window(each);
            if(driver.getTitle().equals(targetTitle))
                break;
        }

        System.out.println(driver.getTitle()); //New Window

    }
}
