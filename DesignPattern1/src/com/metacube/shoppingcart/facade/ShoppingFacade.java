package com.metacube.shoppingcart.facade;
/**
 * This class performs operation related to Shopping cart like total etc.
 * @author Jaya Bapna
 *
 */

public class ShoppingFacade {
	private static ShoppingFacade shoppingFacadeInstance;
	
	private ShoppingFacade(){};
	
	public static ShoppingFacade getInstance(){
		if(shoppingFacadeInstance == null){
			shoppingFacadeInstance = new ShoppingFacade();
		}
		return shoppingFacadeInstance;
	}
	
	
}
