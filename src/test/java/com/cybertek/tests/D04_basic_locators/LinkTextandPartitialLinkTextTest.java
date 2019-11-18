package com.cybertek.tests.D04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextandPartitialLinkTextTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //find link elements by text
        //linkText("text");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link = driver.findElement(By.linkText("Example 6: Loading overlay that disappears and disappears again"));
        System.out.println("link = " + link.getText());

        WebElement cbt = driver.findElement(By.linkText("Cybertek School"));
        System.out.println("cbt = " + cbt.getText());


        //partial link
        WebElement link6Again  = driver.findElement(By.partialLinkText("Example 6:"));
        System.out.println(link6Again.getText());

        //link text and partialLinkTest works with ONLY links, not used to find just text on the page

        Thread.sleep(1000);
        driver.quit();

    }
}
