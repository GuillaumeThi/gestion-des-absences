package dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Application démarrée via Spring Boot.
 */
@SpringBootApplication
public class App {

  /**
   * Démarrage de l'application Web.
   *
   * @param args argument du programme
   */
  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }
}
