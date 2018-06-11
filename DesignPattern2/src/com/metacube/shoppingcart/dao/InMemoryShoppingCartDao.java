package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
/**
 * In memory storage type DAO to perform operations on cart
 * 
 * @author Jaya Bapna
 *
 */
public class InMemoryShoppingCartDao implements BaseDao{
	Map<String , ShoppingCart> allCarts = new HashMap<>();
	
	/**
	 * gets the cart for the specified user
	 * 
	 * @param userID
	 */
	public ShoppingCart getCart(String userId) {
		return this.allCarts.get(userId);
	}
	/**
	 * returns all the carts present in memory
	 */
	public Map<String, ShoppingCart> getAllCart() {
		return this.allCarts;
	}
	/**
	 * adds a cart for the current user
	 * 
	 * @param cart
	 */
	public void addCart(ShoppingCart cart) {
		this.allCarts.put(cart.getUserId(), cart);
		
	}
	/**
	 * removes the user's cart from memory
	 * 
	 * @param userID
	 */
	public void removeCart(String userId) {
		allCarts.remove(userId);
	}
	/**
	 * Adds the product to cart of the user
	 * 
	 * @param userID
	 * @param product
	 * @param quantity
	 */
	public void addProductToCart(String userId, Product product, int quantity) {
		ShoppingCart cart = getCart(userId);
		Map<Product, Integer> itemList = cart.getItems();
		itemList.put(product, quantity);
		cart.setItems(itemList);
	}
	/**
	 * removes the product from user's cart
	 * 
	 * @param userID
	 * @param product
	 */

	public void removeProductFromCart(String uid, Product pro) {
		ShoppingCart cart = getCart(uid);
		Map<Product, Integer> itemList = cart.getItems();
		itemList.remove(pro);
		cart.setItems(itemList);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEntity(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEntity(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEntity(int id, Object... members) {
		// TODO Auto-generated method stub
		
	}

}
