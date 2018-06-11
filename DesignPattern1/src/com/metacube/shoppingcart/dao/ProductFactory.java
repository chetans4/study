package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.metacube.shoppingcart.entity.Product;
/**
 * This class is used to return storage instance type 
 * like inmemory or database type
 * @author Jaya Bapna
 *
 */
public class ProductFactory{
	
	private static BaseDao baseDao;
	public static BaseDao getInstance(DatabaseEnum dbName) {
		switch(dbName){
		case IN_MEMORY : baseDao = new InMemoryProductDao();
						return baseDao;
		case SQL : return null;
		}
	return null;	
	}
	private ProductFactory() {}
}
