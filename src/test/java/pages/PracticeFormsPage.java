package pages;

import helpMethods.ElementsMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeFormsPage {
    public WebDriver driver;
    public ElementsMethods elementsMethod;
    private Object elementsMethods;

    public PracticeFormsPage(WebDriver driver) {
        this.driver = driver;
        elementsMethod = new ElementsMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceForm;

    @FindBy(id = "firstName")
    public WebElement firstNameElement;

    @FindBy(id = "lastName")
    public WebElement lastnameElement;

    @FindBy(id = "userEmail")
    public WebElement emailElement;

    @FindBy(id = "userNumber")
    public WebElement mobileElement;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirth;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthElement;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearElement;


    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day--0') and not(contains(@class,'outside-month'))]")
    List<WebElement> daysList;

    public void PracticeFormsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectDate(String year, String month, String dayValue) {
        yearElement.sendKeys(year);
        monthElement.sendKeys(month);
        for (WebElement day : daysList) {
            if (day.getText().equals(dayValue)) {
                day.click();
                break;
            }
        }
    }

    @FindBy(id = "currentAddress")
    public WebElement currentAddressElement;

    @FindBy(xpath = "//input[@name='gender']")
    List<WebElement> genderOptionsList;

    public void selectGender(String genderValue) {
        for (WebElement gender : genderOptionsList) {
            if (gender.getAttribute("value").equalsIgnoreCase(genderValue)) {
                try {
                    gender.click();
                } catch (Exception e) {
                    elementsMethods.javaScriptElement(gender);
                }
                break;
            }
        }
    }
}