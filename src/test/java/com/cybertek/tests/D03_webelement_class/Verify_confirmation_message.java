package com.cybertek.tests.D03_webelement_class;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Verify_confirmation_message {
    /*
        1. open browser
        2. go to http://practice.cybertekschool.com/forgot_password
        3. enter any email
        4. verify that email is displayed in the input box
        5. click on Retrieve password
        6. verify that confirmation message says 'Your e-mail's been sent!'

     */

    public static void main(String[] args) throws InterruptedException {

        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to url
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //locate the email input element
        WebElement emailInput = driver.findElement(By.name("email"));

        //enter email
        String expectedEmail = "teachervamikemarcus@gmail.com";
        emailInput.sendKeys(expectedEmail);

        //verify that email is displayed in the input box
       // String actualEmail = emailInput.getText();
        String actualEmail = emailInput.getAttribute("value");

        /*
            getText()  -->> doesn't get the text from all over the page ( from the smart input boxes it will not get the text), instead use getAttribute
            getAttribute()  -->> gets text from input box
         */

        //compare actual with expected email
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedEmail = " + expectedEmail);;
            System.out.println("actualEmail = " + actualEmail);
        }

        //find and remember the element "retrieve password"
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));

        //click on element retrieve password
        retrievePassword.click();


        //show expected message
        String expectedMessage = "'Your e-mail's been sent!'";

        //locate the message element on the WebPage
        WebElement messageElement = driver.findElement(By.name("confirmation_message"));    // or (By.id("content"));
        String actualMessage = messageElement.getText();

        //compare actual with the expected message
        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }


        //quit the browser
        Thread.sleep(1000);
        driver.quit();

    }
}
