package ru.geekbrains.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="custumers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;

    @Column(nullable = false)
    private String custumerName;

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustumerName() {
        return custumerName;
    }

    public void setCustumerName(String custumerName) {
        this.custumerName = custumerName;
    }

    public Customer() {

    }
    public Customer(Long idCustomer, String custumerName) {
        this.idCustomer = idCustomer;
        this.custumerName = custumerName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + idCustomer +
                ", name='" + custumerName + '\'' +

                '}';
    }
    @ManyToMany
    @JoinTable(
            name = "products_customers",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
