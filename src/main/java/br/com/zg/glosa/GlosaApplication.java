package br.com.zg.glosa;

import br.com.zg.glosa.jobs.RealizarDownload;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication()
//@EnableJpaRepositories("br.com.zg.glosa.repository")
public class GlosaApplication {

    public static void main(String[] args) throws IOException {
        RealizarDownload executor = new RealizarDownload();
        executor.navegar();
        SpringApplication.run(GlosaApplication.class, args);

    }

}
