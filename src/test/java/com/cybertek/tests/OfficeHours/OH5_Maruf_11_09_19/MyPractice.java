package com.cybertek.tests.OfficeHours.OH5_Maruf_11_09_19;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPractice {
    public static void main(String[] args) {
        testCase1_BookDetails();
        testCase2();
    }

    private static void testCase1_BookDetails(){
        //open browser and navigate link
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://amazon.com");

        //locate search bar and insert cookbook
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium cookbook");

        //locate search button
        WebElement searchButton = driver.findElement(By.xpath("//div/input[@type='submit']"));
        searchButton.click();

        //verify that first result matches the expected result
        String expectedResult = "Mastering Selenium WebDriver 3.0: Boost the performance and reliability of your automated checks by mastering";
        WebElement Result = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        String actualResult = Result.getText();

        //verify the author
        String expectedAuthor = "Mark Collin";
        WebElement author = driver.findElement(By.xpath("(//a[@class='a-size-base a-link-normal'])[1]"));
        String actualAuthor = author.getText();
        System.out.println((actualAuthor.equals(expectedAuthor))?"PASS":"FAIL\n"+actualAuthor+"\n"+expectedAuthor);

        //locate 'Books' Link and click it
        WebElement linkBooks = driver.findElement(By.xpath("//span[.='Books']"));
        linkBooks.click();

        //verify that title ends with 'books'
        String title = driver.getTitle();
        if(title.endsWith("Books")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("title = " + title);
            System.out.println("Doesn't end with books");
        }

        //quit browser
        driver.quit();
    }

    private static void testCase2(){
        //open browser and navigate link
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://amazon.com");

        //locate search bar and insert cookbook
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium cookbook");

        //locate search button
        WebElement searchButton = driver.findElement(By.xpath("//div/input[@type='submit']"));
        searchButton.click();

        //locate the link to the book
        WebElement linkBook = driver.findElement(By.xpath("//span[.='Selenium Testing Tools Cookbook - Second Edition']"));
        linkBook.click();

        //verify paper back price
        String expectedPaperPrice = "$44.99";
        WebElement paperPrice = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-price header-price']"));
        String actualPaperPrice = paperPrice.getText();
        if(actualPaperPrice.endsWith(expectedPaperPrice)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualPrice1 = " + actualPaperPrice);
            System.out.println("expectedPrice1 = " + expectedPaperPrice);
        }

        //verify kindle price
        String expectedKindlePrice = "$22.39";
        WebElement kindlePrice = driver.findElement(By.xpath("(//span[@class='a-size-base mediaTab_subtitle'])[1]"));
        String actualKindlePrice = kindlePrice.getText();
        if(actualKindlePrice.equals(expectedKindlePrice)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualKindlePrice = " + actualKindlePrice);
            System.out.println("expectedKindlePrice = " + expectedKindlePrice);
        }

        //quit browser
        driver.quit();
    }
}
