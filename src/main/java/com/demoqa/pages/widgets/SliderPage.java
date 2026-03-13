package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".range-slider")
    WebElement rangeSlider;
    public SliderPage moveSlider() {
        scrollWithJS(0, 50);
        actions.dragAndDropBy(rangeSlider,310, 0).perform(); //Что делает?
        return this;
    }
}
