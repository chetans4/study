package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.enums.EntityType;
import com.metacube.shoppingcart.enums.OperationStatus;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;

public class ProductController {
	ProductFacade productFacade = ProductFacade.getInstance();
	public OperationStatus add(Product product) {
		return productFacade.addProduct(product);
	}
	
	public OperationStatus remove(int id) {
		return productFacade.removeProduct(id);
	}
	
	public OperationStatus update(int id, String name, double price) {
		return productFacade.updateProduct(id, name, price);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(){
		return (List<Product>) productFacade.getAllProducts();
	}
}
