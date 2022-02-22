package com.gustavo.springecommerce.product;

import com.gustavo.springecommerce.catalog.Catalog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @InjectMocks ProductService productService;

    @Mock ProductRepository productRepository;

    @Test
    public void Given_Products_When_GetAll_Then_ReturnAllProducts(){
        // Given
        var catalog = createCatalog();
        var product_1 = createProduct(1L,"product_1","sku1", catalog);
        var product_2 = createProduct(2L,"product_2","sku2", catalog);

        given(productRepository.findAll()).willReturn(List.of(product_1,product_2));

        // When
        var actual = productService.getProducts();

        // Then
        assertThat(actual).hasSize(2);

        var actualProduct_1 = actual.get(0);
        assertThat(actualProduct_1.name()).isEqualTo(product_1.getName());
        assertThat(actualProduct_1.sku()).isEqualTo(product_1.getSku());
        assertThat(actualProduct_1.description()).isEqualTo(product_1.getDescription());
        assertThat(actualProduct_1.catalog().name()).isEqualTo(product_1.getCatalog().getName());

        var actualProduct_2 = actual.get(1);
        assertThat(actualProduct_2.name()).isEqualTo(product_2.getName());
        assertThat(actualProduct_2.sku()).isEqualTo(product_2.getSku());
        assertThat(actualProduct_2.description()).isEqualTo(product_2.getDescription());
        assertThat(actualProduct_2.catalog().name()).isEqualTo(product_2.getCatalog().getName());
    }

    private Product createProduct(long id, String name, String sku, Catalog catalog) {
        return new Product(id, name, sku, "description", catalog, Instant.now());
    }

    private Catalog createCatalog() {
        return new Catalog(1L, "catalogName", Instant.now());
    }
}
