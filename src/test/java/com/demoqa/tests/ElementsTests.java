package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.pages.elements.TextBoxPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementsTests extends TestBase {
    SidePanel sidePanel;
    ButtonsPage buttonsPage;
    TextBoxPage textBoxPage;

    @BeforeEach
    public void precondition(){
        sidePanel = new SidePanel(driver);
        buttonsPage = new ButtonsPage(driver);
        new HomePage(driver).selectElements();
        textBoxPage = new TextBoxPage(driver);
    }

    @Test
    public void doubleClickTest(){
        sidePanel.getButtons();
        buttonsPage.doubleClick()
                .verifyDoubleClick("double click");
    }

    @Test
    public void rightClickTest(){
        sidePanel.getButtons();
        buttonsPage.rightClick()
                .verifyRightClick("right click");
    }

    @Test
    public void copyPastTest(){
        sidePanel.selectTextBox();
        textBoxPage.copyPast("Friedrichstr 12, Berlin")
                .clickOnSubmitButton()
                .verifyAddress();
    }

}
