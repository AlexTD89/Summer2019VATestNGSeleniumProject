package com.cybertek.tests.Day08_Select_List;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownListNoSelectedTagTest {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        /*
        Element:
            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      Dropdown link
    </a>

    doesn't have a select tag, means we have to treat it as a regular element
         */

        WebElement dropdownLink = driver.findElement(By.id("dropdownMenuLink"));

        // getOptions() >> method that for select class that returns all options from dropdown menu
//        dropdownLink.getOptions(); // can't use this method on regular webelement, since it;s not a select element
        dropdownLink.click();  // we can't hover( keep the mouse on top to open it) it needs to be clicked to show the options
        List<WebElement> options = driver.findElements(By.className("dropdown-item"));
        System.out.println("options.size() = " + options.size());

        for( WebElement option: options){
            System.out.println(option.getText());
        }

        driver.findElement(By.linkText("Yahoo")).click();
        Thread.sleep(1000);

        driver.quit();
    }
}
