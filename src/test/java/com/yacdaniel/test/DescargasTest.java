package com.yacdaniel.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test link descargas campusestudiantiluned.com
 * @author Yacdaniel Hurtado
 */
public class DescargasTest {

    private WebDriver navegador;
    private List<String> linksFallados, linkBuenos, dominiosDescargas = new ArrayList<>();
    private String url = "https://campusestudiantiluned.com/descargas?term_node_tid_depth=All&field_subject_code_tid=All&field_file_type_tid=All&field_year_tid=All&page=%d";
    private List<WebElement> materialesPaginas;

    @BeforeMethod()
    public void beforeTest(){
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait( 20, TimeUnit.SECONDS);
    }

    @Test()
    public void testLinkCaidos(){
        navegador.get("https://campusestudiantiluned.com/descargas");
        String urlUltimo = navegador.findElement(By.cssSelector(".pager-last>a")).getAttribute("href");
        int numeroPaginaMaximo = Integer.valueOf(urlUltimo.substring(urlUltimo.length()-2));
        for (int i = 0; i <= numeroPaginaMaximo ; i++) {
            navegador.get(String.format(url, i));
            materialesPaginas = navegador.findElements(By.cssSelector(".field-content>a"));
            for(int j = 0; j < materialesPaginas.size(); j++ ){

            }
        }
        assertThat(numeroPaginaMaximo, is(equalTo(49)));


    }

    @AfterMethod
    public void afterTest() throws IOException {
        navegador.quit();
        Files.write(Paths.get("linkFallados.txt"), linksFallados, UTF_8, CREATE, TRUNCATE_EXISTING);
        Files.write(Paths.get("dominios.txt"), dominiosDescargas, UTF_8, CREATE, TRUNCATE_EXISTING);
        Files.write(Paths.get("linkBuenos.txt"), linkBuenos, UTF_8, CREATE, TRUNCATE_EXISTING);

    }

}
