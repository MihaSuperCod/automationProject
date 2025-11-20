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

        elementsMethod = new ElementsMethods(getDriver());
        alertsMethods = new AlertsMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertsWindows alertsWindows = new AlertsWindows(getDriver());
        alertsWindows.clickAlert();
        alertsWindows.dealAlertProcess();
    }
}

