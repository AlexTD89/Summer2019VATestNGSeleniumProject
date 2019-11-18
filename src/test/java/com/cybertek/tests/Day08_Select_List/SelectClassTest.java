package com.cybertek.tests.Day08_Select_List;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
    Select Class:
       is used to deal with dropdown lists  (that will contain many other elements)

        Select >> is HTML tag that is used for dropDown lists (menus).
        In Selenium we use the SELECT class to deal with those elements with select tag.
        Select only works with select tag.

        How to use Select class:
              1. make sure to dropdown uses the select tag
              2. Locate the element with the select tag
              3. Create Select object by passing the elements from step 2 as constructor


          Select class require constructor of type webElement. That element must have tag select.

          When try to create a select class object but passing web element which does not have select tag. We get unexpectedTagException.

          getFirstSelectedOption(); // a method that returns first selected option
          stateList.getFirstSelectedOption(); // a method that returns what is currently selected, returns a webElement
          getFirstSelectedOption().getText()    >> returns a text of what is currently selected
          stateList.selectByVisibleText("Ohio"); //   -->> a method that makes a selection of a specific element from the select list by visible text


    gitHUB with notes:
        https://github.com/CybertekSchool/Summer2019VATestNGSeleniumProject/tree/master/src/test/java/com/cybertek/tests/d8_select_list

 */
public class SelectClassTest {



    @Test
    public void printAllOptions(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        /*

        the element with select tag:


        <select id="state">
              <option value="" selected="selected">Select a State</option>
              <option value="AL">Alabama</option>
              <option value="AK">Alaska</option>
              <option value="AZ">Arizona</option>
              <option value="AR">Arkansas</option>
              <option value="CA">California</option>
              <option value="CO">Colorado</option>
              <option value="CT">Connecticut</option>
              <option value="DE">Delaware</option>
              <option value="DC">District Of Columbia</option>
              <option value="FL">Florida</option>
              <option value="GA">Georgia</option>
              <option value="HI">Hawaii</option>
              <option value="ID">Idaho</option>
              <option value="IL">Illinois</option>
              <option value="IN">Indiana</option>
              <option value="IA">Iowa</option>
              <option value="KS">Kansas</option>
              <option value="KY">Kentucky</option>
              <option value="LA">Louisiana</option>
              <option value="ME">Maine</option>
              <option value="MD">Maryland</option>
              <option value="MA">Massachusetts</option>
              <option value="MI">Michigan</option>
              <option value="MN">Minnesota</option>
              <option value="MS">Mississippi</option>
              <option value="MO">Missouri</option>
              <option value="MT">Montana</option>
              <option value="NE">Nebraska</option>
              <option value="NV">Nevada</option>
              <option value="NH">New Hampshire</option>
              <option value="NJ">New Jersey</option>
              <option value="NM">New Mexico</option>
              <option value="NY">New York</option>
              <option value="NC">North Carolina</option>
              <option value="ND">North Dakota</option>
              <option value="OH">Ohio</option>
              <option value="OK">Oklahoma</option>
              <option value="OR">Oregon</option>
              <option value="PA">Pennsylvania</option>
              <option value="RI">Rhode Island</option>
              <option value="SC">South Carolina</option>
              <option value="SD">South Dakota</option>
              <option value="TN">Tennessee</option>
              <option value="TX">Texas</option>
              <option value="UT">Utah</option>
              <option value="VT">Vermont</option>
              <option value="VA">Virginia</option>
              <option value="WA">Washington</option>
              <option value="WV">West Virginia</option>
              <option value="WI">Wisconsin</option>
              <option value="WY">Wyoming</option>
        </select>
         */

        //locate the element with select tag
        WebElement element = driver.findElement(By.id("state"));

//        WebElement element = driver.findElement(By.id("a"));  // will through unexpectedTagException exception.

        //Create Select object by passing the element from tep 2 as constructor
        Select stateList = new Select(element);

        //getOptions() -->> returns all the available options from the dropdown list
        List<WebElement> options = stateList.getOptions();
        System.out.println(options.size());

        for (WebElement option: options){
            System.out.println(option.getText());
        }

        /*
                Result:

                        Select a State
                        Alabama
                        Alaska
                        Arizona
                        Arkansas
                        California
                        Colorado
                        Connecticut
                        Delaware
                        District Of Columbia
                        Florida
                        Georgia
                        Hawaii
                        Idaho
                        Illinois
                        Indiana
                        Iowa
                        Kansas
                        Kentucky
                        Louisiana
                        Maine
                        Maryland
                        Massachusetts
                        Michigan
                        Minnesota
                        Mississippi
                        Missouri
                        Montana
                        Nebraska
                        Nevada
                        New Hampshire
                        New Jersey
                        New Mexico
                        New York
                        North Carolina
                        North Dakota
                        Ohio
                        Oklahoma
                        Oregon
                        Pennsylvania
                        Rhode Island
                        South Carolina
                        South Dakota
                        Tennessee
                        Texas
                        Utah
                        Vermont
                        Virginia
                        Washington
                        West Virginia
                        Wisconsin
                        Wyoming
         */




        driver.quit();
    }

    @Test
    public void selectAndVerifyifSelected() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        // create a select object.
        //1. locate the webElement with select tag
        //2. create a Select class object by passing that webElement as a constructor

        Select stateList = new Select(driver.findElement(By.id("state"))); // a little different from the line 112
        System.out.println();

        //verify that by default 'Select a state' (element) is selected
//        stateList.getFirstSelectedOption(); // a method that returns what is currently selected, returns a webElement
//        getFirstSelectedOption().getText()    >> returns a text of what is currently selected

        String actualSelection = stateList.getFirstSelectedOption().getText();
        System.out.println("actualSelection = " + actualSelection); //actualSelection = Select a State

        Assert.assertEquals(actualSelection,"Select a State" , "don't match"); // write way to compare values


        Thread.sleep(1000);
        //Select using visible text    elements: <option value="AZ">Arizona</option>
        stateList.selectByVisibleText("Ohio"); //
        actualSelection = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection, "Ohio", "Values don't match");

        //Select using Index
        stateList.selectByIndex(51);    //>> select using the index of the option, count starts from 0
        actualSelection=stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection, "Wyoming");

        Thread.sleep(1000);
        //Select By Value
        //selectByValue("DC")   >>  selects by the value of the value attribute
        //  <option value="AZ">Arizona</option>
        stateList.selectByValue("DC");
        actualSelection=stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection, "District Of Columbia");

        //research....
        stateList.deselectAll();
        stateList.getAllSelectedOptions();







        driver.quit();
    }



}
