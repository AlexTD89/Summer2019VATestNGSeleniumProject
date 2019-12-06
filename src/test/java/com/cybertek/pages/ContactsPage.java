package com.cybertek.pages;

import com.cybertek.pages.BasePage;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage {
    public ContactsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//*[contains(text(), 'mbrackstone9@example.com’)]")
    public WebElement email;



}
