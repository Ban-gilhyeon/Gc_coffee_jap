package org.example.products.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.products.dto.CreateProductsDTO;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer productId;
    private  String productName;
    private Integer stock ;
    private Integer price;
    private String description;
    private ProductStatus status;
    private Category category;
    private  LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        //save할 때 created_at 설정
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = LocalDateTime.now();
    }

    public static Products from(CreateProductsDTO productsDTO){
        return Products.builder()
                .productName(productsDTO.getProductName())
                .category(productsDTO.getCategory())
                .status(productsDTO.getProductStatus())
                .stock(productsDTO.getStock())
                .price(productsDTO.getPrice())
                .description(productsDTO.getDescription())
                .build();
    }
}
