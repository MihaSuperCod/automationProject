package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.Message;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class WebTableTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;

    @Test

    public void metodaTest () {

        driver= new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethods= new ElementsMethods(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMethods.javaScriptElement(elementsMenu);

        WebElement webTable = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementsMethods.javaScriptElement(webTable);

        List<WebElement> continutTabel= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));

        Assert.assertEquals(continutTabel.size(),3,"Marimea tabelului nu este 3.");

        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstNameElement= driver.findElement(By.id("firstName"));
        String firstName= "Mihaela";
        elementsMethods.fillElement(firstNameElement, firstName);

        WebElement lastNameElement= driver.findElement(By.id("lastName"));
        String lastName= "Moga";
        elementsMethods.fillElement(lastNameElement, lastName);

        WebElement emailElement= driver.findElement(By.id("userEmail"));
        String email= "test@gmail.com";
        elementsMethods.fillElement(emailElement,email);

        WebElement ageElement= driver.findElement(By.id("age"));
        String age= "32";
        elementsMethods.fillElement(ageElement, age);

        WebElement salaryElement= driver.findElement(By.id("salary"));
        String salary= "1500";
        elementsMethods.fillElement(salaryElement, salary);

        WebElement departmentElement= driver.findElement(By.id("department"));
        String department= "IT";
        elementsMethods.fillElement(departmentElement, department);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementsMenu.submit();

        //Validam noua dimensiune a tabelululi;

        List<WebElement> continutTabelNou= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelNou.size(),4,"Marimea tabelului nu este 4.");

        //Validam valorile pe care le-am introdus;

        String continutRand=continutTabelNou.get(3).getText();
        Assert.assertTrue(continutRand.contains(firstName), "Randul nu contine first name.");
        Assert.assertTrue(continutRand.contains(lastName), "Randul nu contine first name.");
        Assert.assertTrue(continutRand.contains(email), "Randul nu contine first name.");
        Assert.assertTrue(continutRand.contains(age), "Randul nu contine first name.");
        Assert.assertTrue(continutRand.contains(salary), "Randul nu contine first name.");
        Assert.assertTrue(continutRand.contains(department),"Randul nu contine first name.");

//        WebElement editAgeElement = driver.findElement(By.id("age"));
//        editAgeElement.clear();
//        String age2 = "25";
//        editAgeElement.sendKeys((CharSequence) age2);
//
//        WebElement submitButton = driver.findElement(By.id("submit"));
//        submitButton.click();
//
//        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
//        WebElement deleteElement1 = deleteElement;
//        deleteElement1.click();
//
//        List<WebElement> continutTabelSters= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
//        Assert.assertEquals(continutTabelSters.size(),3, "Noul tabel nu are 3 randuri");
//
//       // driver.close();
    }
}


// Daca vrei sa idemtifici un element dupa text, se poate face asta doar cu XPath.
// CSS Seelector nu permite acest lucru;
// XPath are o structura specifica: tag, atribut, valoare;

//e.g //H5[text()='Elements']- XPath relativ;