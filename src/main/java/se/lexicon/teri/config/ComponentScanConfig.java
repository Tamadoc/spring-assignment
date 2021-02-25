package se.lexicon.teri.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "se.lexicon.teri.*")
public class ComponentScanConfig {

    // Defining the Bean for returning a Scanner object to be injected
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
}
