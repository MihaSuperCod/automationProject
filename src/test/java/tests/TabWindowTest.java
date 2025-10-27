package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TabWindowTest {
    public WebDriver driver;

    ElementsMethods elementsMethods;

    @Test

    public void metodaTest() {

        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);

        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethods.javaScriptElement(alertsMenu);

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethods.javaScriptElement(tabButton);

        WebElement tabButtonElement = driver.findElement(By.id("tabButton"));
        tabButtonElement.click();

        System.out.println("URL-ul paginii este "+driver.getCurrentUrl());
        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));

        System.out.println("URL-ul paginii este "+driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(tabsList.get(0));

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        newWindowElement.click();
        List<String> newWindowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newWindowList.get(1));

        driver.quit();

    }
}
