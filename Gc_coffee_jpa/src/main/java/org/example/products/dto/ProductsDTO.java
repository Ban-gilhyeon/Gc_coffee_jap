package org.example.products.dto;

import lombok.Builder;
import lombok.Data;
import org.example.products.domain.Category;
import org.example.products.domain.ProductStatus;
import org.example.products.domain.Products;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductsDTO {
	private  Integer productId;
	private  String productName;
	private Integer stock;
	private Integer price;
	private String description;
	private ProductStatus productStatus;
	private Category category;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public static ProductsDTO from(Products products) {
		return ProductsDTO.builder()
						.productId(products.getProductId())
						.productName(products.getProductName())
						.stock(products.getStock())
						.category(products.getCategory())
						.price(products.getPrice())
						.description(products.getDescription())
						.productStatus(products.getProductStatus())
						.build();
	}
}
