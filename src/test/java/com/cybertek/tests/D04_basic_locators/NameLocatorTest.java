package com.cybertek.tests.D04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        //locate element by name


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        // locat Full Name box input element and input full name
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("John Doe");

        //locat the email input box and input the email
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("johndoe@gmail.com");

        //locate the signup button and click it
        WebElement signupButton = driver.findElement(By.name("wooden_spoon"));
        signupButton.click();






    Thread.sleep(1000);
    driver.quit();
    }
}
