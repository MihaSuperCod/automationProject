package tests;

import helpMethods.ElementsMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;

public class FramesTest {

            public WebDriver driver;
            ElementsMethods elementsMethods;
            FrameMethods frameMethods;

            @Test

            public void metodaTest() {

                driver = new ChromeDriver();
                elementsMethods = new ElementsMethods(driver);
                frameMethods = new FrameMethods(driver);

                driver.get("https://demoqa.com/");
                driver.manage().window().maximize();

                HomePage homePage = new HomePage(driver);
                homePage.clickAlertFrameWindow();

                WebElement tabButton = driver.findElement(By.xpath("//span[text()='Frames']"));
                elementsMethods.javaScriptElement(tabButton);
                FramesPage frames = new FramesPage(driver);
                frames.clic

                frameMethods.switchToSpecificFrame("frame1");

                frameMethods.switchToParent();

                frameMethods.switchToSpecificFrame("frame2");
            }
        }