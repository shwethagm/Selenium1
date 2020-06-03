package com.company;

import com.company.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class TestCase1_shwetha extends TestBase {

  static  WebDriver driver=  getDriver();
  // int[] item=new []int //ol[@id='selectable']

    public static void printItemName(){
       List< WebElement> list=driver.findElements(By.xpath("//ol[@id='selectable']/li"));
        for(int i=1;i<=list.size();i++) {

            WebElement item = driver.findElement(By.xpath("//li[@class='ui-widget-content ui-selectee']["+i+"]"));
            item.click();
            System.out.println(item.getText());
        }
    }

}


