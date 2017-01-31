package com.yacdaniel.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Xpc on 30/01/2017.
 */
public class SeleniumBase {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        driver.quit();
    }


}