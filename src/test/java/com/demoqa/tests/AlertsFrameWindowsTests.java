package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.FramesPage;
import com.demoqa.pages.alertsFrameWindows.WindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertsFrameWindowsTests extends TestBase {

    SidePanel sidePanel;
    AlertsPage alerts;
    FramesPage frame;

    @BeforeEach
    public void precondition(){
        new HomePage(driver).selectAlertsFrameWindows();
        sidePanel = new SidePanel(driver);
        alerts = new AlertsPage(driver);
        frame = new FramesPage(driver);
    }

    @Test
    public void waitAlertTest(){
        sidePanel.selectAlert();
        alerts.verifyAlertWithTimer();
    }

    @Test
    @DisplayName("Verify to -> 'Cancel is displayed'")
    public void alertWithSelectResultTest(){
        sidePanel.selectAlert();
        alerts.clickOnConfirmButton()
                .selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    @DisplayName("Verify to -> 'Text you entered is displayed'")
    public void sendMessageToAlertTest(){
        sidePanel.selectAlert();
        alerts.clickOnPromptButton()
                .sendMessageToAlert("Hello World!")
                .verifyMessage("Hello World!");
    }

    @Test
    public void switchToNewTabTest(){
        sidePanel.selectBrowserWindows();
        new WindowsPage(driver).clickOnNewTabButton()
                .switchToNewTab(1)
                .verifyNewTabTitle("This is a sample page");
    }

    @Test
    public void switchToNewIframeByIndex(){
        sidePanel.selectFrame();
        frame.returnListOfIframes()
                .switchToIframeByIndex(1)
                .verifyIframeByTitle("This is a sample page");
    }

    @Test
    public void switchToIframeByIdTest(){
        sidePanel.selectFrame();
        frame.switchToIframeById()
                .verifyIframeByTitle("This is a sample page")
                .switchToMainPage()// страница Frame, не самая главная
                .verifyMainPageTitle("Frames");
    }
    //ChildFrame -> нужно сначала в родит.frame, а затем уже во вложеный frame
//    @Test
//    public void nestedIframeTest(){
//        sidePanel.selectNestedFrames();
//        frame.handelNestedIframes();//недоделали!!
//    }
}
