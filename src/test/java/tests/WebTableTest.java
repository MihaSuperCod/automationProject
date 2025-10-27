package tests;

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

    @Test

    public void metodaTest () {

        //Deschidem un browser;

        driver= new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Accesam un URL;

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        js.executeScript("arguments[0].click();", elementsMenu);

        WebElement webTable = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        js.executeScript("arguments[0].click();", webTable);

        List<WebElement> continutTabel= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
//        System.out.println("Dimensiunea tabelului este "+continutTabel.size());

        Assert.assertEquals(continutTabel.size(),3,"Marimea tabelului nu este 3.");

        //Definim un element;

        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstNameElement= driver.findElement(By.id("firstName"));
        String firstName = "Mihaela";
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement= driver.findElement(By.id("lastName"));
        String lastName = "Moga";
        lastNameElement.sendKeys(lastName);

        WebElement emailElement= driver.findElement(By.id("userEmail"));
        String userEmail = "test@gmail.com";
        emailElement.sendKeys("test@gmail.com");

        WebElement ageElement= driver.findElement(By.id("age"));
        String age = "32";
        ageElement.sendKeys(age);

        WebElement salaryElement= driver.findElement(By.id("salary"));
        String salary= "1500";
        salaryElement.sendKeys(salary);

        WebElement departmentElement= driver.findElement(By.id("department"));
        String department= "IT";
        departmentElement.sendKeys(department);

        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();

        //Validam noua dimensiune a tabelululi;

        List<WebElement> continutTabelNou= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelNou.size(),4,"Marimea tabelului nu este 4.");

        //Validam valorile pe care le-am introdus;

        String continutRand=continutTabelNou.get(3).getText();
        Assert.assertTrue(continutRand.contains(firstName), "Randul nu contine first name.");
        Assert.assertTrue(continutRand.contains(lastName), "Randul nu contine first name.");
        Assert.assertTrue(continutRand.contains(userEmail), "Randul nu contine first name.");
        Assert.assertTrue(continutRand.contains(age), "Randul nu contine first name.");
        Assert.assertTrue(continutRand.contains(salary), "Randul nu contine first name.");
        Assert.assertTrue(continutRand.contains(department),"Randul nu contine first name.");

        //editFunctionality

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editFirstNameElement= driver.findElement(By.id("firstName"));
        editFirstNameElement.clear();
        String name2 ="Richard";
        editFirstNameElement.sendKeys(name2);

        WebElement editLastNameElement= driver.findElement(By.id("lastName"));
        editFirstNameElement.clear();
        String name3= "Lavi";
        editLastNameElement.sendKeys(name3);

        WebElement editEmail= driver.findElement(By.id("userEmail"));
        editEmail.clear();
        String email2= "Lavi@gmail.com";
        editLastNameElement.sendKeys(email2);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        editAgeElement.clear();
        String age2 = "25";
        editAgeElement.sendKeys((CharSequence) age2);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        WebElement deleteElement1 = deleteElement;
        deleteElement1.click();

        List<WebElement> continutTabelSters= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelSters.size(),3, "Noul tabel nu are 3 randuri");

        
       // driver.close();
    }
}


// Daca vrei sa idemtifici un element dupa text, se poate face asta doar cu XPath.
// CSS Seelector nu permite acest lucru;
// XPath are o structura specifica: tag, atribut, valoare;

//e.g //H5[text()='Elements']- XPath relativ;