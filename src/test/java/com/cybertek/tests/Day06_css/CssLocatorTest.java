package com.cybertek.tests.Day06_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
    Plan:
        Css Locator
        Comparison of locators
        Framework
        TEstNG


    Css Locators:

        locators previously learned: id, name, class name, tag name, link text, partial link test, xpath

     css uses a different syntax locator completely from the other. It is easier to read wnd write.
     Example:
            xpath: //div[@id='1234']
            css:   #1234


There is not relative or absolute css locator. No slashes.

 Using ID: E#I
            E ->> tag, element
            I ->> id
            
Can't use css locator with xpath. and vice-versa.

InvalidSelectionException:  thrown when providing locator with wrong selection.

#   -->> id in css
(dot).   ->> means class in css

Using class:
element: <a class="nav-link" href="/">Home</a>

css: a.nav-link   (css locator with class) -->> A link that has class nav-link
css:    .nav-link       -->> any element that has class nav-link


element <button class="btn btn-primary">
class= 'button button-primary'  -->> if there is a space between value of class means that it actually has 2 classes.



 */
public class CssLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        /*

 Using ID: E#I
            E ->> tag, element
            I ->> id


            element:        <button class="btn btn-primary" onclick="button6()" name="button6" id="disappearing_button">Don't click!</button>

                css locator:            button#disappearing_button   ( a button element whose id is equal to : button#disappearing_button)
                xpath:      //button[@id, 'button#disappearing_button']
                
                
                Css: ##disappearing_button  -->> any element that has id equals to value: disappearing_button



Using class value:
             element:        <button class="btn btn-primary">
                class= 'button button-primary'  -->> if there is a space between value of class means that it actually has 2 classes.

             css: button.btn.btn-primary    -->> all buttons that has class btn and btn-primary    (if it has more classes you can use all of them, Or use just one)
                    .btn.btn-primary    -->> all elements that has class btn and btn-primary


             When we use css selected with class (dot). It means contains, not equals.
                        button.btn   -->> here button element can have more classes


Using Attribute Value:
            css:    tag[attr='value']

            element:        ,a class='nav-link'>
            xpath:  //a[@class,'nav-link']
            css:    a[class='nav-link']


Using name:
    Element:    <button class="btn btn-primary" onclick="button6()" name="button6" id="disappearing_button">Don't click!</button>

        css:   button[name='button6']       -->> a button element where name is equal to button6
                [name['button6']    -->> any element where name is equal to button6
        xpath:  //button[@name='button6']

        Multiple Attributes;
        button[name='button6'][onclick='button6()'] -->> a button element where name is equal to button6 and onclick to 'button6()'

In case of multiple attributes we do not have to use attributes in the same order.



Dynamic Elements:
        contains:   E[A*='t']           *-->> contains
            element with dynamic ID:        <button class="btn btn-primary" onclick="button4()" id="check_button">Button 4</button>
                                            <button class="btn btn-primary" onclick="button4()" id="btnbtn_button">Button 4</button>

             css:   button[id*='_button']   -->> any button element that contains id   "_button"
                    [id*='_button']     -->>    any element that contains id   "_button"



        starts-with:    E[A^='t']
            css:    button[id^='button_']   -->> (supposedly it starts with this...)    the element button with id that starts with: button_
                    [id^='button_']     -->> any element with id that starts with: button_



        ends-with:  E[A$='t']
            css: button[id$='_button']      -->>    any button element where id ends with "_button"
                    [id$='_button']     -->>    any element where id ends with "_button"
                 button[name*='bu'][onclick='button6()']    -->>     a button element with name that starts with 'bu' and onclick attribute that contains 'button6()']




By Tag Name:
        xpath: //tag
                //h3        ->> all h3 elements
        css:    tag     ((no slashes needed)
                h3      -->>    all h3 elements


 Child and Descendants

        xpath:      //tag/tag/tag.    -->> child element of the parent tag
        css:        tag>tag>tag.        -->> child element
                    tag tag tag         -->> descendant element, space means descendant
                    div>h3      -->>    find any h3 element whose parent is div
                    ul>li>a     -->> find u;, then child li, then its child a
                    ul li a     -->>  find ul, then child li, then its child a






Indexing   :    NTH OF TYPE
    xpath:  //tag[index]
            //button[1]
    css:    tag:nth-of-type(index)
            button.btn-primary:nth-of-type(3)
            button:nth-of-type(2)



preceding/following:    E2~E1
        css:    h3~p        -->> find h3 element then find its' following sibling 'p'
                p+button    -->> find p element then find its' following sibling 'button'



Text:


Different:





xpath vs css
    1.  css is slightly faster on IE, in other browsers difference is negligible
    2.  css is easier to read and write
    3.  css can't do
         > css cannot locate with text, if we need to rely on text to find element we will use xpath
        xpath: //button[.='Submit']
         > it cannot find from matches based on index
        xpath:  (//input[name='radio'])[1]
         > searching for parents
        xpath:  //div/form/span
        css:    div>form>span

        opposite, go back(up) to previous element:
            xpath:  //span/..
            css: can't do
    4.  Xpath can do more than css, but css is more flexible to write the locator



  Hierarchy of locators:

    FOR ALL ELEMENTS OTHER THAN LINKS:
        LinkText:
        PartialLinkText:
        ID: always look for id first, they are unique
        NAME:   not always unique, but they do not repeat that much
        TAG NAME:   if the tag is unique or element we looking for comes first
        CLASS NAME:    if the class of the element is unique or element we looking for comes first
        CSS:
        XPATH:


  For what reasons we get NoSuchElementException?
        1. when the locator is wrong (when i wrote the locator, or wrong selector (By.id; By.name..)
        2. Not enough wait time, provide more time
        3. Frames. Switch frames




    find.element() VS find.elements()
        1. find one element
        2. find all elements ( if selenium doesn't find any elements it will return an empty list, it will not complain)








         */

        //locate an element using css locator
        WebElement element = driver.findElement(By.cssSelector("button#disappearing_button"));
        System.out.println("element = " + element.getText());   // element = Don't click!
        
        WebElement element1 = driver.findElement(By.cssSelector("#disappearing_button"));
        System.out.println("element1 = " + element1.getText());   // element1 = Don't click!

        WebElement element2 = driver.findElement(By.cssSelector(".nav-link"));
        System.out.println("element2 = " + element2.getText());   // element2 = Home

        WebElement element3 = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        System.out.println("element3 = " + element3.getText()); //element3 = Button 1

        WebElement element4 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        System.out.println("element4 = " + element4.getText()); // element4 = Home

        WebElement element5 = driver.findElement(By.cssSelector("button[name='button6']"));
        System.out.println("element5 = " + element5.getText()); //  element5 = Don't click!

        WebElement element6 = driver.findElement(By.cssSelector("button[name='button6'][onclick='button6()']"));
        System.out.println("element6 = " + element6.getText()); //  element6 = Don't click!

        WebElement element7 = driver.findElement(By.cssSelector("button[id*='_button']"));
        System.out.println("element7 = " + element7.getText()); //  element7 = Button 4

//        WebElement element8 = driver.findElement(By.cssSelector("button[id^='button_']"));
//        System.out.println("element8 = " + element8.getText()); //

        WebElement element9 = driver.findElement(By.cssSelector("button[id$='_button']"));
        System.out.println("element9 = " + element9.getText()); //  element9 = Button 4

        WebElement element10 = driver.findElement(By.cssSelector("button:nth-of-type(2)"));
        System.out.println("element10 = " + element10.getText()); //    element10 = Button 2

        WebElement element11 = driver.findElement(By.cssSelector("h3~p"));
        System.out.println("element11 = " + element11.getText()); //    element11 = Here are some examples of different buttons with different attributes:

        WebElement element12 = driver.findElement(By.cssSelector("p+button"));
        System.out.println("element12 = " + element12.getText()); //    element12 = Button 1

        driver.quit();

    }



}
