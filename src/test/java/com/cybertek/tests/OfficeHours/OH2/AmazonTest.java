package com.cybertek.tests.OfficeHours.OH2;

import com.cybertek.utilities.WebDriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    public static void main(String[] args) throws InterruptedException {

        // to see uf this is over 100
        // to see if it takes symbols
        // see if it takes alphanumeric or just letters
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://amazon.com");

        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        String sample = RandomStringUtils.random(995,true, true);
        String ending = "!~/.?!";
        searchBox.sendKeys(sample+ending);

        //get value method to validate
       String result =  searchBox.getAttribute("value");
       if(result.length()>1000&&(!result.contains("}"))){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
       }

        System.out.println(searchBox.getAttribute("value"));
       Thread.sleep(1000);
        driver.quit();
    }
}
