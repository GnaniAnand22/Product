package com.example.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productapp.service.ProductService;
import com.example.productapp.module.Product;
import com.example.productapp.response.ResponseHandler;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping("/addproduct")
	public String addProduct(@RequestBody Product product) {
		
		productService.saveProduct(product);
		return "PRODUCT "+product.productId+" ADDED SUCCESSFULLY";
	}
	
	@GetMapping("/getproduct/{productId}")
	public Product getProductById(@PathVariable ("productId") long productId) {
		return productService.findById(productId);
	}
	
	@GetMapping("/getallproducts") 
	public List<Product> getAllProducts(Product product){
		return productService.getAllProducts();
		
	}
	
	@PutMapping("/updateproduct/{productId}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product,@PathVariable("productId") long productId) {
		
		boolean isUpdate=productService.updateProduct(productId,product);
		if(isUpdate ) {
			return ResponseHandler.responseBuilder("Product Update Detailes",HttpStatus.OK,"Product "+productId+" is Updated");
		}else {
			return ResponseHandler.responseBuilder("Enterd Wrong Detailes",
					HttpStatus.BAD_REQUEST,"Enterd product id "+productId+" Not Found");
		}
	}
	
	@DeleteMapping("/deleteproduct/{productId}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("productId") long productId)  {
		
		boolean isDeleted=productService.deleteProductById(productId);
		
		if(isDeleted) {
			return ResponseHandler.responseBuilder("Product Delete Detailes", 
											HttpStatus.OK,"product "+productId+" deleted successfully");
		}else {
			return ResponseHandler.responseBuilder("Product "+productId+" Not found",
														HttpStatus.NOT_FOUND, "product "+productId+" not found");
		}
	}
	
	@DeleteMapping("/deleteallproducts")
	public String deleteAllProducts() {
		productService.deleteProducts();
		return "All Products Are Deleted";
	}
	
}
