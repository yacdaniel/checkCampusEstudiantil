package com.yacdaniel.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
/**
 *
 */
public class SeleniumBase {

    public static WebDriver navegador;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
	navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        navegador.quit();
    }


}
