package br.com.zg.glosa.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Acoes {

    private WebDriver driverWeb = AbrirConvenio.getURL();

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