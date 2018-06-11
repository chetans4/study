package com.metacube.shoppingcart.entity;



import java.util.HashMap;
import java.util.Map;


/**
 * this class sets or gets the shopping cart entities
 * @author Jaya Bapna
 *
 */
public class ShoppingCart {

	String userId;
	Map<Product, Integer> items = new HashMap<>();
	float totalPrice;
	/* Getters and Setters for all data members */
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Map<Product, Integer> getItems() {
		return items;
	}
	public void setItems(Map<Product, Integer> items) {
		this.items = items;
	}
	public float getTotPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totPrice) {
		this.totalPrice = totPrice;
	}
	
	
	
	
}
