package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static void main(String[] args) {
        TestBase base=new TestBase();
        base.getUrl();
      //  System.out.println(TestBase.getRandomEmail(8));
        TestCase1_shwetha tc1=new TestCase1_shwetha();
        TestCase2_Shwetha tc2=new TestCase2_Shwetha();
        TestCase3_shwetha tc3=new TestCase3_shwetha();
        TestCase4_shwetha tc4=new TestCase4_shwetha();
      //  TestCase5_shwetha tc5=new TestCase5_shwetha();
        TestCase_MakeMyTrip_shwetha tc6=new TestCase_MakeMyTrip_shwetha();
        Excel ex=new Excel(System.getProperty("user.dir") + "//src//test//java//data.xlsx");
      // ex.excelReader();
       TestCase_OlayRegistration_shwetha tc7=new TestCase_OlayRegistration_shwetha();
     tc7.registerUser();
     // tc7.signIn();
//       // tc7.signIn();
      //  tc6.bookFlight();
        //tc5.selectMenu();
//        tc4.datePick();
//        tc3.getDrag();
//        TestCase2_Shwetha.fillContactForm();
//        TestCase2_Shwetha.clickText();
//        TestCase1_shwetha.printItemName();
//        //base.closeBrowser();
    }
}
