package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.Hooks;
import sharedData.ShareData;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeForms extends Hooks {

    ElementsMethods elementsMethod;

    @Test
    public void metodaTest() {

        //Deschidem un browser

        elementsMethod = new ElementsMethods(getDriver());

        WebElement formsMeniu = getDriver().findElement(By.xpath("//h5[text()='Forms']"));
        elementsMethod.javaScriptElement(formsMeniu);

        WebElement practiceForm = getDriver().findElement(By.xpath("//span[text()='Practice Form']"));
        elementsMethod.clickElement(practiceForm);

        WebElement firstNameElement = getDriver().findElement(By.id("firstName"));
        elementsMethod.fillElement(firstNameElement, "Johny");

        WebElement lastNameElement = getDriver().findElement(By.id("lastName"));
        elementsMethod.fillElement(lastNameElement, "Cash");

        WebElement userEmailElement = getDriver().findElement(By.id("userEmail"));
        elementsMethod.fillElement(userEmailElement,"mail@mail.com");

        WebElement mobileElement = getDriver().findElement(By.id("userNumber"));
        elementsMethod.fillElement(mobileElement, "0746430354");

//        Date of birth interaction

        WebElement dateOfBirth = getDriver().findElement(By.id("dateOfBirthInput"));
        elementsMethod.clickElement(dateOfBirth);

        WebElement monthElement = getDriver().findElement(By.className("react-datepicker__month-select"));
        elementsMethod.dropDownElement(monthElement, "January");

        WebElement yearElement = getDriver().findElement(By.className("react-datepicker__year-select"));
        elementsMethod.dropDownElement(yearElement, "2030");

        String dayValue = "15";
        List<WebElement> daysList = getDriver().findElements(By.xpath("//div[contains(@class,'react-datepicker__day--0') and not(contains(@class,'outside-month'))]"));
        for (int index=0; index<daysList.size();index++) {
            if (daysList.get(index).getText().equals(dayValue)) {
                elementsMethod.clickElement(daysList.get(index));
                break;
            }
        }
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


