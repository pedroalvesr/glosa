package br.com.zg.glosa.jobs;

import org.junit.Test;
import org.openqa.selenium.By;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication()
public class RealizarDownload {

    Acoes acao = new Acoes();
    Download baixar = new Download();

    @Test
    public void navegar() throws IOException {

        int cont = 1;

        while(acao.existeElemeto(By.xpath("//*[@id='list-arquivo']/div/a["+cont+"]"))){

            //Clicar para abrir pagina que arquivo está
            acao.clicar(By.xpath("//*[@id='list-arquivo']/div/a["+cont+"]"));

            //Obtem os dados para nomear o arquivo e realizar o download
            String nomeArquivo = acao.obterTexto(By.xpath("//*[@id='list-arquivo']/div/ul/li/a"));
            String url = acao.obterURL(By.xpath("//*[@id='list-arquivo']/div/ul/li/a"));

            //Realiza o Download do arquivo
            baixar.downloadAR(url, nomeArquivo);
            System.out.println("Download do Arquivo: "+ nomeArquivo);

            //clicar em voltar voltar
            acao.clicar(By.xpath("//*[@id=\"list-arquivo\"]/a"));
            cont++;
        }
        acao.fecharNavegador();
    }
}