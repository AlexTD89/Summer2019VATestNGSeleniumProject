package com.cybertek.tests.Day15_page_object_model_based_tests;

/*
    Page Object Model:

        Framework is organization of files and folders in a way that makes automated tests easy.

        Properties files ->> keep the important test information

        More utilities:
            Configuration reader ->> reads from the properties file
            Test Base ->> contains common logic and properties for all tests.
            Driver class ->> single class that creates and provides web driver object for all tests

            Page object model ->> this is a design pattern that enhances ease of maintenance and re-usability. It is an encapsulated class that mirrors the behavior and objects of a
                                web page from the AUT. In page object model we create button that serve as object repository
                                easy to maintain, scale, reuse


            Page object model:
                >>  In page object model, we separate the test logic from UI logic.



            Pom file VS POM:
                Pom file ->> this is pom.xml and has nothing to do with selenium (Maven related)
                POM ->> page object model


    >> We are creating a new package called "pages" in cybertek folder.
   >>  Create a page object class for login page:
        1. right click on pages package
        2. new class
        3. Enter name: LoginPage
        4. ok


        Page Object Model VS PageFactory:
            Page object model ->> design pattern in selenium
            Page Factory ->> is a class in selenium using which we can create page object model.

         When we create a page object class, we create a public constructor for this class.  In the constructor body we call the initElements static method from the PageFactory class.
                initElements takes 2 parameters: 1. WebDriver object, 2. instance of this object


    picture one..(form my pc)
    picture 2 from (maruf pc)


    @FindBy ->> annotation from selenium, used to provide locator for the element
            @FindBy(id="prependedInput")    // by id, by css, by xpath, by name etc...
            public WebElement userName;
    @FindBys —> it takes multiple locators and finds element that match at least one of the
locators

@FindAll —> it takes multiple locators and finds element that match all of the locators








 */
public class notes {
}
