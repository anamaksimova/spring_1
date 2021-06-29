package ru.geekbrains;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("ru.geekbrains")
public class AppConfig {
    @Bean ("cart")
    @Scope("prototype")
    public Cart cart(ProductRepository1 productRepository1) {
        return new Cart();
    }
}
