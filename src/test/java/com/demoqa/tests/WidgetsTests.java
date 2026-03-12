package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.SelectPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WidgetsTests extends TestBase {

    SidePanel sidePanel;
    SelectPage selectPage;

    @BeforeEach
    public void precondition(){
        new HomePage(driver).selectWidgets();
        sidePanel = new SidePanel(driver);
        selectPage = new SelectPage(driver);
    }

    @Test
    public void oldStyleSelectMenuTest(){
        sidePanel.selectSelect();
        selectPage.oldStyleSelect("Aqua")
                .verifyColor();
    }

    @Test
    public void multiSelectTest(){
        sidePanel.selectSelect();
        selectPage.multiSelect(new String[]{"Green","Red"})
        .verifyMultiSelect(new String[]{"Green","Red"});
    }

}
