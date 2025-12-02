package tests;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import org.testng.annotations.Test;
import pages.HomePage;
import sharedData.Hooks;

public class AlertTest extends Hooks {

    ElementsMethods elementsMethod;
    AlertsMethods alertsMethods;

    @Test

    public void metodaTest() {

        elementsMethod = new ElementsMethods(getDriver());
        alertsMethods = new AlertsMethods(getDriver());
        AlertModel testData = new AlertModel("src/test/resources/inputData/AlertResource.json");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertWindows alertsWindows = new AlertWindows(getDriver());
        alertsWindows.clickAlert();
        alertsWindows.dealAlertProcess(testData);
    }
}
