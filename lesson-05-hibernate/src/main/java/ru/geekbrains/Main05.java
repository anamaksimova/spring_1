package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main05 {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();
        ProductRepository productRepository = new ProductRepository(emFactory);
       //INSERT
        // em.getTransaction().begin();



//        List.of(

//                new Product(null, "tart", 45),
//                new Product(null, "lemon", 10),
//                new Product(null, "strawberry", 108),
//                new Product(null, "watermelon", 118),
//                new Product(null, "bread", 9)
//        ).forEach(em::persist);
//
//        em.getTransaction().commit();
//        em.close();

//        System.out.println(productRepository.findAll());
//        System.out.println(productRepository.findById(5L));
//        productRepository.delete(12L);
   //     productRepository.updatePrice(3L, 500);
//       Product pr =  new Product(null, "milk", 80);
        Product pr =  new Product(1L, "apple", 8);
        productRepository.save(pr);
    }

}
