package com.cybertek.tests.Day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
     CheckBoxes are type of the input elements which can be selected or unselected. When we have a group of checkboxes, selected or un-selecting one
            check box does not affect on selection of the other one


         //input[1] -->> give me element which is the first input among its siblings
 */
public class CheckBoxes {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));

        //printing
        System.out.println("Is checkBox1 selected: "+checkBox1.isSelected());   // Is checkBox1 selected: false
        System.out.println("Is checkBox2 selected: "+checkBox2.isSelected());   // Is checkBox2 selected: true

        //testing
        //Verify checkBox1 is not selected
        Assert.assertFalse(checkBox1.isSelected()); // doesn't return anything because the result is true
        //verify checkBox2 is selected
        Assert.assertTrue(checkBox2.isSelected());  // doesn't return anything because the result is true


        System.out.println("check the first checkBox");
        checkBox1.click();

        System.out.println("Is checkBox1 selected: "+checkBox1.isSelected());   // Is checkBox1 selected: true
        System.out.println("Is checkBox2 selected: "+checkBox2.isSelected());   // Is checkBox2 selected: true

        //verify that checkBox1 is selected
        Assert.assertTrue(checkBox1.isSelected());  //Is checkBox1 selected: true,   didn't print anything, since the condition is true
        //verify that checkBox2 is not selected
        Assert.assertTrue(checkBox2.isSelected());  // Is checkBox2 selected: true

        System.out.println("un-select 1st checkBox");
        checkBox1.click();
        System.out.println("Is checkBox1 selected: "+checkBox1.isSelected());   // Is checkBox1 selected: false
        System.out.println("Is checkBox2 selected: "+checkBox2.isSelected());   // Is checkBox2 selected: true

        //verify that checkBox1 is not selected
        Assert.assertFalse(checkBox1.isSelected());  //Is checkBox1 selected: true,   didn't print anything, since the condition is true
        //verify that checkBox2 is selected
        Assert.assertTrue(checkBox2.isSelected());  // Is checkBox2 selected: true




        driver.quit();
    }
}
