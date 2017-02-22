package com.yacdaniel.paginas;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by elmo on 2/21/17.
 */
public class PaginaBase {

    protected WebDriver navegador;

    public PaginaBase(WebDriver navegador) {
        this.navegador = navegador;
    }

    public PaginaBase scrollMedianteJS(WebElement elemento){
        ((JavascriptExecutor) navegador).executeScript("arguments[0].scrollIntoView(true);", elemento);
        return this;
    }

    public String titulo() {
        return navegador.getTitle();
    }

    public String url() {
        return navegador.getCurrentUrl();
    }

}
