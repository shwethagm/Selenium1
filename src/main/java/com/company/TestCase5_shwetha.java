package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestCase5_shwetha extends TestBase {
    static WebDriver driver = getDriver();
    List<WebElement> li=(driver.findElements(By.xpath(objectRepo.getProperty("selectSpeed"))));


    public void selectMenu(){

        for(int i=1;i<=li.size();i++){
            System.out.println(li.get(i));
        }
//        WebElement element =(driver.findElement(By.xpath("//span[@id='speed-button']")));
//
//            JavascriptExecutor executor = (JavascriptExecutor)driver;
//executor.executeScript("arguments[0].click();", element);
//        System.out.println(element.getText());
        }
        //select.selectByValue("Slow");


}


