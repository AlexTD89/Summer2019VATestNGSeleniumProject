package com.cybertek.tests.D05_Xpath;

/*
     Locators:
        ID
        Nme
        Class Name
        Tag name
        Link text
        Partial link Text
        Xpath


    xpath locator:

            When we try to find element on page , sometimes we cannot use any of the locators above. They will not be
            sufficient to find the element we are interested in.
            In these cases we write our own costume locators based on certain syntax.. These types which we write are called xpath


            Xpath:
                It is a unique way to finding element on HTML page. Xpath navigates through the html  to find element based on the description we provide


        Absolute xpath:
            starts with single slash , it starts looking for elements from the root of the html document. /  means root.
            In xpath we describe all the elements between html and our element in descending order.
            Ex:          /html/body/div/div[2]/div/div/button
                    from html building the path to the element we need. From parent to child

        Disadvantages of absolute:  it relies on the page hierarchy, if developers changes the page, xpath will stop working

      What does slash mean?
           > if it is in the beginning of the xpath, it means start from the rood element, it is absolute xpath
           > if the slash is in the middle it means child



      Relative XPATH:
          Relative xpath starts with double slashes and looks anywhere in the page. If there is double in the beginning , it looks anywhere in the page.

          //i/a/ -->> find any element on the page, then find its child a
          This xpath uses parent/child relationship

          //h3  -->> find any element on the page

          What does double slash means?
            if it is in the beginning of the xpath, it looks anywhere in the page
            if the slash is in the middle it means any descendant

          //body//h3  -->> find any body element on the page, then find any child or descendant with name h3.



Practice:
                       <button class="btn btn-primary" onclick="button1()">Button 1</button>

Using attribute and value
        Button.  >> name of the tag
        Class >> this is attribute
        Btn primary >>  value of the class attribute
        Onclick  >> Another attribute
        Button1()   >>  value of the o'clock attribute

        //E[@A='t']
        E >> tag name
        A >> attribute
        t >>   value of the attribute

         //button[@onclick='button1()']  -->> find any element that has an attribute: onclick, value : button1


Any attribute with certain value
         //E[@*='t']    >> go find any element that has an attribute that has a text 't'
                        *  >> any attribute with a certain text


Find element By exact text
        Certain element with certain text:      anything between >t<  t>> is a text
        //a[.='t']      >> generic
        //button[.='Button 1']      >> specific to the element above
        //*[.='utton 1']       >> find any element, with any attribute that contains text 'utton 1'


Certain element with partial text
contains:
      //E[contains(text(), 't')]
      //button[contains(text(), 'utton 1')]  >> all the elements that contains text 'utton 1'

*/
/*




   <button class="btn btn-primary" onclick="button4()" id="cool_button">Button 4</button>

Find DYNAMIC elements using xpath
        //E[starts-with(@A, 't')]
        //button[starts-with(@id, 'button_')]

        ENDS WITH: doesn't work on chrome, works on firefox, ie, etc
        //E[ends-with(@A, 't')]


 INDEX
 Index based on siblings
    //E[index]
    //button[2]     >> give me button element but is has to be 2nd button
    //div/a[3]      >> find element a (child of div) that has index of(place) 3
    In html count starts from 1


Index of the MATCHES
    If I want to find from list of matches, but they do not have the same parent:
        1. Write that matches all elements
        //a[contains(text(), 'Dynamic')]  >>  2 out of 3
        2. Choose from those matches. Surround the xpath with parenthesis and then add index in brackets
        (//a[contains(text(), 'Dynamic')])[2]  >> 1 out of 1


Sibling:
    //E2/following-sibling::E1  >> generic

    //button[@onclick='button1()']/following-sibling::button        >> finds button with @onclick='button2()' and find all of its siblings that come after it

    //button[@onclick='button2()']/preceding-sibling::button    >> finds the element which is one step upper to button 2 element

 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_TestDemoClass {

    public static void main(String[] args) {
        //open browser and navigate link
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

 // Absolute xpath

        //find the element 'Home"
        WebElement link = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));
        //print the element
        System.out.println("link = " + link.getText());

        //find 2nd element, "Multiple Buttons"
        WebElement link2 = driver.findElement(By.xpath("/html/body/div/div/div/div/h3"));
        //print the element
        System.out.println("link2 = " + link2.getText());



 //Relative xpath

        //find 3rd element and print it "Home"
        WebElement link3 = driver.findElement(By.xpath("//li/a"));
        System.out.println("link3 = " + link3.getText());

        //find 4th element "Multiple Buttons"
        WebElement link4 = driver.findElement(By.xpath("//h3"));
        System.out.println("link4 = " + link4.getText());


        //find the 5th element , "button1"
        //Using attribute and value, another way of the xpath
        WebElement link5 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        System.out.println("link5 = " + link5.getText());

        //find element by the text
        WebElement link6 = driver.findElement(By.xpath("//button[.='Button 1']"));
        System.out.println("link6 = " + link6.getText());

        //find element by the partial text
        WebElement link7 = driver.findElement(By.xpath("//button[contains(text(), 'utton 1')]"));
        System.out.println("link7 = " + link7.getText());

        WebElement link8 = driver.findElement(By.xpath("//*[contains(text(), 'tek Sch')]"));
        System.out.println("link8 = " + link8.getText());

        //find dynamic element using xpath
        WebElement link9 = driver.findElement(By.xpath("//button[starts-with(@id, 'button_')]"));
        System.out.println("link9 = " + link9.getText());

        //



        //quit browser
        driver.quit();
    }
}
