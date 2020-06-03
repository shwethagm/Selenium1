package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_MakeMyTrip_shwetha  extends TestBase{
    static WebDriver driver = getDriver();

    public void bookFlight(){

        //getClose.click();
        //driver.findElement(By.xpath(config.getProperty("flightOption"))).click();
        //driver.findElement(By.xpath(config.getProperty("oneWayTrip"))).click();
        WebElement cityFrom= driver.findElement(By.xpath(objectRepo.getProperty("cityFrom")));
      //  driver.findElement(By.xpath(objectRepo.getProperty("cityFrom"))).sendKeys("Bengaluru");


       cityFrom.click();
        driver.findElement(By.xpath(objectRepo.getProperty("textCityFrom"))).sendKeys("Bengaluru");
        driver.findElement(By.xpath(objectRepo.getProperty("departureCityText"))).click();
        driver.findElement(By.xpath(objectRepo.getProperty("textCityTo"))).sendKeys("Mumbai");



        driver.findElement(By.xpath(objectRepo.getProperty("departureDate"))).click();
        driver.findElement(By.xpath(objectRepo.getProperty("selectDate"))).click();


        driver.findElement(By.xpath(config.getProperty("searchFlightsButton"))).click();
        driver.findElement(By.xpath(config.getProperty("price"))).click();
        driver.findElement(By.xpath(config.getProperty("continueButton"))).click();









    }
}
