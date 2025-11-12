package tests;

import helpMethods.ElementsMethods;
import helpMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablesPage;
import sharedData.ShareData;

import java.util.List;

public class WebTableTest extends ShareData {

    ElementsMethods elementsMethod;

    @Test

    public void metodaTest() {

        elementsMethod = new ElementsMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.clickWebTable();

        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.createProcess();
        webTablesPage.editProcess();
        webTablesPage.deleteProcess();

    }
}
