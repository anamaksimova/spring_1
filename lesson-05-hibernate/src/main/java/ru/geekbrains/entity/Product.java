package ru.geekbrains.entity;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 512, nullable = false)
    private  String productname;
    @Column(nullable = false)
    private Integer price;

    public Product(){

    }

    public Product(Long id, String productname, Integer price) {
        this.id = id;
        this.productname = productname;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return productname;
    }
    public Integer getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setName(String name) {
        this.productname = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + productname + '\'' +
                ", price=" + price +
                '}';
    }
    @ManyToMany
    @JoinTable(
            name = "products_customers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
