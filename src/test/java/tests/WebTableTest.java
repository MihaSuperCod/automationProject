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

        elementsMethod = new ElementsMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        WebTablesPage webTablesPage = new WebTablesPage(getDriver());
        webTablesPage.createProcess();
        webTablesPage.editProcess();
        webTablesPage.deleteProcess();

    }
}
