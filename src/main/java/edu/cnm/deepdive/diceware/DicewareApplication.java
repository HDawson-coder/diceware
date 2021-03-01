package edu.cnm.deepdive.diceware;

import java.security.SecureRandom;
import java.util.Random;
import java.util.ResourceBundle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DicewareApplication {

  public static void main(String[] args) {
    SpringApplication.run(DicewareApplication.class, args);
  }

  @Bean
  public Random random() {
    return new SecureRandom();
  }

  @Bean
  public ResourceBundle bundle() {
    return ResourceBundle.getBundle("wordlist");
  }

}
