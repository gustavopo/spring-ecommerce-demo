package com.gustavo.springecommerce.catalog;

import com.gustavo.springecommerce.product.Product;
import com.gustavo.springecommerce.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/api/catalogs")
    public ResponseEntity<List<Catalog>> getCatalogs(){
        return new ResponseEntity<>(catalogService.getCatalogs(), HttpStatus.OK);
    }
}
