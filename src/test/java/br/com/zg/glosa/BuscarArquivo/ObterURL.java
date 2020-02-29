package br.com.zg.glosa.BuscarArquivo;

import br.com.zg.glosa.DownloadArquivo.RealizarDownload;
import org.junit.Test;
import org.openqa.selenium.By;
import java.io.IOException;

public class ObterURL {

    private acoes acao = new acoes();
    private RealizarDownload baixar = new RealizarDownload();

    @Test
    public void navegar() throws IOException {

        int cont = 1;

        while(acao.existeElemeto(By.xpath("//*[@id='list-arquivo']/div/a["+cont+"]"))){

            acao.clicar(By.xpath("//*[@id='list-arquivo']/div/a["+cont+"]"));

            //Obtem os dados para nomear o arquivo e realizar o download
            String nomeArquivo = acao.obterTexto(By.xpath("//*[@id='list-arquivo']/div/ul/li/a"));
            String url = acao.obterURL(By.xpath("//*[@id='list-arquivo']/div/ul/li/a"));

            //Realiza o Download dos arquivos
            baixar.downloadAR(url, nomeArquivo);
            System.out.println("Download do Arquivo: "+ nomeArquivo);

            //voltar
            acao.clicar(By.xpath("//*[@id=\"list-arquivo\"]/a"));
            cont++;
        }
        acao.fecharNavegador();
    }
}