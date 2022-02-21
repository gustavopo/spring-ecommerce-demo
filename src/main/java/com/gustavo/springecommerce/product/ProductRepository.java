package com.gustavo.springecommerce.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductBySku(String sku);

    List<Product> findProductsByCatalogName(String catalogName);
}
