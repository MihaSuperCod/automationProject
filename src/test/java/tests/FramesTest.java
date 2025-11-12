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
import sharedData.ShareData;

public class FramesTest extends ShareData {


            ElementsMethods elementsMethods;
            FrameMethods frameMethods;

            @Test

            public void metodaTest() {

                elementsMethods = new ElementsMethods(driver);
                frameMethods = new FrameMethods(driver);

                HomePage homePage = new HomePage(driver);
                homePage.clickAlertFrameWindow();

                FramesPage frames = new FramesPage(driver);
                frames.clickFramesButton();

                frameMethods.switchToSpecificFrame("frame1");

                frameMethods.switchToParent();

                frameMethods.switchToSpecificFrame("frame2");
            }
        }
