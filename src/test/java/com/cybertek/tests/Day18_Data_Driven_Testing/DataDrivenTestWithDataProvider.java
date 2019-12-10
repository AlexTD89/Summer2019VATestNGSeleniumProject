package com.cybertek.tests.Day18_Data_Driven_Testing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestWithDataProvider {

    // this method will provide test data
    @DataProvider
    public Object[][] testData() {
        String[][] data = {
                {"Kung Fury", "10"},
                {"Titanic", "1"},
                {"Interstellar", "2"},
                {"I am legend", "10"},
        };
        return data;
    }

    @Test(dataProvider = "testData")
    public void test1(String name, String rating) {
        System.out.println("Movie "+name+" has a rating of "+rating); // check in console
    }
}
