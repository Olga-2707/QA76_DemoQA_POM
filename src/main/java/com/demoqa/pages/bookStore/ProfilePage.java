package com.demoqa.pages.bookStore;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement usernameValue;
    public ProfilePage verifyUserName(String name) {
        Assertions.assertTrue(isContainsText(name, usernameValue));
        return this;
    }
}
