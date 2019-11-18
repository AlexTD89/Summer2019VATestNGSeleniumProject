package com.cybertek.tests.OfficeHours.OH2;

/*
        getText()
        getAttribute("innerHtml")  -->> to find id, class, tag... attributes

        explicit implicit wait
        expectedWait condition
        expectedImplicitSystem.setProperty("something", " source of the folder");



        Bonigarcia vs Oldway

Bonigarcia:
        Webdriver driver = new Chromedriver();
        WebDriverManager.chromedriver().setup();

        old way:
        System.setProperty("webdriver.chromedriver", "path to the chromedriver that you download);


        RandomStringUtils.random()   -->> used for generating random strings of random length


        when looking for webelemnts '#' sign in front of the atribute, # search for only id attribute
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mentor {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://washingtondc.craigslist.org/d/free-stuff/search/nva/zip");

        WebElement inputBox = driver.findElement(By.id("query"));
     //   inputBox.sendKeys("november second");

        String sample = RandomStringUtils.random(94, true, true);
        inputBox.sendKeys(sample+"!?.,(^");
// also this way:
//        inputBox = driver.findElement(By.xpath("//*[@id='query']"));
//        inputBox.sendKeys("hey you");
        System.out.println("inout box says - "+inputBox.getAttribute("value")); // checking the value that we typed

        //example: user story
        //Acceptance criteria 1.0# - input box should be 100 free text characters
        if(inputBox.getAttribute("value").length()==100){
            System.out.println("PASS");
        }else{
            System.out.println("TRUE");
        }


        //////////


    }

}
