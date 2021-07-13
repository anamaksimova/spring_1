package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Component

public class ProductRepository1 {
    private final Map<Long,Product> productMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    public List<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }

    public Product findById(long id){
        return productMap.get(id);
    }
    public void save(Product product){
        if (product.getId()==null){
            long id = identity.incrementAndGet();
            product.setId(id);}
        productMap.put(product.getId(),product);

    }
    public void delete(long id){
        productMap.remove(id);
    }

}
