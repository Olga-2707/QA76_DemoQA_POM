package com.demoqa.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public static JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);//для инициализации страницы
        js = (JavascriptExecutor) driver;
    }

    public void scrollWithJS(int x, int y){
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

    public void clickWithJS(WebElement element, int x, int y){
        scrollWithJS(x,y);
        click(element);
    }

    public void typeWithJS(WebElement element, String text, int x, int y){
        scrollWithJS(x,y);
        type(element,text);
    }

    public void click(WebElement element){
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);//click on field
            element.clear();//clean field
            element.sendKeys(text);//enter text
        }
    }

        public WebDriverWait getWait(int seconds) {
            return new WebDriverWait(driver, Duration.ofSeconds(seconds));
        }

        public boolean isAlertPresent(int seconds) {
            Alert alert = getWait(seconds)
                    .until(ExpectedConditions.alertIsPresent());
            if (alert == null) {
                return false;
            } else {
                driver.switchTo().alert().accept(); //switchTo чтобы перейти на алерт и нажать ок
                return true;
            }
        }

    }


