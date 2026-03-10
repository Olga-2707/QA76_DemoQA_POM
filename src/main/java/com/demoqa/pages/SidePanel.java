package com.demoqa.pages;

import com.demoqa.core.BasePage;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.bookStore.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;
    public LoginPage selectLogin() {
        clickWithJS(login, 0, 500);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;
    public JSExecutor selectTextBox() {
        clickWithJS(textBox,0, 100);
        return new JSExecutor(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlert() {
        clickWithJS(alerts,0,200);
        return new AlertsPage(driver);
    }
}
