package com.gustavo.springecommerce.catalog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gustavo.springecommerce.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "catalog")
    @JsonIgnore
    private List<Product> products;

    @CreationTimestamp
    private Instant createdAt;

}
