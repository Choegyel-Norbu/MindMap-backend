package com.personalAssist.MindMap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.personalAssist.MindMap.Model.Product;

@Component
public interface ProductService {

	public Product addProduct(Product product);
	public List<Product> getAllProduct();
	public Product getById(Integer id);
	public String deletProduct(Integer id);
	public Optional<Product> updateProduct(Integer id, Product updateProduct);
}
