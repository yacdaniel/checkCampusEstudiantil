package com.yacdaniel.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 *
 */
public class SeleniumBase {

    public static WebDriver navegador;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        navegador = new FirefoxDriver();
        navegador.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        navegador.quit();
    }


}