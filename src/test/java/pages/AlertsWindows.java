package pages;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindows {

    public WebDriver driver;
    public ElementsMethods elementsMethod;
    public AlertsMethods alertsMethods;

    public AlertsWindows(WebDriver driver) {
        this.driver = driver;
        elementsMethod = new ElementsMethods(this.driver);
        alertsMethods = new AlertsMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alert;

    @FindBy(id = "alertButton")
    public WebElement firstAlertElement;

    @FindBy(id = "timerAlertButton")
    public WebElement secondAlert;

    @FindBy(id = "confirmButton")
    public WebElement thirdAlertElement;

    @FindBy(id = "confirmResult")
    public WebElement textThirdAlert;

    @FindBy(id = "promtButton")
    public WebElement fourthAlertElement;

    public void clickAlert(){
        elementsMethod.javaScriptElement(alert);
    }

    public void dealAlertProcess(){
        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethod.javaScriptElement(firstAlertElement);

        alertsMethods.acceptAlert();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        elementsMethod.javaScriptElement(secondAlert);

        alertsMethods.acceptAlert();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethod.javaScriptElement(thirdAlertElement);

        boolean chooseAccept = true;  // pune false daca vrei Cancel
        alertsMethods.acceptAlert(chooseAccept);

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();
        alertsMethods.verifyConfirmAlert(actualText, true);

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethod.javaScriptElement(fourthAlertElement);
        alertsMethods.fillAlert("Buna");
    }

}