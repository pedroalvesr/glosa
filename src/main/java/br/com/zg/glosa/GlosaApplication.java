package br.com.zg.glosa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
//@EnableJpaRepositories("br.com.zg.glosa.repository")
public class GlosaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlosaApplication.class, args);
    }

}
