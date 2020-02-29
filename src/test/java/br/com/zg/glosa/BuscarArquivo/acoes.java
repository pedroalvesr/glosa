package br.com.zg.glosa.BuscarArquivo;

import br.com.zg.glosa.AbrirURL.AbrirConvenio;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class acoes {
    private static String NAVEGADOR = "chrome";
    private WebDriver driverWeb = AbrirConvenio.getURL(NAVEGADOR);

    public void clicar(By by) {
        driverWeb.findElement(by).click();
    }

    public String obterTexto(By by) {
        String texto = driverWeb.findElement(by).getText();
        return texto;
    }

    public String obterURL(By by) {
        String texto = driverWeb.findElement(by).getAttribute("href");
        return texto;
    }

    public void fecharNavegador() {
        driverWeb.quit();
    }

    public boolean existeElemeto(By by) {
        List<WebElement> elementos = driverWeb.findElements(by);
        return elementos.size() > 0;
    }
}