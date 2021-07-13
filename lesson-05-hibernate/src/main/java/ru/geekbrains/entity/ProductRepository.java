package ru.geekbrains.entity;

import ru.geekbrains.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProductRepository {
    private final EntityManagerFactory emFactory;

    public ProductRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public  List<Product> findAll(){
        EntityManager em = emFactory.createEntityManager();

     try{
         List <Product> allProducts =
          em.createQuery("select p from Product p", Product.class).getResultList();
         return allProducts;
     }
     finally {
         em.close();
     }
     }



    public Optional<Product> findById(long id){
        EntityManager em = emFactory.createEntityManager();

           try{
               return Optional.ofNullable(em.find(Product.class, id));
           } finally {
               em.close();
           }

    }
    public void save(Product product){
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Product pr = product;
          em.merge(pr);

        em.getTransaction().commit();
        em.close();


    }

    public void updatePrice(long id, int price) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Product product = em.find(Product.class, id);
        product.setPrice(price);

        em.getTransaction().commit();
        em.close();
        System.out.println("Product "+ id + " price is updated");
    }
    public void delete(long id){
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Product product = em.getReference(Product.class, id);
        em.remove(product);

        em.getTransaction().commit();
        em.close();
        System.out.println("Product "+ id + " deleted");
    }
}
