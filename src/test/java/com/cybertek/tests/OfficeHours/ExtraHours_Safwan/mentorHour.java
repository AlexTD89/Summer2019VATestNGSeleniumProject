package com.cybertek.tests.OfficeHours.ExtraHours_Safwan;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mentorHour {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome"); // open the browser
        driver.get("http://practice.cybertekschool.com/");

        /*
            http VS https  -->> https is secured, and when navigating the https url we have to use the full address:  https://www.bofa.com/sign-up
         */
        WebElement signUp = driver.findElement(By.linkText("Sign Up For Mailing List"));    // right click-> inspect  ->> find element id, name, tagName, or text
        signUp.click();

        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("John Doe");

        // driver.findElement(By.name("full_name")).sendKeys("joe don");  <<-- also works but it works without creating an object

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("johndoe@gmail.com");

        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

        WebElement text = driver.findElement(By.name("signup_message"));
        String welcomeText = text.getText();
        System.out.println(welcomeText);


//        Thread.sleep(1000);
//        driver.quit();

        /*
         driver.quit() VS driver.close()  -->> when we work with tabs and we need to close one or more tabs use .close()
                              if need to close the browser use .quit()



           getAttribute()  -->>
        */

    }
}
