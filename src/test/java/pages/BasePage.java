package pages;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import helpMethods.FrameMethods;
import helpMethods.TabMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public LoggerUtility loggerUtility;
    public ElementsMethods elementsMethods;
    public AlertsMethods alertsMethods;
    public FrameMethods frameMethods;
    public TabMethods tabMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        loggerUtility = new LoggerUtility();
        elementsMethods = new ElementsMethods(this.driver);
        alertsMethods = new AlertsMethods(this.driver);
        frameMethods = new FrameMethods(this.driver);
        tabMethods = new TabMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }
}
