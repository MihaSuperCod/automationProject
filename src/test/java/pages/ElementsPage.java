package pages;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    public WebDriver driver;
    public ElementsMethods elementsMethods;

    public ElementsPage(WebDriver driver){
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath ="//span[text()='Web Tables']")
    public WebElement webTableSubmenu;
    public void clickWebTable(){
        elementsMethods.javaScriptElement(webTableSubmenu);
    }
}
