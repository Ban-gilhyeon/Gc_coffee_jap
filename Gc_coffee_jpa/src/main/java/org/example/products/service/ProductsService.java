package org.example.products.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.products.domain.Products;
import org.example.products.dto.CreateProductsDTO;
import org.example.products.dto.ProductsDTO;
import org.example.products.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductsService {
		private final ProductsRepository productsRepository;

		public ProductsDTO save(CreateProductsDTO createProductsDTO) {
			Products products = Products.from(createProductsDTO);
			Products saveproducts = productsRepository.save(products);
			log.info("Product saved to database: {}", saveproducts);
			return ProductsDTO.from(saveproducts);
		}
		public List<ProductsDTO> list() {
		  return productsRepository.findAll();
		}
		public ProductsDTO findById(Integer id) {
			ProductsDTO productsDTO = ProductsDTO.from(productsRepository.findById(id).orElse(null));
			return productsDTO;
		}
}
