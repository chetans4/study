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
	public void addEntity(Object product) {
		this.allProducts.put(((Product)product).getId(), (Product)product);
	}
	
	/**
	 * This method removes the product using product id
	 * @param productId - id of product
	 */
	@Override
	public void removeEntity(int productId) {
		allProducts.remove(productId);
	}

	/**
	 * this method updates the product
	 * @param productId - id of product
	 * @param productName - name of product
	 * @param price - price of product
	 */
	@Override
	public void updateEntity(int productId, Object...members ) {
		Product product = allProducts.get(productId);
		product.setName(members[0].toString());
		product.setPrice(Double.parseDouble(members[1].toString()));
	}
	
}