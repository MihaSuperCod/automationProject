package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.ShareData;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeForms extends ShareData {

    ElementsMethods elementsMethods;

    @Test

    public void metodaTest() {
        elementsMethods = new ElementsMethods(getDriver());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement formsMenu = getDriver().findElement(By.xpath("//h5[text()='Forms']"));
        elementsMethods.javaScriptElement(formsMenu);

        WebElement practiceForm = getDriver().findElement(By.xpath("//span[text()='Practice Form']"));
        elementsMethods.javaScriptElement(practiceForm);

        WebElement firstNameElement = getDriver().findElement(By.id("firstName"));
        elementsMethods.fillElement(firstNameElement, "Johny");

        WebElement lastNameElement = getDriver().findElement(By.id("lastName"));
        elementsMethods.fillElement(lastNameElement, "Cash");

        WebElement emailElement = getDriver().findElement(By.id("userEmail"));
        elementsMethods.fillElement(emailElement, "test@gmail.com");

        WebElement mobileElement = getDriver().findElement(By.id("userNumber"));
        elementsMethods.fillElement(mobileElement, "0728335508");

        WebElement dateOfBirth = getDriver().findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();

        WebElement monthElement = getDriver().findElement(By.className("react-datepicker__month-select"));
        elementsMethods.dropDownElement(monthElement, "January");

        WebElement yearElement = getDriver().findElement(By.className("react-datepicker__year-select"));
        elementsMethods.dropDownElement(yearElement, "2030");

        String dayValue = "15";
        List<WebElement> daysList = getDriver().findElements(By.xpath("//div[contains(@class,'react-datepicker__day--0') and not(contains(@class,'outside-month'))]"));
        for (int index = 0; index < daysList.size(); index++){ ;
            if (daysList.get(index).getText().equals(dayValue)){ ;
                elementsMethods.clickElement(daysList.get(index));
                break;
            }
        }

        WebElement currentAddressElement = getDriver().findElement(By.id("currentAddress"));
        String currentAddress = "Brasov";
        currentAddressElement.sendKeys(currentAddress);

        List<WebElement> genderOptionsList = getDriver().findElements(By.xpath("//input[@name='gender']"));
        String genderValue = "Male";

        switch (genderValue) {
            case "Male":
                js.executeScript("arguments[0].click();", genderOptionsList.get(0));
                break;
            case "Female":
                js.executeScript("arguments[0].click();", genderOptionsList.get(1));
                break;
            case "Other":
                js.executeScript("arguments[0].click();", genderOptionsList.get(2));
                break;
        }

        WebElement subjectElementField = getDriver().findElement(By.id("subjectsInput"));
//        String subjectValue = "Accounting";
//        subjectElement.sendKeys(subjectValue);
//        subjectElement.sendKeys(Keys.ENTER);

        List<String> subjectElements = Arrays.asList("Accounting", "Maths", "English");
        for (int index = 0; index < subjectElements.size(); index++) {
            subjectElementField.sendKeys(subjectElements.get(index));
            subjectElementField.sendKeys(Keys.ENTER);
        }

        List<String> hobbiesElements = Arrays.asList("Sports", "Reading", "Music");
        List<WebElement> hobbiesCheckList = getDriver().findElements(By.xpath("//input[@type='checkbox']"));
        for (int index = 0; index < hobbiesElements.size(); index++) {
            js.executeScript("arguments[0].click();", hobbiesCheckList.get(index));
        }

        WebElement photoElementField = getDriver().findElement(By.id("uploadPicture"));
        File resourcesDirectory = new File("src/test/resources/IMG_20200222_074845_549.jpg");
        photoElementField.sendKeys(resourcesDirectory.getAbsolutePath());

        WebElement stateElement = getDriver().findElement(By.xpath("//div[text()='Select State']"));
        js.executeScript("arguments[0].click();", stateElement);
        WebElement stateInputElement = getDriver().findElement(By.id("react-select-3-input"));
        String stateValue ="NCR";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityElement = getDriver().findElement(By.xpath("//div[text()='Select City']"));
        js.executeScript("arguments[0].click();", cityElement);
        WebElement cityInputElement = getDriver().findElement(By.id("react-select-4-input"));
        String cityValue ="Delhi";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitButton = getDriver().findElement(By.id("submit"));
        submitButton.click();

        WebElement thankYouElement= getDriver().findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");

        List<WebElement> labelList= getDriver().findElements(By.xpath("//Table[@class='table table-dark table-striped table-bordered table-hover']//td[1]"));
        Assert.assertEquals(labelList.get(0).getText(), "Student Name");
        Assert.assertEquals(labelList.get(1).getText(), "Student Email");
        Assert.assertEquals(labelList.get(2).getText(), "Gender");
        Assert.assertEquals(labelList.get(3).getText(), "Mobile");
        Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
        Assert.assertEquals(labelList.get(5).getText(), "Subjects");
        Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
        Assert.assertEquals(labelList.get(7).getText(), "Picture");
        Assert.assertEquals(labelList.get(8).getText(), "Address");
        Assert.assertEquals(labelList.get(9).getText(), "State and City");

        List<WebElement> valuelList= getDriver().findElements(By.xpath("//Table[@class='table table-dark table-striped table-bordered table-hover']//td[2]"));
        Assert.assertEquals(valuelList.get(0).getText(), "Johny Cash");
        Assert.assertEquals(valuelList.get(1).getText(), "test@gmail.com");
        Assert.assertEquals(valuelList.get(2).getText(), "Male");
        Assert.assertEquals(valuelList.get(3).getText(), "0728335508");
        Assert.assertEquals(valuelList.get(4).getText(), "15 January,2030");
        Assert.assertEquals(valuelList.get(5).getText(), "Accounting, Maths, English");
        Assert.assertEquals(valuelList.get(6).getText(), "Sports, Reading, Music");
        Assert.assertEquals(valuelList.get(7).getText(), "IMG_20200222_074845_549.jpg");
        Assert.assertEquals(valuelList.get(8).getText(), "Brasov");
        Assert.assertEquals(valuelList.get(9).getText(), "NCR Delhi");

    }
}


