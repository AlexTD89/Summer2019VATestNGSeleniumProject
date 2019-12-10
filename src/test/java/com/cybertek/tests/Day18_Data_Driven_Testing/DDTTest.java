package com.cybertek.tests.Day18_Data_Driven_Testing;

import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTTest extends TestBase {

    @DataProvider
    public Object [][] userList(){
        // read from the excel in 2d array format
        ExcelUtil qa3Short = new ExcelUtil("src/test/resources/Vytrack testusers.xlsx", "QA3-short");
        String [][] dataArray = qa3Short.getDataArray();

        //return the 2d array
        return dataArray;
    }

    /**
        to find out which parameters to pass to the test method we need to look into excel file and see what are the names of the columns (exact same name, and same order)
     */
    @Test(dataProvider = "userList")
    public void test1(String execute, String username, String password, String firstname, String lastname){
        extentLogger = report.createTest("Testing"+firstname+lastname);

        //login using excel data
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        // get the actual
        String actualName = new DashBoardPage().getUserName();
        // expected comes from the excel data
        String expected = firstname+" "+lastname;

        Assert.assertEquals(actualName, expected);

        // we are ignoring the variable execute
    }
}
