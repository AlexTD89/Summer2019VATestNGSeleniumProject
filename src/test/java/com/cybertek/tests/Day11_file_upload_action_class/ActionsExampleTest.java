package com.cybertek.tests.Day11_file_upload_action_class;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsExampleTest {
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

    @Test
    public void moveToTest(){
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        //Actions -->> class that contains all user interactions
        Actions actions = new Actions(driver);
        // moveToElement()  -->> moves mouse on top of the given element
        //perform() -->> complete the action, everytime after calling actions
        actions.moveToElement(img1).perform();
        //verify if the text is displayed
        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed());

    }

    @Test
    public void dragDropTest() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //source -->> we will drag this element
        WebElement source = driver.findElement(By.id("draggable"));
        // target -->> we drop here
        WebElement target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        //dragAndDrop() -->> drags the source to target
        actions.dragAndDrop(source,target).perform();
    }

    @Test
    public void dragDropByChainingTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //source -->> we will drag this element
        WebElement source = driver.findElement(By.id("draggable"));
        // target -->> we drop here
        WebElement target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);

        //clickAndHold()    -->> clicks on element and hold it
        //release() -->>    release the element after holding it
        //build()   -->> when having multiple actions together we call build() to have them work together.
//                        is used to chain the actions
        //we can chain multiple actions
        //at the end we call the build().perform()
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
    }
}
