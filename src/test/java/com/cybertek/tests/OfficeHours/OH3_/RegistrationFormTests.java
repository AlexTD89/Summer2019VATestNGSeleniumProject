package com.cybertek.tests.OfficeHours.OH3_;

/*


 */


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationFormTests {

    public static void main(String[] args) throws InterruptedException {
//        //using the utilities folder to set up and open browser
//        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        driver.get("http://google.com");

        //manually set up and open browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();

        //navigate
        driver1.get("http://practice.cybertekschool.com");

        /*
            <a href="/registration_form">Registration Form</a>
            a - it'a atag name, that is used to create hyperlinks
            href - it's an attribute that describes destination of the page
            whatever is between >text> callis link
            Registration form - is a link

         */

        //find element && click on it
        driver1.findElement(By.linkText("Registration Form")).click();

        //find element
        driver1.findElement(By.name("firstname")).sendKeys("Some Testuser");

        /*
            contains() method used for partial text/value
            it's useful for dynamic elements, when some elements are partially change
         */

        driver1.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("My Last Name");
        driver1.findElement(By.cssSelector("[placeholder='username']")).sendKeys("username");

        //quit the browser
        Thread.sleep(3000);
        driver1.quit();

    }

}
