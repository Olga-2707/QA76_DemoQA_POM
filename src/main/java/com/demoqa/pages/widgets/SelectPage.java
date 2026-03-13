package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

import static java.awt.SystemColor.text;

public class SelectPage extends BasePage {
    public SelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;
    public SelectPage oldStyleSelect(String color) {
        Select select = new Select(oldSelectMenu);//Class Select in Selenium
        select.selectByVisibleText(color);//для выбора нужного цвета из списка
        //new Select(oldSelectMenu).selectByVisibleText(color); сокращенная запись
        return this;
    }

    public SelectPage verifyColor() {
        String firstSelectedOption = new Select(oldSelectMenu).getFirstSelectedOption().getText();
        Assertions.assertTrue(shouldHaveText(oldSelectMenu,firstSelectedOption,5));
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement selectInput;
    @FindBy(css = "html") //чтобы нажать по пустому месту
    WebElement space;

    public SelectPage multiSelect(String[] colors) {
        for (String text:colors){
            selectInput.sendKeys(text);
            selectInput.sendKeys(Keys.ENTER);
        }
        click(space);
        return this;
    }

    public SelectPage verifyMultiSelect(String[] colors) {
        SoftAssertions softly = new SoftAssertions();
        for (String text:colors){
            WebElement element = driver.findElement(By.xpath("//*[.='" + text + "']"));
            softly.assertThat(isContainsText(text, element)).isTrue();
        }
        softly.assertAll();
        return this;
    }

    public SelectPage verifySelectCarByValue(String car, String color) {
        WebElement selectedCar = driver.findElement(By.cssSelector("[value='" + car + "']"));
        click(selectedCar);
        //System.out.println(selectedCar.getCssValue("background-color"));
        Assertions.assertTrue(selectedCar.getCssValue("background-color").contains(color));
        return this;
    }
    public SelectPage verifySelectCarByFormat(String car, String color){
        WebElement selectedCar = driver.findElement(By.cssSelector("[value='" + car + "']"));
        click(selectedCar);
        //new Select(selectedCar).selectByVisibleText(car);//ничего не делающий код
        String rgbFormat = selectedCar.getCssValue("background-color");
        //Color Selenium выбираем
        String format = Color.fromString(selectedCar.getCssValue("background-color")).asHex();
        //System.out.println(format);
        Assertions.assertTrue(format.contains(color));
        return this;
    }
}
