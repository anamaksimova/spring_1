package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       ServletContext sc =  sce.getServletContext();


    ProductRepository productRepository = new ProductRepository();
    productRepository.save(new Product(1L, "Product1"));
        productRepository.save(new Product(2L, "Product2"));
        productRepository.save(new Product(3L, "Product3"));
        productRepository.save(new Product(4L, "Product4"));
        productRepository.save(new Product(5L, "Product5"));

        sc.setAttribute("productRepository", productRepository);
    }
}
