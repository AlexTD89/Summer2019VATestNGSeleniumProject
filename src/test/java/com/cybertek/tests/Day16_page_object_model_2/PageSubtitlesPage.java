package com.cybertek.tests.Day16_page_object_model_2;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitlesPage extends TestBase {

    @Test
    public void verifySubTitleTest(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

        DashBoardPage dashBoardPage = new DashBoardPage();
        String actual = dashBoardPage.getPageSubTitle();

        Assert.assertEquals(actual, "Quick Launchpad");

        dashBoardPage.navigateToModule("Activities", "Calendar Events");
        actual = dashBoardPage.getPageSubTitle();
        Assert.assertEquals(actual, "Calendar Events");

    }
}
