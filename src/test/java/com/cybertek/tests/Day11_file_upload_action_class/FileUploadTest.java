package com.cybertek.tests.Day11_file_upload_action_class;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    /*
     go to website http://practice.cybertekschool.com/upload
     upload file
     click upload
     verify file name is displayed in the next page
     */
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");
        //find upload button , send the path of the file to be upload
        driver.findElement(By.id("file-upload")).sendKeys("/Users/alex/Desktop/file.txt");
        //click upload button
        driver.findElement(By.id("file-submit")).click();
        //verify if the file was uploaded
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"file.txt");


    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");
        String filePath ="/Users/alex/IdeaProjects/Summer2019VATestNGSeleniumProject/src/test/resources/test_file.txt";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        //click upload button
        driver.findElement(By.id("file-submit")).click();
        //verify if the file was uploaded
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"test_file.txt");

    }

    @Test
    public void test2_1(){
        driver.get("http://practice.cybertekschool.com/upload");

        //how to locate file path using java
        String projectPath = System.getProperty("user.dir");
        String fileRelativePath = "/src/test/resources/test_file.txt";
        String fullPath = projectPath+fileRelativePath;

        driver.findElement(By.id("file-upload")).sendKeys(fullPath);
        //click upload button
        driver.findElement(By.id("file-submit")).click();
        //verify if the file was uploaded
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"test_file.txt");


    }




}
