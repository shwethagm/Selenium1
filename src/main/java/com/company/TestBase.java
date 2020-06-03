package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static String browser;
    public static Properties config = new Properties();
    public static Properties objectRepo = new Properties();
    public static FileInputStream fis;
    public static WebDriver driver;
    static SecureRandom rnd = new SecureRandom();
    private int url;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        TestBase.driver = driver;
    }
    //public static WebDriver driver;

    public static String getRandomEmail(int len) {
       // RandomStringUtils.randomAlphanumeric(20).toUpperCase();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString()+("@gmail.com");

    }
@BeforeTest
    public void getUrl() {
        if (driver == null) {

            try {
                System.out.println(System.getProperty("user.dir"));
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
                config.load(fis);
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/or.properties");
                objectRepo.load(fis);
            } catch (
                    IOException e) {
                e.printStackTrace();
            }

            if (config.getProperty("browser").equals("chrome")) {

                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
                ChromeOptions opt = new ChromeOptions();
                opt.setBinary("/usr/bin/chromium");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                switch(url){
//                    case getUrl:
//
//                }
                // driver.get(config.getProperty("url"));
                //   driver.get(config.getProperty("contactFormUrl"));
                //driver.get(config.getProperty("droppableUrl"));
                // driver.get(config.getProperty("dateUrl"));
                //driver.get(config.getProperty("selectUrl"));

                // driver.get(config.getProperty("makeMyTripUrl"));
                driver.get(config.getProperty("olayUrl"));

            } else if (config.getProperty(browser).equals("firefox")) {

                System.setProperty("webdriver.gecko.driver", "//driver//geckodriver");
//            ChromeOptions opt = new ChromeOptions();
//            opt.setBinary("/usr/bin/chromium");
                // driver = new firefoxDriver();
                // driver.get(config.getProperty("url"));

            }

        }
    }
@AfterSuite
    public void closeBrowser() {

        driver.quit();
    }
}