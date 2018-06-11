package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.metacube.shoppingcart.entity.Product;

/**
 * This class performs basic function for inMemory storage
 * @author Jaya Bapna
 *
 */
public class InMemoryProductDao implements BaseDao {
	
	 Map<Integer , Product> allProducts = new HashMap<>();

	 
	protected InMemoryProductDao() {
		super();
	}
	/**
	 * this method returns list of products
	 * @return - list of products
	 */
	public List<Product> getAll() {
		List<Product> list = new ArrayList<Product>(allProducts.values());
		
		return list;
		
	}
	public Set<Integer> getProductId(){
		Set<Integer> setOfProductId = allProducts.keySet();
		return setOfProductId;
	}
	/**
	 * This method add the product in the list
	 * @param product - product object
	 */
	@Override
	public void addProduct(Product product) {
		this.allProducts.put(product.getId(), product);
	}
	
	/**
	 * This method removes the product using product id
	 * @param productId - id of product
	 */
	@Override
	public void removeProduct(int productId) {
		allProducts.remove(productId);
	}

	/**
	 * this method updates the product
	 * @param productId - id of product
	 * @param productName - name of product
	 * @param price - price of product
	 */
	@Override
	public void updateProduct(int productId, String productName, double price) {
		Product product = allProducts.get(productId);
		product.setName(productName);
		product.setPrice(price);
	}
	
}