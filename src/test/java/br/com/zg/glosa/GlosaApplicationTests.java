package br.com.zg.glosa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GlosaApplicationTests {

   @Test
   public void contextLoads() {
      try {
         downloadAR();
      } catch (Exception e) {
         // TODO: handle exception
      }
   }

   private void downloadAR() throws IOException {
      URL url = new URL(
            "https://glosamax.zeroglosa.com.br/glosamax/arquivo/download?nome=glosamax_2018-02-15.xml&data=2018-02-15");
      String destino = "catalog_java.xml";

      InputStream is = url.openStream();
      FileOutputStream fos = new FileOutputStream(destino);

      int bytes = 0;

      while ((bytes = is.read()) != -1) {
         fos.write(bytes);
      }

      is.close();

      fos.close();
   }

}
