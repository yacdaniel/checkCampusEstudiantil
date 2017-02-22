package com.yacdaniel.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by elmo on 2/21/17.
 */
public class Descargas extends PaginaBase {

    @FindBys({
            @FindBy(xpath = "//span[@class='field-content']")
    })
    public List<WebElement> listaMaterial;

    @FindBy(css = ".pager-last>a")
    public WebElement ultimaPagina;

    public int NUMERO_PAGINA_MAXIMO;
    public int NUMERO_MATERIALES_PAGINA;


    public int linksFallidos;

    public Descargas(WebDriver navegador) {
        super(navegador);
        PageFactory.initElements(navegador, this);
    }


    public int totalPaginas() {
        System.out.println(ultimaPagina.getAttribute("href"));
        //((JavascriptExecutor) navegador).executeScript("arguments[0].scrollIntoView(true);", element);
        return listaMaterial.size();
    }


    public Descargas abrir(){
        navegador.get("https://campusestudiantiluned.com/descargas");
        String url = ultimaPagina.getAttribute("href");
        NUMERO_PAGINA_MAXIMO =  Integer.valueOf(url.substring(url.length()-2));
        return this;
    }

    public Descargas scrollMedianteJS(int i) {
        scrollMedianteJS(listaMaterial.get(i));
        return this;
    }

    public Descargas comprobarLinks() {
        return this;
    }

    public Descargas irPaginaNumero(int numeroPagina) {
        navegador.get("https://campusestudiantiluned.com/descargas?&page="+numeroPagina);
        NUMERO_MATERIALES_PAGINA = listaMaterial.size();
        PageFactory.initElements(navegador, this);
        return this;
    }

    public MaterialIndividual clickMaterialNumero(int numero) {
        System.out.println(listaMaterial.get(numero));
        listaMaterial.get(numero).click();
        return PageFactory.initElements(navegador, MaterialIndividual.class);
    }
}
