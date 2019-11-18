package com.cybertek.tests.D04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocatorDemo {

    public static void main(String[] args) throws InterruptedException {

        //locate element by tagName


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.tagName("input"));
        fullName.sendKeys("John Doe");

        /*
            if name and id is not available, we can use tagName:
            <input type="text" name="full_name">
            input ->> is tagName
         */

        WebElement email = driver.findElement(By.name("email")); // we have to use By.name  because tagName is the same with the fullName element
        email.sendKeys("johndoe@gmail.com");

        /*
                But if more elements have same tagName, selenium will mess up, and use the tagName of the first found element with that tagName, (selenium reads top to bottom)
                how to still use by tagNAme:
                    if the 2nd element has same tagName as the element above, you should not use tagName for the 2nd element
         */

        /*
            we researched that this page has only one element that has same tagName "button", that we can use it bellow

            to search for tag: ctrl+f   and search for same name
         */

        WebElement signupButton = driver.findElement(By.tagName("button"));
        signupButton.click();



        Thread.sleep(1000);
        driver.quit();
    }
}
