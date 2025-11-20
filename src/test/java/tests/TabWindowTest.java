package tests;

import helpMethods.ElementsMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.HomePage;
import sharedData.ShareData;

import java.util.ArrayList;
import java.util.List;

public class TabWindowTest extends ShareData {

    ElementsMethods elementsMethods;
    TabMethods tabMethods;

    @Test

    public void metodaTest() {

        elementsMethods = new ElementsMethods(getDriver());
        tabMethods = new TabMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        WebElement tabButton = getDriver().findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethods.javaScriptElement(tabButton);

        WebElement newTabButton = getDriver().findElement(By.id("tabButton"));
        elementsMethods.clickElement(newTabButton);

        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);

        WebElement newWindowElement = getDriver().findElement(By.id("windowButton"));
        elementsMethods.javaScriptElement(newWindowElement);
        tabMethods.switchSpecificTab(1);
    }
}
