package com.yacdaniel.tests;

import com.google.common.collect.Sets;
import com.yacdaniel.paginas.Descargas;
import com.yacdaniel.paginas.LinkExterno;
import com.yacdaniel.paginas.MaterialIndividual;
import com.yacdaniel.selenium.SeleniumBase;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

/**
 * Created by Xpc on 30/01/2017.
 */
public class testLinksCaidos extends SeleniumBase {

    @Test
    public void testLink() throws InterruptedException, IOException {
        List<String> linksFallados = new ArrayList<>();
        List<String> linksBuenos = new ArrayList<>();
        List<String> dominiosDescargas = new ArrayList<>();
        Descargas descargas = new Descargas(navegador);
        descargas.abrir();
        for (int i = 0; i <= descargas.NUMERO_PAGINA_MAXIMO; i++){
            descargas.irPaginaNumero(i);
            for (int j = 0; j < descargas.NUMERO_MATERIALES_PAGINA; j++) {
                MaterialIndividual materialIndividual = descargas.clickMaterialNumero(j);
                LinkExterno linkExterno = materialIndividual.irDescargarArchivo();
                String url = linkExterno.url();
                String host = new URL(url).getHost();
                if(linkExterno.titulo().toLowerCase().contains("error")){
                    linksFallados.add(url);
                }
                else {
                    System.out.println(linksBuenos);
                    linksBuenos.add(url);
                }
                if(!dominiosDescargas.contains(host)){
                    dominiosDescargas.add(host);
                }
                linkExterno.devolverPaginaDescargasNumero(i);
            }
        }
        Files.write(Paths.get("linkFallados.txt"), linksFallados, UTF_8, CREATE, TRUNCATE_EXISTING);
        Files.write(Paths.get("dominios.txt"), dominiosDescargas, UTF_8, CREATE, TRUNCATE_EXISTING);
        Files.write(Paths.get("linkBuenos.txt"), linksBuenos, UTF_8, CREATE, TRUNCATE_EXISTING);
    }
}
