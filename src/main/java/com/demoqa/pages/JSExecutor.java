package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;

public class JSExecutor extends BasePage {
    public JSExecutor(WebDriver driver) {
        super(driver);
    }

    public JSExecutor enterPersonalData(String name, String email) {
        js.executeScript("document.getElementById('userName').value='"+ name +"';");
        js.executeScript("document.getElementById('userEmail').value='"+ email +"';");
        return this;
    }
}
