package ru.geekbrains;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("cart")

public class Cart {


    public void cartShow(){
    ProductRepository1 productRepository1 = new ProductRepository1();
    productRepository1.save(new Product(1L, "Product1"));
        productRepository1.save(new Product(2L, "Product2"));
        productRepository1.save(new Product(3L, "Product3"));
        productRepository1.save(new Product(4L, "Product4"));
        productRepository1.save(new Product(5L, "Product5"));
        List<Product> products =  productRepository1.findAll();
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    public void cartShowById(long id){
        ProductRepository1 productRepository1 = new ProductRepository1();
        productRepository1.save(new Product(1L, "Product1"));
        productRepository1.save(new Product(2L, "Product2"));
        productRepository1.save(new Product(3L, "Product3"));
        productRepository1.save(new Product(4L, "Product4"));
        productRepository1.save(new Product(5L, "Product5"));
        Product product =  productRepository1.findById(id);

            System.out.println(product.getName());

    }
}
