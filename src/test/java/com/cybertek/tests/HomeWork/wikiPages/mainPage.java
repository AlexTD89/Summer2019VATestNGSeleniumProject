package com.cybertek.tests.HomeWork.wikiPages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class mainPage {
    public mainPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "searchInput")
    public WebElement searchBar;

    @FindBy(css = "[type='submit']")
    public WebElement searchButton;

    @FindBy(css = "[class='suggestion-link']")
    public WebElement suggestionLinks;


    /**  Returns a List<String> of all search results (in a text format) */
    public List<String> getAllSuggestionsText(){
        List<WebElement> allSuggestions = Driver.get().findElements(By.cssSelector("[class='suggestion-link']"));
        List<String> allSuggestionsText = new ArrayList<>();
        for (WebElement suggestion : allSuggestions) {
            allSuggestionsText.add(suggestion.getText());
        }
        return allSuggestionsText;
    }

}
