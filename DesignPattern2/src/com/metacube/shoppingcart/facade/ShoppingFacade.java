package com.metacube.shoppingcart.facade;

import java.util.Map;
import java.util.Map.Entry;

import com.metacube.shoppingcart.dao.Factory;
import com.metacube.shoppingcart.dao.InMemoryShoppingCartDao;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.enums.Database;
import com.metacube.shoppingcart.enums.EntityType;
import com.metacube.shoppingcart.enums.OperationStatus;

/**
 * This class performs operation related to Shopping cart like total etc.
 * @author Jaya Bapna
 *
 */

public class ShoppingFacade {
	private static ShoppingFacade shoppingFacadeInstance;
	InMemoryShoppingCartDao shoppingCartDao =(InMemoryShoppingCartDao) Factory.getInstance(EntityType.SHOPPING_CART, Database.IN_MEMORY);
	
	private ShoppingFacade(){};
	
	public static ShoppingFacade getInstance(){
		if(shoppingFacadeInstance == null){
			shoppingFacadeInstance = new ShoppingFacade();
		}
		return shoppingFacadeInstance;
	}
	/**
	 * gets the list of products in user's cart
	 * 
	 * @param userID
	 */
	public Map<Product, Integer> getList(String Uid){
		Map<Product, Integer> productList = shoppingCartDao.getCart(Uid).getItems();
		return productList;
	}
	/**
	 * returns total price of the cart
	 * 
	 * @param userID
	 */
	public float getTotalPrice (String Uid){
		Map<Product, Integer> productList = getList(Uid);
		float tot = 0.0f;
		for( Entry<Product, Integer> m: productList.entrySet()){
			tot += (m.getKey().getPrice()*m.getValue());
		}
		return tot;
	}
	/**
	 * checks if a cart exist, if it doesn't adds one
	 * 
	 * @param userID
	 * @param cart
	 */
	public Map<Product, Integer> addCart(String Uid, ShoppingCart cart) {
		
		if(shoppingCartDao.getCart(Uid) == null){
			cart.setUserId(Uid);
			shoppingCartDao.addCart(cart);
			return getList(Uid);
		} else {
			return getList(Uid);
		}
			
	}
	/**
	 * checks if a cart exist, if it does, it removes it.
	 * 
	 * @param userID
	 */
	public OperationStatus removeCart(String Uid) {
		if( shoppingCartDao.getCart(Uid) != null ){
			shoppingCartDao.removeCart(Uid);
			return OperationStatus.CART_REMOVED_SUCCESSFULLY;
		} else {
			return OperationStatus.ERROR;
		}
	}
	/**
	 * checks if a cart exist, it also checks if the entered product ID exists, if it does, it adds one
	 * 
	 * @param userID
	 * @param productID
	 * @param quantity
	 */
	public OperationStatus addToCart(String Uid, int productId, int quantity ){
		if(shoppingCartDao.getCart(Uid) != null){
			Product pro = ProductFacade.getInstance().getProduct(productId);
			shoppingCartDao.addProductToCart(Uid, pro, quantity);
			return OperationStatus.ADDED_TO_CART;
		} else {
			return OperationStatus.ERROR;
		}
	}
	/**
	 * checks if a cart exist, it also checks if the entered product ID exists in the cart, if it does, it removes the product
	 * 
	 * @param userID
	 * @param productID
	 */
	public OperationStatus removeFromCart(String Uid, int productId ){
		if(shoppingCartDao.getCart(Uid) != null){
			Product pro = ProductFacade.getInstance().getProduct(productId);
			shoppingCartDao.removeProductFromCart(Uid, pro);
			return OperationStatus.REMOVED_FROM_CART;
		} else {
			return OperationStatus.ERROR;
		}
	}
	/**
	 * checks if the user is present in the system
	 * 
	 * @param userID
	 */
	public boolean checkUser(String uid) {
		return UserFacade.getInstance().checkUser(uid);
	}
	
}
