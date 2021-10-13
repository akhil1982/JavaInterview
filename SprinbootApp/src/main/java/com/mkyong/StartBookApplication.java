package com.mkyong;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.math.BigDecimal;
import java.util.List;

@EnableAutoConfiguration(exclude = JdbcTemplateAutoConfiguration.class)

public class StartBookApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StartBookApplication.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.setLogStartupInfo(false);
        String[] appargs = {"--debug"};
        ConfigurableApplicationContext c = app.run(appargs);
        List<String> packages = AutoConfigurationPackages.get(c);
        System.out.println("packages: "+packages);
        //SpringApplication.run(StartBookApplication.class, args);


    }

    // init bean to insert 3 books into h2 database.
    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("A Guide to the Bodhisattva Way of Life", "Santideva", new BigDecimal("15.41")));
            repository.save(new Book("The Life-Changing Magic of Tidying Up", "Marie Kondo", new BigDecimal("9.69")));
            repository.save(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", new BigDecimal("47.99")));

        };
    }
}