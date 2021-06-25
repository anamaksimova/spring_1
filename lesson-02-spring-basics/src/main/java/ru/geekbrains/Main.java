package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart = context.getBean("cart",Cart.class);
        cart.cartShow();
        Cart cart2 = context.getBean("cart",Cart.class);
        cart2.cartShow();
        cart.cartShowById(1);
    }

    }

