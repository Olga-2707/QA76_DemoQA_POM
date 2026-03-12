package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "iframe") //собираем все эл-ты со страницы с тэгом iframe
    List<WebElement> iframes; //упаковываем найденные эл-ты в List

    public FramesPage returnListOfIframes() {
        //получаем количество найденных эл-ов iframe через size()
        System.out.println("The total number of iframes is " + iframes.size());
        //by executing JS
        int numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("The total number of iframes is " + numberOfIframes);
        return this;
    }

    public FramesPage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;
    public FramesPage verifyIframeByTitle(String title) {
        Assertions.assertTrue(isContainsText(title,sampleHeading));
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;
    public FramesPage switchToIframeById() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public FramesPage switchToMainPage() {
        driver.switchTo().defaultContent();//defaultContent() -> обратно в основной DOM страницы
        return this;
    }

    @FindBy(css = ".text-center")
    WebElement textCenter;
    public FramesPage verifyMainPageTitle(String text) {
        Assertions.assertTrue(isContainsText(text,textCenter));
        return this;
    }


//    public FramesPage handelNestedIframes() {
//        return this;
//    }
}
