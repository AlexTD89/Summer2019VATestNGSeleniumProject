package com.cybertek.tests.Day09_Tabs_Frames_Alerts_PopUps;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrames {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/iframe");

        // will not find a page inside another page before we tell selenium to do it
//        driver.findElement(By.id("tinymce")).sendKeys("Hello");

        //switch to iframe
        //1.    id or Name
        //switchTo().frame()    -->> switch to frame
        driver.switchTo().frame("mce_0_ifr");   // look for iframe tag
        //send a text
        driver.findElement(By.id("tinymce")).sendKeys("Hello");

        //go back to the first frame, useful when we have switched multiple frames and need to come to main content.
        driver.switchTo().defaultContent();

        // 2.   INDEX
        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).sendKeys("Hello121212123");

        // go back to parent frame
        driver.switchTo().parentFrame();

        //3. WebElement-->> locate the iframe element and pass as argument
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.id("tinymce")).sendKeys("Hiiiiiiiiiiiiiii");
        driver.findElement(By.id("tinymce")).clear(); /// delete entered text, then you can enter something else


    }


    @Test
    public void manyManyFrames(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        System.out.println(driver.getTitle());
        // go top frame
        driver.switchTo().frame("frame-top");
        System.out.println(driver.getTitle());  // no title, nothing was printed

        //switch to mid frame
        driver.switchTo().frame("frame-middle");

        // go back to parent frame
//        driver.switchTo().defaultContent();   // >> will take us to the grand parent HTML..., we need to get to parent frame 'top-frame'
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");




    }





}
