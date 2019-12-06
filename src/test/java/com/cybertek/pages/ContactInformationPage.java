package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformationPage extends BasePage {

    @FindBy(className = "user-name")
    public WebElement fullName;

    @FindBy(css = "a.phone")
    public WebElement phone;


}
