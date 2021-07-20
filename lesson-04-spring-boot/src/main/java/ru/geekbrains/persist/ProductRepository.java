package ru.geekbrains.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public interface ProductRepository extends JpaRepository <Product,Long>, JpaSpecificationExecutor<Product> {
    List<Product> findByNameStartsWith(String prefix);

    @Query("select p " +
            "from Product p " +
            "where ( p.name like CONCAT(:prefix, '%') or :prefix is null ) and " +
            "( p.price >= :minPrice or :minPrice is null ) and " +
            "( p.price <= :maxPrice or :maxPrice is null )")
    List<Product> filterProducts(@Param("prefix") String prefix,
                           @Param("minPrice") Float minPrice,
                           @Param("maxPrice") Float maxPrice);
}
