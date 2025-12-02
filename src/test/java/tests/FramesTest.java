package tests;

import helpMethods.ElementsMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.HomePage;
import sharedData.Hooks;
import sharedData.ShareData;

import static java.sql.DriverManager.getDriver;

public class FramesTest extends Hooks {


            ElementsMethods elementsMethods;
            FrameMethods frameMethods;

            @Test

            public class FramesTest extends Hooks {
                ElementsMethods elementsMethod;
                FrameMethods frameMethods;

                @Test

                public void metodaTest() {
                    //Deschidem un browser

                    elementsMethod = new ElementsMethods(getDriver());
                    frameMethods = new FrameMethods(getDriver());

                    HomePage homePage = new HomePage(getDriver());
                    homePage.clickAlertFrameWindow();

                    FramesPage frames = new FramesPage(getDriver());
                    frames.clickFramesButton();
                    frames.switchFrames("frame1", "frame2");
            }
        }}
