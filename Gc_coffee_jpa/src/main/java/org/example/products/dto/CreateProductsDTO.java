package org.example.products.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.products.domain.Category;
import org.example.products.domain.ProductStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductsDTO {
	private String productName;
	private Category category;
	private Integer price;
	private Integer stock;
	private String description;
	private ProductStatus productStatus;
}
