package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

    @Test

    public void metodaTest() {

        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //wait implicit (vegheaza asupra codului
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        js.executeScript("arguments[0].click();", alertsMenu);

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Alerts']"));
        js.executeScript("arguments[0].click();", tabButton);

        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        firstAlertElement.click();
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        secondAlert.click();

        //wait explicit

        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());
        Alert secondAlertElement = driver.switchTo().alert();
        System.out.println(secondAlertElement.getText());
        secondAlertElement.accept();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        thirdAlertElement.click();
        Alert thirdAlert = driver.switchTo().alert();
        thirdAlert.dismiss();

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        fourthAlertElement.click();
        Alert fourthAlert = driver.switchTo().alert();
        fourthAlert.sendKeys("text123");
        fourthAlert.accept();

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String expectedText = "You selected Cancel";
        Assert.assertEquals(textThirdAlert.getText(),expectedText);

        }

    public void chooseBetweenOKorCancel(boolean OK) {
        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        thirdAlertElement.click();
        Alert thirdAlert = driver.switchTo().alert();

        if (OK) {
            thirdAlert.dismiss();
        } else {
            thirdAlert.accept();
        }
    }
}




//       Tema: folosim if pentru cele doua cazuri de accept si cancel;