package fr.assococktail.cktlParametres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;
// import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CktlParametresApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CktlParametresApplication.class, args);
    }

    // A creuser la pertinence d'override ce truc, plue value par rapport à l'approche classique
     @Override
     protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(CktlParametresApplication.class);
     }
}
