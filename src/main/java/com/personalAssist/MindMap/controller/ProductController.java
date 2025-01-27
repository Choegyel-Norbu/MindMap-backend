package com.personalAssist.MindMap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalAssist.MindMap.Model.Product;
import com.personalAssist.MindMap.service.ProductService;

@RestController
@RequestMapping("api/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("postProd")
	public Product postProduct(@RequestBody Product product) {
		
		Product result = productService.addProduct(product);
		if(result != null) {
			return result;
		}
		return null;
	}
	
	@GetMapping("getProds")
	public List<Product> getAllProducts() {
		return productService.getAllProduct();
	}
	
	@GetMapping("getProd/{id}")
	public Product getById(@PathVariable Integer id) {
		return productService.getById(id);
	}
	
	@DeleteMapping("deleteProd/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		return productService.deletProduct(id);
	}
	
	@PatchMapping("updateProd/{id}")
	public Optional<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
}
