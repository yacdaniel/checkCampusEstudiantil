package com.yacdaniel.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * Created by elmo on 2/21/17.
 */
public class LinkExterno extends PaginaBase {
    public LinkExterno(WebDriver navegador) {
        super(navegador);
    }

    public LinkExterno devolverPaginaDescargasNumero(int i) {
        navegador.get("https://campusestudiantiluned.com/descargas?&page="+i);
        return this;
    }


}
