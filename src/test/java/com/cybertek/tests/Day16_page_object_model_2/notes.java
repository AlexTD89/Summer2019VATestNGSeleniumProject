package com.cybertek.tests.Day16_page_object_model_2;

/*
    @FindBy ->> annotation from selenium, used to provide locator for the element
                @FindBy(id="prependedInput")    // by id, by css, by xpath, by name etc...
                public WebElement userName;

    @FindBys : When the required WebElement objects need to match all of the given criteria use @FindBys annotation
               annotation from selenium, it takes multiple locators and find element that match at least one of the locators
    @FindAll : When required WebElement objects need to match at least one of the given criteria use @FindAll annotation



Page object Model part2:

    TODO:
    open browser
    Login as driver
    Verify that page subtitle is Quick Launchpad
    Go to Activities —> Calenday Events
    Verify that page subtitle is Calenday Events


    BasePage ->> will contain common elements and functionalytys that are common to other pages. All pages that have those functionalities will extend BasePage.
    Create BasePage:
        1. Right click on pages package
        2. New -> Class
        3. Enter name: BasePage
        4. OK
        5. Make Class abstract

 */


public class notes {
}
