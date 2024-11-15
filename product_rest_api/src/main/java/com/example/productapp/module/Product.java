package com.example.productapp.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public long productId;
	
	public String productName;
	public double price;
	
	/*
	 * public Product() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * public Product(long productId, String productName, double price) { super();
	 * this.productId = productId; this.productName = productName; this.price =
	 * price; }
	 * 
	 * public long getProductId() { return productId; } public void
	 * setProductId(long productId) { this.productId = productId; } public String
	 * getProductName() { return productName; } public void setProductName(String
	 * productName) { this.productName = productName; } public double getPrice() {
	 * return price; } public void setPrice(double price) { this.price = price; }
	 * 
	 * @Override public String toString() { return "Product [productId=" + productId
	 * + ", productName=" + productName + ", price=" + price + "]"; }
	 */

}
