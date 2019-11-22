package com.cybertek.tests.Day09_Tabs_Frames_Alerts_PopUps;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class PopUpAndAlerts {
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
    public void htmlPopup(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //find "Destroy the World Button" and click it
        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();

        //click 'No' on pop up
        driver.findElement(By.xpath("//span[.='No']")).click();

    }

    @Test
    public void jsAlerts(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //trigger the pop up
        driver.findElement(By.xpath("//button[1]")).click();

        //accept alert
        Alert alert = driver.switchTo().alert(); // this is the way we create an alert object
        //accept alert  -->> clicking ok ni alerts
        alert.accept();


        //trigger the second alert
        driver.findElement(By.xpath("//button[2]")).click();
        //switch to the new alert
        alert=driver.switchTo().alert();
        //dismiss alert -->> clicking cancel/x on the alert
        alert.dismiss();    //

        //trigger the 3rd alert
        driver.findElement(By.xpath("//button[3]")).click();
        //switch to the 3rd alert
        alert = driver.switchTo().alert();
        //send keys to alert
        alert.sendKeys("red alert");
        //print text of the alert
        System.out.println(alert.getText());    // I am a JS prompt, returns what is on the Alert, not what we entered
        //dismiss alert / close alert
        alert.accept();


    }

    @Test
    public void switchWindowsTest(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("Before the window was opened: "+driver.getTitle());
        //open the new window
        driver.findElement(By.linkText("Click Here")).click();
        //still shows title of the old window, because we didn't switch to the new window/tab
        System.out.println("After new window was opened: "+driver.getTitle());
        /*
        Before the window was opened: Practice
        After new window was opened: Practice
         */

        // switch to the new window
        //  window()-->> changes between tabs/ windows
//        driver.switchTo().window("New Window"); // takes a string, in this case title of the page
                // but this method doesn't take "window title" as a parameter.
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("currentWindowHandle = " + currentWindowHandle);

//        driver.getWindowHandles(); // this method gives all of the windows handles
        //Set -->> is just like arrayLs=ist, but without duplicate values
        //getWindowHandles() -->> returns a set
        Set<String> windowHandles = driver.getWindowHandles();
        /*
        Window handles that are stored in the Set windowHandles.
                CDwindow-BC4C12C5DBE715511F860C17A664F72A
                CDwindow-CC0F24DD7D956F6DBED1B36AC545BCBD
         */

        for(String windowHandle: windowHandles){
            System.out.println(windowHandle);
            // iterate the set of handles and compare to the current handle
            // if the handle is not equal to the current than it is the handle of the new window
            if(!currentWindowHandle.equals(windowHandle)){
                //switch to the new window by passing its handle
                driver.switchTo().window(windowHandle);
            }
        }

        System.out.println("After switching "+driver.getTitle()); // After switching New Window

    }

    @Test
    public void changeByTitle(){
        driver.get("http://practice.cybertekschool.com/windows");
        String targetTitle = "New Window";
        driver.findElement(By.linkText("Click Here")).click();

        //how many tabs are open right now
        System.out.println(driver.getWindowHandles().size()); //2

        //iterate through all windows
        for(String handle: driver.getWindowHandles()){
            //Switch to them one by one
            driver.switchTo().window((handle));
            //get the title and compare target title
            if(driver.getTitle().equals(targetTitle)){
                //stop looping
                break;
            }

        }
        System.out.println(driver.getTitle());  // New Window

    }




}
