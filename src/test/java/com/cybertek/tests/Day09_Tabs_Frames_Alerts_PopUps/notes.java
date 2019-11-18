package com.cybertek.tests.Day09_Tabs_Frames_Alerts_PopUps;


    /*


     Links:

        https://learn.cybertekschool.com/courses/264/pages/links?module_item_id=14408



        Tabs, Frames, Alerts, Pop Ups


        Pop ups || modal || dialog || overlay : anything that pops up from the page. 2 ways to deal with them:

                1. HTML POP UPS : if the pop up is from html we deal with it as if it is another web element. So we can right click and locate it, use find element
                        to get and we can click, get text...

                2. Java Script Alerts:
                        Second types of of popups comes from JS , mostly known as java script alerts. We can not right click on those alerts
                        In js alerts we will not be right click and see html. To deal with those in Selenium we have Alert Class

        Alert alert = driver.switchTo().alert();
        Lina above is how we create the alert object. This object now represents that alert.
            NonAlertPresentException -->> we get this when we call the driver.switchTo().alert() method while we don't have actual alert on page.
            Alert must be present
            We can accept, dismiss, send text to alerts




  TABS/Windows
     In selenium there is no difference between tabs and windows. By default selenium controls one page at a time or one html document at a time. When open a page it is looking at the first page.
        When we open a new  tab/window, it will be looking at the old page.To get a title of the new window, to do anything in the new window we have to switch to the new window.

      In selenium we use windows handles as unique ID for windows.
      driver.getWindowHandle();
      This method returns the current handle/ ID of the current window which selenium is controlling right now.

      driver.switchTo().window() -->> this method is used to change the tab/window, and it takes windows handle as parameters. If we we want to switch to certain window, we have to provide the handle of that window
      driver.getWindowHandles(); // this method gives all of the windows handles





     */

public class notes {


}
