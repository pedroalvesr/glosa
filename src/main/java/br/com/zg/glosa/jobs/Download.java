package br.com.zg.glosa.jobs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Download {

   public void downloadAR(String url, String nomeArquivo) throws IOException {

      URL RecebeUrl = new URL(url);

      String destino = "arquivos\\" + nomeArquivo;

      InputStream is = RecebeUrl.openStream();
      FileOutputStream fos = new FileOutputStream(destino);

      int bytes = 0;

      while ((bytes = is.read()) != -1) {
         fos.write(bytes);
      }
      is.close();
      fos.close();
   }
}
