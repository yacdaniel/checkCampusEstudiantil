package com.yacdaniel.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by elmo on 2/21/17.
 */
public class MaterialIndividual extends PaginaBase {
    @FindBy(css = ".btn-download>a")
    private WebElement descargarArchivo;

    public MaterialIndividual(WebDriver navegador) {
        super(navegador);
        PageFactory.initElements(navegador, this);
    }

    public MaterialIndividual devolverPaginaNumero(int i) {
        navegador.get("https://campusestudiantiluned.com/descargas?&page="+i);
        return this;
    }

    public LinkExterno irDescargarArchivo() {
        navegador.get(descargarArchivo.getAttribute("href"));
        return PageFactory.initElements(navegador, LinkExterno.class);
    }
}
