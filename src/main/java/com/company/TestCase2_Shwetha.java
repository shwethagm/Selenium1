package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TestCase2_Shwetha extends TestBase {
    static  WebDriver driver=  getDriver();


    public static void fillContactForm(){

      WebElement  firstName=  driver.findElement(By.xpath(objectRepo.getProperty("textFirstName")));
      firstName.sendKeys("Shwetha");
        WebElement  lastName=  driver.findElement(By.xpath((objectRepo.getProperty("textLastName"))));
        lastName.sendKeys("Puttaraju");
         WebElement elem = driver.findElement(By.xpath(objectRepo.getProperty("textCountry")));
         elem.sendKeys("India");
        WebElement  subject=  driver.findElement(By.xpath(objectRepo.getProperty("textSubject")));
        subject.sendKeys("Search");
        driver.findElement(By.partialLinkText("Google")).click();
        driver.findElement(By.partialLinkText("Google Link is there")).click();
        driver.findElement(By.xpath(objectRepo.getProperty("submitButton"))).click();
        System.out.println("contact form is filled!");
        driver.navigate().back();
    }
    public static void clickText(){
        driver.findElement(By.partialLinkText("Google")).click();
        driver.navigate().back();
        driver.findElement(By.partialLinkText("Google Link is here")).click();
        System.out.println("clicked on both the Links!");

    }

        }

