package com.personalAssist.MindMap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalAssist.MindMap.Model.Product;
import com.personalAssist.MindMap.repository.ProductRepository;

@Service
public class ProductServiceimpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		Product result =  productRepository.save(product);
		System.out.println("@@@------ "+ result);
		return result;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getById(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public String deletProduct(Integer id) {
		// TODO Auto-generated method stub
		Product checkProduct = productRepository.findById(id).orElse(null);
		if(checkProduct !=  null) {
			productRepository.deleteById(id);
			return "Product id "+ id + " deleted";
		}
		
		return "The product id "+ id +" doesnot exist";
	}

	@Override
	public Optional<Product> updateProduct(Integer id, Product updateProduct) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).map((product) -> {
			product.setName(updateProduct.getName());
			product.setLocation(updateProduct.getLocation());
			return productRepository.save(product);
			
		});
	}


	}


