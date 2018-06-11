package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.enums.Database;
import com.metacube.shoppingcart.enums.EntityType;
/**
 * This class is used to return storage instance type 
 * like inmemory or database type
 * @author Jaya Bapna
 *
 */

public class Factory{
	
	private static BaseDao obj;
	public static BaseDao getInstance(EntityType entityType, Database dbName) {
		if(dbName == Database.IN_MEMORY){
			switch(entityType){
				case PRODUCT : obj = new InMemoryProductDao();
							return obj;
				case USER : obj = new InMemoryUserDao();
							return obj;
				case SHOPPING_CART : obj = new InMemoryShoppingCartDao();
							return obj;
			}
		}
	return null;	
	}
	private Factory() {}
}
