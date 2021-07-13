package ru.geekbrains.entity;

import org.hibernate.annotations.Parameter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Cart {
    private final EntityManagerFactory emFactory;


    public Cart(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public void buy(long idCustomer, long id) {
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Products_Customers pc = new Products_Customers(null, idCustomer, id);
       em.persist(pc);

        em.getTransaction().commit();
        em.close();

    }

    public void findProductByCustomerId(long idCustomer){
        EntityManager em = emFactory.createEntityManager();

        List<Products_Customers> shoppingList = em.createNativeQuery("SELECT * FROM hibernate_lesson_1.products_customers where customer_id="+idCustomer, Products_Customers.class).getResultList();
        System.out.println(shoppingList);
            em.close();


    }

    public void findCustomerByProductId(long id){
        EntityManager em = emFactory.createEntityManager();

        List<Products_Customers> shoppingList = em.createQuery(" select pc from Products_Customers pc where pc.id="+id , Products_Customers.class).getResultList();
        
        System.out.println(shoppingList);
        em.close();


    }
}
