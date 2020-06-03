package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class TestCase3_shwetha extends TestBase {
    static WebDriver driver = getDriver();

    public void  getDrag(){
        Actions act=new Actions(driver);
        WebElement drag=driver.findElement(By.xpath(objectRepo.getProperty("dragFrom")));
        WebElement drop=driver.findElement(By.xpath(objectRepo.getProperty("dragTo")));

        act.dragAndDrop(drag,drop).perform();
    }

}