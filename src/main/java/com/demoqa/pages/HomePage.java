package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/books']")
    WebElement bookStore;

    public SidePanel selectBookStore() {
        clickWithJS(bookStore, 0, 600);
    return new SidePanel(driver);
    }


    @FindBy(css="a[href='/elements']")
    WebElement elements;
    public SidePanel selectElements() {
        clickWithJS(elements,0, 200);
        return new SidePanel(driver);
    }

    @FindBy(css="a[href='/alertsWindows']")
    WebElement alertsFrameWindows;

    public SidePanel selectAlertsFrameWindows() {
        clickWithJS(alertsFrameWindows, 0,100);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[normalize-space()='Widgets']")
    WebElement widgets;
    public SidePanel selectWidgets() {
        clickWithJS(widgets,0,100);
        return new SidePanel(driver);
    }


}
