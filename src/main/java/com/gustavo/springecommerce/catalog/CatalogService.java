package com.gustavo.springecommerce.catalog;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogService {

    private final CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public List<CatalogResponseDTO> getCatalogs() {
        return toDtos(catalogRepository.findAll());
    }

    private static CatalogResponseDTO toDto(Catalog catalog){
        return new CatalogResponseDTO(catalog.getId(),catalog.getName());
    }

    private static List<CatalogResponseDTO> toDtos(List<Catalog> products){
        return products.stream().map(CatalogService::toDto).collect(Collectors.toList());
    }
}
