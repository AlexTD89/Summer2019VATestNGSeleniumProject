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


        TODO:
        VERIFY RADIO BUTTONS
        Open browser
        Login as driver
        Go to Activities —> Calenday Events
        Click on crate calendar events
        Click on repeat
        Verify that repeat every days is checked
        Verify that repeat weekday is not checked

        TODO
        VERIFY REPEAT OPTIONS
        Open browser
        Login as driver
        Go to Activities —> Calendar Events
        Click on crate calendar events
        Click on repeat
        Verify that repeat options are Daily, Weekly, Monthly, Yearly (in that order)

 */


public class notes {
}
