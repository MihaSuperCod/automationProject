package tests;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsWindows;
import pages.HomePage;

import java.sql.Driver;
import java.time.Duration;

public class AlertTest {
    public WebDriver driver;
    ElementsMethods elementsMethods;
    AlertsMethods alertsMethods;

    @Test

    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethods = new ElementsMethods(driver);
        alertsMethods = new AlertsMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertsWindows alertsWindows = new AlertsWindows(driver);
        alertsWindows.clickAlert();

        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethods.clickElement(firstAlertElement);
        alertsMethods.acceptAlert();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.clickElement(secondAlert);

        alertsMethods.acceptAlert();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethods.clickElement(thirdAlertElement);
        boolean chooseAccept = true;
        alertsMethods.acceptAlert(chooseAccept);

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();
        alertsMethods.verifyConfirmAlert(actualText, true);

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethods.clickElement(fourthAlertElement);
        alertsMethods.fillAlert("Buna ziua");
    }
}
