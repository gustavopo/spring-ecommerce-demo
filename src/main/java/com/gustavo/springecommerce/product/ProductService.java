package com.gustavo.springecommerce.product;

import com.gustavo.springecommerce.catalog.CatalogResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> getProducts(){
        return toDtos(productRepository.findAll());
    }

    public Product getProductBySku(String sku){
            return productRepository.findProductBySku(sku);
        }

    public List<Product> getProductsByCatalogName(String catalogName){
        return productRepository.findProductsByCatalogName(catalogName);
    }

    private static ProductResponseDTO toDto(Product product){
        var catalog = product.getCatalog();
        return new ProductResponseDTO(product.getSku(),product.getName(),product.getDescription(), new CatalogResponseDTO(catalog.getId(),catalog.getName()));
    }

    private static List<ProductResponseDTO> toDtos(List<Product> products){
        return products.stream().map(ProductService::toDto).collect(Collectors.toList());
    }

}
