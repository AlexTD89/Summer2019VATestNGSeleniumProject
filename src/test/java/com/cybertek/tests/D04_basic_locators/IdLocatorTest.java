package com.cybertek.tests.D04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {

    public static void main(String[] args) throws InterruptedException {
//locate element by id
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //maximize the window
        driver.manage().window().maximize(); // maximizes the window
//      driver.manage().window().fullscreen(); // full screen mode

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        /*
            Button1:
                <button class="btn btn-primary" onclick="button1()">Button 1</button>
            Button2:
                <button class="btn btn-primary" onclick="button2()" name="button2">Button 2</button>
            Button3:
                <button class="btn btn-primary" onclick="button3()" id="button_check">Button 3</button>


                so far only Button3 has ID, so we will start with button 3

                BUT all buttons from button 1 to 6 are dynamic, so we can't use them. We need a stable one. (refresh the page and see)

                Button6 has a stable id

            Button6:
               <button class="btn btn-primary" onclick="button6()" name="button6" id="disappearing_button">Don't click!</button>



        to start from the first button use tagName ( note it works only for the first button, for rest will not work, selenium will use first matching one, have to use by other locators)
         */
        WebElement element = driver.findElement(By.id("disappearing_button")); // locate and save the element Button3

        String txt = element.getText(); // save the txt
        System.out.println("txt = " + txt);     // txt = Don't click!

        element.click();    // click the button


        Thread.sleep(1000);
        driver.quit();








    }



}
