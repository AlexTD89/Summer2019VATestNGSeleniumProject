package com.cybertek.tests.D04_basic_locators;

public class Identify_elements {
    public static void main(String[] args) {

        /*
            WebDriver driver -> our page
            driver.fineElement(By.name/id())  -->> method sued to finds  elements on the page
            locators -> methods, means , instruments of finding elements on the page

            fineElement(By.name("email"))  --> building locator


            to find easy an element on the page: right click on the element ---> inspect...

            fend element method takes BY object as an argument
            By is a name of a class for locators

            there are 8 locators:
                                    id
                                    name
                                    class name
                                    tag name
                                    linktext
                                    partial link text
                                    xpath
                                    css locator



        one of biggest problem with selenium, is that the elements are dynamic, the ids' and names changes. and the selenium can't locate them.
        on order to use the id:
                            1.  it has to be unique,
                            2.  stable



        when locator is wrong, selenium throws NoSuchElementException

        findElement method does one of 2 things:
            if element is found ->> returns the web element
            if the element is not found ->> NoSuchElementException



        webElement is an important class




        if name and id is not available, we can use tagName:
            <input type="text" name="full_name">
            input ->> is tagName


        how to identify the tagName of the element:
            <h4 class="subheader">Sign up for our mailing list here.</h4>
            <input type="text" name="full_name">
            <label for="username">Full name</label>

            <h4 , <input , <labler   -->> are tagNames


             But if more elements have same tagName, selenium will mess up, and use the tagName of the first found element with that tagName, (selenium reads top to bottom)
                how to still use by tagNAme:
                    if the 2nd element has same tagName as the element above, you should not use tagName for the 2nd element

                 tagName -->> selenium always returns the first match to our locator.If we are using tag locators and our element is the second tag, we should not use tagName



    Class Name:

             Home button element:
            <a class="nav-link" href="/">Home</a>

            tagName -> <a
            class="nav-link" ->  class name


            If class has a space in it, we cannot use it.
                ex: findEmelent(By.className("btn btn-primary"));








         to start from the first button use tagName ( note it works only for the first button, for rest will not work, selenium will use first matching one, have to use by other locators)

        always make sure that the name, id, tagName or class name is unique before using it





        find link elements by text:   text has to match 100% in order to work, it will find the element by text
            linkText("text");

        find link by partial link/text partial link:
        ex link:    Example 6: Loading overlay that disappears and disappears again

            WebElement link6Again  = driver.findElement(By.partialLinkText("Example 6:"));
            System.out.println(link6Again.getText());


            link text and partialLinkTest works with ONLY links, not used to find just text on the page



         */






    }
}
