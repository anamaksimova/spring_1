package ru.geekbrains.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products_customers")
public class Products_Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPC;

    @Column(name = "customer_id")
    private Long idCustomer;

    @Column(name = "product_id")
    private Long  id;



    public Products_Customers() {
    }
    public Products_Customers(Long idPC, Long idCustomer, Long id) {
        this.idPC = idPC;
        this.idCustomer = idCustomer;
        this.id = id;

    }

    public Long getIdPC() {
        return idPC;
    }

    public void setIdPC(Long idPC) {
        this.idPC = idPC;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +

                '}'+
        " customerId=" + idCustomer +
                '}';
    }

}
