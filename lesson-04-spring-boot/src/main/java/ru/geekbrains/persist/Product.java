package ru.geekbrains.persist;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@NotBlank
@Column(nullable = false)
    private  String name;
@Min(0L)
@Column(nullable = false)
    private Float price;

    public Product(){

    }

    public Product(Long id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Float getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
}
