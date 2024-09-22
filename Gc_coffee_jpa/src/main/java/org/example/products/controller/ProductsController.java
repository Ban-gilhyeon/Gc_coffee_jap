package org.example.products.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.products.dto.CreateProductsDTO;
import org.example.products.dto.ProductsDTO;
import org.example.products.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/product")
public class ProductsController {
	private final ProductsService productsService;

	@GetMapping("/save")
	public ResponseEntity<ProductsDTO> save(@RequestBody CreateProductsDTO productsDTO) {
		ProductsDTO productDTO = productsService.save(productsDTO);
		return new ResponseEntity<>(productDTO, HttpStatus.OK);
	}

	@PostMapping("/list")
	public void list() {
		productsService.list();
	}

	@GetMapping("/searchId/{id}")
	public void serchById(@PathVariable("id") Integer id) {
		productsService.findById(id);
	}
}
