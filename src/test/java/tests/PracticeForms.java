package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.Element;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeForms {

    public WebDriver driver;
    ElementsMethods elementsMethods;

    @Test

    public void metodaTest() {

        driver = new ChromeDriver();
        elementsMethods = new ElementsMethods(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementsMethods.javaScriptElement(formsMenu);

        WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementsMethods.javaScriptElement(practiceForm);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        elementsMethods.fillElement(firstNameElement, "Johny");

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        elementsMethods.fillElement(lastNameElement, "Cash");

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        elementsMethods.fillElement(emailElement, "test@gmail.com");

        WebElement mobileElement = driver.findElement(By.id("userNumber"));
        elementsMethods.fillElement(mobileElement, "0728335508");

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        elementsMethods.dropDownElement(monthElement, "January");

        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));
        elementsMethods.dropDownElement(yearElement, "2030");

        String dayValue = "15";
        List<WebElement> daysList = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day--0') and not(contains(@class,'outside-month'))]"));
        for (int index = 0; index < daysList.size(); index++){ ;
        if (daysList.get(index).getText().equals(dayValue)){ ;
        elementsMethods.clickElement(daysList.get(index));
        break;
    }
}



//        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
//        String currentAddress = "Brasov";
//        currentAddressElement.sendKeys(currentAddress);
//
//        List<WebElement> genderOptionsList = driver.findElements(By.xpath("//input[@name='gender']"));
//        String genderValue = "Male";
//
//        switch (genderValue) {
//            case "Male":
//                js.executeScript("arguments[0].click();", genderOptionsList.get(0));
//                break;
//            case "Female":
//                js.executeScript("arguments[0].click();", genderOptionsList.get(1));
//                break;
//            case "Other":
//                js.executeScript("arguments[0].click();", genderOptionsList.get(2));
//                break;
//        }
//
//        WebElement subjectElementField = driver.findElement(By.id("subjectsInput"));
////        String subjectValue = "Accounting";
////        subjectElement.sendKeys(subjectValue);
////        subjectElement.sendKeys(Keys.ENTER);
//
//        List<String> subjectElements = Arrays.asList("Accounting", "Maths", "English");
//        for (int index = 0; index < subjectElements.size(); index++) {
//            subjectElementField.sendKeys(subjectElements.get(index));
//            subjectElementField.sendKeys(Keys.ENTER);
//        }
//
//        List<String> hobbiesElements = Arrays.asList("Sports", "Reading", "Music");
//        List<WebElement> hobbiesCheckList = driver.findElements(By.xpath("//input[@type='checkbox']"));
//        for (int index = 0; index < hobbiesElements.size(); index++) {
//            js.executeScript("arguments[0].click();", hobbiesCheckList.get(index));
//        }
//
//        WebElement photoElementField = driver.findElement(By.id("uploadPicture"));
//        File resourcesDirectory = new File("src/test/resources/IMG_20200222_074845_549.jpg");
//        photoElementField.sendKeys(resourcesDirectory.getAbsolutePath());
//
//        WebElement stateElement = driver.findElement(By.xpath("//div[text()='Select State']"));
//        js.executeScript("arguments[0].click();", stateElement);
//        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
//        String stateValue ="NCR";
//        stateInputElement.sendKeys(stateValue);
//        stateInputElement.sendKeys(Keys.ENTER);
//
//        WebElement cityElement = driver.findElement(By.xpath("//div[text()='Select City']"));
//        js.executeScript("arguments[0].click();", cityElement);
//        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
//        String cityValue ="Delhi";
//        cityInputElement.sendKeys(cityValue);
//        cityInputElement.sendKeys(Keys.ENTER);
//
//        WebElement submitButton = driver.findElement(By.id("submit"));
//        submitButton.click();
//
//        WebElement thankYouElement= driver.findElement(By.id("example-modal-sizes-title-lg"));
//        Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");
//
//        List<WebElement> labelList= driver.findElements(By.xpath("//Table[@class='table table-dark table-striped table-bordered table-hover']//td[1]"));
//        Assert.assertEquals(labelList.get(0).getText(), "Student Name");
//        Assert.assertEquals(labelList.get(1).getText(), "Student Email");
//        Assert.assertEquals(labelList.get(2).getText(), "Gender");
//        Assert.assertEquals(labelList.get(3).getText(), "Mobile");
//        Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
//        Assert.assertEquals(labelList.get(5).getText(), "Subjects");
//        Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
//        Assert.assertEquals(labelList.get(7).getText(), "Picture");
//        Assert.assertEquals(labelList.get(8).getText(), "Address");
//        Assert.assertEquals(labelList.get(9).getText(), "State and City");
//
//        List<WebElement> valuelList= driver.findElements(By.xpath("//Table[@class='table table-dark table-striped table-bordered table-hover']//td[2]"));
//        Assert.assertEquals(valuelList.get(0).getText(), firstName+" "+lastName);
//        Assert.assertEquals(valuelList.get(1).getText(), userEmail);
//        Assert.assertEquals(valuelList.get(2).getText(), "Male");
//        Assert.assertEquals(valuelList.get(3).getText(), userNumber);

    }
}


