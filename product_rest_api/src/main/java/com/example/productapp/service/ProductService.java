package com.example.productapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productapp.module.Product;
import com.example.productapp.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product>  getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product saveProduct(Product product){
		return productRepository.save(product);
	}
	
	public Product findById(long productId) {
		return productRepository.findById(productId).get();
	}
	
	public boolean updateProduct(long productId,Product product) {
		Optional<Product> products=productRepository.findById(productId);
		if (products.isPresent() && product.productId==productId ) {
			productRepository.save(product);
			return true;
		}
		return false;
	}
	
	public boolean deleteProductById(long productId) {
		Optional<Product> product= productRepository.findById(productId);
		
		if(product.isPresent()) {
			productRepository.deleteById(productId);
			return true;
		}
		return false;
	}
	
	public void deleteProducts() {
		productRepository.deleteAll();
	}

}
