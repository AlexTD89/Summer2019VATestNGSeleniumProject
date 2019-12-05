package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this); // this line has to be in every page object model
    }

//    @FindBys({  // how to provide multiple locators to find one element
//            @FindBy(id="prependedInput" ),
//            @FindBy(name = "prependedInput")})
//    public WebElement userName1;


    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(id ="_submit")
    public WebElement submit;
    // same as : driver.findElement(By.name("_submit"));

    public void login(String username, String passwordStr){
        userName.sendKeys(username);
        password.sendKeys(passwordStr);
        this.submit.click();
    }


}
