package ru.geekbrains.persist;

public class Product {
    private Long id;
    private  String name;
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
