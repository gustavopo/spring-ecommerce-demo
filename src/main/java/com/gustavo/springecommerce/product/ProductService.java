package com.gustavo.springecommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductBySku(String sku){
            return productRepository.findProductBySku(sku);
        }

    public List<Product> getProductsByCatalogName(String catalogName){
        return productRepository.findProductsByCatalogName(catalogName);
    }
}
