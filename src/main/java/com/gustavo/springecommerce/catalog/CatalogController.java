package com.gustavo.springecommerce.catalog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/api/catalogs")
    public ResponseEntity getCatalogs(){
        return new ResponseEntity(catalogService.getCatalogs(), HttpStatus.OK);
    }
}
