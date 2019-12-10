package com.cybertek.tests.Day_pom_Practice;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInformationTests extends TestBase {
    /*
            Test Case
            Go to https://qa3.vytrack.com/user/login
            Go to customers —> contacts
            Click on email mbrackstone9@example.com
            Verify that full name is Ms Mariam Brackstone
            Verify that email is 18982323434
            Verify that phone number is   mbrackstone9@example.com
 */

    @Test
    public void contactDetailsTest(){
        //add this test to the extent report
        extentLogger = report.createTest("Contact details test");
        //login
        extentLogger.info("Login as sales manager");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("username:"+ConfigurationReader.get("sales_manager_username"));
        extentLogger.info("password: "+ConfigurationReader.get("sales_manager_password"));
        loginPage.login(ConfigurationReader.get("sales_manager_username"), ConfigurationReader.get("sales_manager_password"));

        //go to costumers -->> contacts
        extentLogger.info("Go to costumers -->> contacts");
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.navigateToModule("Customers", "Contacts");

        //Click on email mbrackstone9@example.com
        extentLogger.info("Click on email mbrackstone9@example.com");
        //wait before clicking
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        //verify
        ContactInformationPage contactInformationPage = new ContactInformationPage();
        extentLogger.info("Verify that full name is Ms Mariam Brackstone");
        String actualName = contactInformationPage.contactFullName.getText();
        Assert.assertEquals(actualName, "Ms Mariam Brackstone");
        extentLogger.info("verify that phone number is 18982323434");
        String actualPhoneNumber = contactInformationPage.phone.getText();
        Assert.assertEquals(actualPhoneNumber, "+18982323434");
        extentLogger.info("Verify that email is mbrackstone9@example.com");
        String actualEmail = contactInformationPage.email.getText();
        Assert.assertEquals(actualEmail, "mbrackstone9@example.com");
        extentLogger.pass("contactDetails test: PASS");


    }

}
