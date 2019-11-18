package com.cybertek.tests.D03_webelement_class;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify_URL_not_changed {

    /*
          1.    open browser
          2.  go to http://practice.cybertekschool.com/forgot_password
          3.  click on Retrieve password
          4.  verify that url did not change

     */
    public static void main(String[] args) throws InterruptedException {
        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save the expected url
        String expectedURL = driver.getCurrentUrl();

        //click on Retrieve Password
        //WebElement --> class that represents elements from the webpage
        //findElement --> method used to find element on pages, returns a webelement
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        // retrievePassword will remember the element
        //By.id --> locator

        // clicks on element
        retrievePassword.click();

        // get the actual URL
        String actualURL = driver.getCurrentUrl();


        // 1st option to report
        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //2nd opt to report
        System.out.println((expectedURL.equals(actualURL))?"pass":"fail");

        Thread.sleep(1000);
        driver.close(); // close the browser

    }




}
