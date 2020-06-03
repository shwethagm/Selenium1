package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase_OlayRegistration_shwetha extends TestBase {
    private static final String jscode = "__doPostBack('phdesktopheader_0$phdesktopheadertop_2$anchrContinue','')";
    static WebDriver driver = getDriver();
    Excel excel = new Excel(System.getProperty("user.dir") + "//src//test//java//data.xlsx");
    int rowCount = excel.getRowCount("Sheet1");
    int rowCount1 = excel.getRowCount("Sheet2");

//Registe
    @Test
    public void registerUser() {

       // int rowCount = excel.getRowCount("Sheet2");


        for (int rowNum = 2; rowNum < rowCount1; rowNum++) {
            driver.findElement(By.xpath(objectRepo.getProperty("registerButton"))).click();
            driver.findElement(By.xpath(objectRepo.getProperty("emailIdText"))).sendKeys(excel.getCellData("Sheet2", "Email", rowNum));
            driver.findElement(By.xpath(objectRepo.getProperty("passwordText"))).sendKeys(excel.getCellData("Sheet2", "Password", rowNum));
            driver.findElement(By.xpath(objectRepo.getProperty("confirmPassword"))).sendKeys(excel.getCellData("Sheet2", "ConfirmPassword", rowNum));
            Select select = new Select((driver.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][day]"))));
            select.selectByIndex(14);
            select = new Select(driver.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][month]")));
            select.selectByIndex(9);
            select = new Select(driver.findElement(By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][year]")));
            select.selectByVisibleText("1985");
            WebElement element = driver.findElement(By.xpath(objectRepo.getProperty("registerAndCreateYourProfileButton")));
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            System.out.println("User Account created successfully");
            WebElement signout = driver.findElement(By.xpath(objectRepo.getProperty("signOutButton")));
            signout.click();
            JavascriptExecutor jse = ((JavascriptExecutor) driver);
            jse.executeScript("{" + jscode + "}");
            jse.executeScript("{" + jscode + "}");
            System.out.println("Sucessfully logged out!");
        }
    }

    public void signIn() {

        System.out.println(rowCount);
        for (int rowNum = 2; rowNum <=rowCount; rowNum++) {
            //entering email data from excel
            WebDriverWait wait=new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty("signInButton")))).click();
            WebElement username = driver.findElement(By.xpath(objectRepo.getProperty("signInEmailtext")));
            username.clear();
            username.sendKeys(excel.getCellData("Sheet1", "Email", rowNum));
            System.out.println(excel.getCellData("Sheet1", "Email", rowNum));
            //entering password data from excel
            WebElement password = driver.findElement(By.xpath(objectRepo.getProperty("signInPasswordText")));
            password.clear();
            password.sendKeys(excel.getCellData("Sheet1", "Password", rowNum));
            System.out.println(excel.getCellData("Sheet1", "Password", rowNum));

            driver.findElement(By.xpath(objectRepo.getProperty("SignINButtonAfterEnteringEmailAndPassword"))).click();
            System.out.println("User Successfully logged in!");

            WebElement signout = driver.findElement(By.xpath(objectRepo.getProperty("signOutButton")));
            signout.click();
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("{" + jscode + "}");
            js.executeScript("{" + jscode + "}");
            System.out.println("Sucessfully logged out!");
        }

    }

    public void signOut(){

    }
}