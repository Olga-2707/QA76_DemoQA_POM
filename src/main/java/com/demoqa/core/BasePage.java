package com.demoqa.core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    public static JavascriptExecutor js;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);//для инициализации страницы
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
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

    public boolean isContainsText(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return getWait(time)
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    //Этот метод полезен, когда в ходе тестирования открывается несколько вкладок
    // или окон браузера, и вам нужно переключаться между ними, чтобы выполнять различные действия на каждой странице
    public void switchToNewTabWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());//Получает список всех открытых вкладок (окон) браузера, используя метод driver.getWindowHandles()
        driver.switchTo().window(tabs.get(index)); //Переключает фокус драйвера Selenium на вкладку (окно) с индексом, переданным в качестве аргумента index
    }

    public boolean isElementVisible(WebElement element){
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.getMessage();
            return false;
        }
    }

    public void waitOfElementVisibility(WebElement element, int time){
        getWait(time).until(ExpectedConditions.visibilityOf(element));
    }
}


