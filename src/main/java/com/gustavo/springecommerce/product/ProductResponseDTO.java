package com.gustavo.springecommerce.product;

import com.gustavo.springecommerce.catalog.CatalogResponseDTO;

public record ProductResponseDTO(String sku, String name, String description, CatalogResponseDTO catalog) {
}