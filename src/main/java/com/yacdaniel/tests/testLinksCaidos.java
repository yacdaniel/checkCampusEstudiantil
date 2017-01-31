package com.yacdaniel.tests;

import com.yacdaniel.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Xpc on 30/01/2017.
 */
public class testing extends SeleniumBase {

    @Test
    public void openUrl(){

        driver.get("http://google.com");
        driver.findElement(By.cssSelector("q"));

        //links .//span[@class="field-content"]
        //next //li[@class="next"]/a
    }
}
