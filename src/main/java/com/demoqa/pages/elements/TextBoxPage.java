package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    public TextBoxPage copyPast(String address) {
        type(currentAddress, address);
        //select current address text
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //copy current address text
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press TAB to switch focus to  permanent address field
        actions.sendKeys(Keys.TAB).perform();
        //past current address text to permanent address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;
    public TextBoxPage clickOnSubmitButton() {
        click(submit);
        return this;
    }

    @FindBy(css = ".border #currentAddress")
    WebElement currentAddressResult;
    @FindBy(css = ".border #permanentAddress")
    WebElement permanentAddressResult;
    public TextBoxPage verifyAddress() {
        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assertions.assertEquals(current[1], permanent[1]);
        return this;
    }
}
