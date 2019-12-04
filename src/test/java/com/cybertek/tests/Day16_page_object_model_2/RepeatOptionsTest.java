package com.cybertek.tests.Day16_page_object_model_2;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {

    /*
    TC1:
    VERIFY RADIO BUTTONS
    Open browser
    Login as driver
    Go to Activities —> Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    Verify that repeat weekday is not checked
     */

    @Test
    public void radioRepeatEveryRadioButtonsTest(){
        //login as driver
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

        //go to Activities module, go to Calendar events module
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.navigateToModule("Activities", "Calendar Events");

        //click on Create calendar events button
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();    // method that will wait for loader to disappear
        calendarEventsPage.createCalendarEvent.click();

        //click on repeat button
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();    // method that will wait for loader to disappear
        createCalendarEventsPage.repeat.click();

        //verify that repeat every day  is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(), "Repeat Every day(s) should be selected");

        //verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "Repeat Weekdays should not be selected");

    }




     /*
    TC2:
    VERIFY REPEAT OPTIONS
    Open browser
    Login as driver
    Go to Activities —> Calenday Events
    Click on crate calendar events
    Click on repeat
    Verify that repeat options are Daily, Weekly, Monthly, Yearly (in this order)
     */

     @Test
    public void radioRepeatEveryRadioOptionsTest(){
         //login as driver
         LoginPage loginPage = new LoginPage();
         String username = ConfigurationReader.get("driver_username");
         String password = ConfigurationReader.get("driver_password");
         loginPage.login(username,password);

         //go to Activities module, go to Calendar events module
         DashBoardPage dashBoardPage = new DashBoardPage();
         dashBoardPage.navigateToModule("Activities", "Calendar Events");

         //click on Create calendar events button
         CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
         calendarEventsPage.waitUntilLoaderScreenDisappear();    // method that will wait for loader to disappear
         calendarEventsPage.createCalendarEvent.click();

         //click on repeat button
         CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
         calendarEventsPage.waitUntilLoaderScreenDisappear();    // method that will wait for loader to disappear
         createCalendarEventsPage.repeat.click();

         //todo verify that repeat options are in order
         //My approach
         String expected = "Daily Weekly Monthly Yearly";
         Assert.assertEquals(expected, createCalendarEventsPage.repeatOptions.getText().replace("\n", " "));

         //Teacher approach
         List<String> expectedOptions = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
         List<WebElement> options = createCalendarEventsPage.repeatOptionsList().getOptions();
         List<String> actualList = BrowserUtils.getElementsText(options);   // this method is a costume one, gets the text from the webElements.
         Assert.assertEquals(actualList, expectedOptions, "Repeat options did not match");



     }

}
