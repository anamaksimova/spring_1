package ru.geekbrains.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private  Map<Long,Product> productMap = new ConcurrentHashMap<>();

    private  AtomicLong identity = new AtomicLong(0);
    @PostConstruct
    public void init() {
        this.save(new Product(1L, "product1", 25f));
        this.save(new Product( 2L,"product2", 99f));
        this.save(new Product(3L, "product3", 99.99f));
    }

    public List<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }

    public Product findById(long id){
        return productMap.get(id);
    }
    public void save(Product product){

            long id = identity.incrementAndGet();
            product.setId(id);
        productMap.put(product.getId(),product);

    }

    public void update(Product product) {
        productMap.put(product.getId(), product);
    }
    public void delete(long id){
        productMap.remove(id);
    }
}
