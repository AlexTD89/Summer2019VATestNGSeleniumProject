package com.cybertek.tests.Day09_Tabs_Frames_Alerts_PopUps;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Local_VS_ClassVariables {

    String str;
    @BeforeMethod
    public void setup(){
        //this is different variable (local one) from above str
       String str = "ok";

        //this is str from class variable
         this.str="ok";
    }

    @Test
    public void test(){
        System.out.println(str.equals("ok"));
    }
}
