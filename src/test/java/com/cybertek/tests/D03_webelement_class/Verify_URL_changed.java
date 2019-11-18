package com.cybertek.tests.D03_webelement_class;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Verify_URL_changed {

    /*
        1. open browser
        2. go to http://practice.cybertekschool.com/forgot_password
        3. enter any email
        4. click on Retrieve password
        5. verify that url changed to http://practice.cybertekschool.com/email_sent
     */

    public static void main(String[] args) {

        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to the page
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //find the element that accepts the email
        WebElement emailInput = driver.findElement(By.name("email"));

        //sendKeys() --> enters given text
        emailInput.sendKeys("teachervamikemarcus@gmail.com");

        //find and remember the element "retrieve password"
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));

        //click on element retrieve password
        retrievePassword.click(); // or driver.findElement(By.id("form_submit"+ Keys.ENTER));




        // get the actual URL
        String actualURL = driver.getCurrentUrl();
        // create a String that will remember the expected URL
        String expectedURL = "http://practice.cybertekschool.com/email_sent";

        //compare actual with the expected result
        System.out.println((actualURL.equals(expectedURL))?"PASS":"FAIL");

        //close the browser
        driver.quit();



    }
}
