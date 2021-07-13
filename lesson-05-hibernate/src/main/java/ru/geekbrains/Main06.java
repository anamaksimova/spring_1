package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.entity.Cart;
import ru.geekbrains.entity.Customer;
import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Main06 {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Cart cart = new Cart(emFactory);
        ProductRepository productRepository = new ProductRepository(emFactory);
//        List.of(
//
//                new Customer(null, "Nick"),
//                new Customer(null, "Micky"),
//                new Customer(null, "Oleg")
//        ).forEach(em::persist);
//
//        em.getTransaction().commit();
//
//         em.getTransaction().begin();
//
//
//
//        List.of(
//
//                new Product(null, "tart", 45),
//                new Product(null, "lemon", 10),
//                new Product(null, "strawberry", 108),
//                new Product(null, "watermelon", 118),
//                new Product(null, "bread", 9)
//        ).forEach(em::persist);
//
//        em.getTransaction().commit();
//        em.close();


//          cart.buy(2L, 3L);
//        cart.buy(2L, 5L);
        cart.findProductByCustomerId(2L);
      //  cart.buy(3L, 5L);
       cart.findCustomerByProductId(5L);
    }

}
