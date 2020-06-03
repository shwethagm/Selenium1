package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase4_shwetha  extends TestBase{
    static WebDriver driver = getDriver();

    public void datePick(){
        WebElement datePicker= driver.findElement(By.xpath(objectRepo.getProperty("datePickerButton")));
        datePicker.sendKeys("10/30/1988");
        WebElement dateContent= driver.findElement(By.xpath(objectRepo.getProperty("datePickerContent")));
        dateContent.click();
        System.out.println("Date of Birth is Entered");
    }
}
