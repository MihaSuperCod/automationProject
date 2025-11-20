package tests;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import helpMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsWindows;
import pages.HomePage;
import sharedData.ShareData;

import java.time.Duration;

public class AlertTest extends ShareData {

    ElementsMethods elementsMethod;
    AlertsMethods alertsMethods;

    @Test

    public void metodaTest() {

        elementsMethod = new ElementsMethods(driver);
        alertsMethods = new AlertsMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertsWindows alertsWindows = new AlertsWindows(driver);
        alertsWindows.clickAlert();
        alertsWindows.dealAlertProcess();
    }
}

