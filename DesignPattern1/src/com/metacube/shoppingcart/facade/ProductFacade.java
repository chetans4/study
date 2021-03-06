package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryProductDao;
import com.metacube.shoppingcart.dao.ProductFactory;
import com.metacube.shoppingcart.dao.DatabaseEnum;
import com.metacube.shoppingcart.dao.StatusEnum;
import com.metacube.shoppingcart.entity.Product;

/**
 * This class performs operation for insert, remove, update, and etc
 * @author Jaya Bapna
 *
 */

public class ProductFacade {
	private static ProductFacade productFacadeInstance;
	
	InMemoryProductDao inMemoryProductDao =(InMemoryProductDao) ProductFactory.getInstance(DatabaseEnum.IN_MEMORY);
	
	/**
	 * this method is used to return the object of this class
	 * @return - object of this class (singleton class)
	 */
	public static ProductFacade getInstance() {
		if (productFacadeInstance == null) {
			productFacadeInstance = new ProductFacade();
		}
		
		return productFacadeInstance;
	}
	
	/**
	 * private constructor to restrict creating object using new keyword
	 */
	private ProductFacade() {}
	
	/**
	 * this method returns the list of products came from inmemory storage
	 * @return - list of products
	 */
	public List<Product> getAll(){
		return inMemoryProductDao.getAll();
	}

	/**
	 * this method returns status of product after perform adding operation
	 * @param product - product object
	 * @return - status of added product
	 */
	public StatusEnum addProduct(Product product) {
		inMemoryProductDao.addProduct(product);	
		return StatusEnum.PRODUCT_ADDED_SUCCESSFULLY;
	}
	
	/**
	 * this method returns status of product after perform remove operation
	 * @param productId - id of product
	 * @return - status of product either removed or error
	 */
	public StatusEnum removeProduct(int productId) {
		if( inMemoryProductDao.getProductId().contains(productId)){
			inMemoryProductDao.removeProduct(productId);;
			return StatusEnum.PRODUCT_REMOVED_SUCCESSFULLY;
		} else {
			return StatusEnum.PRODUCT_NOT_FOUND;
		}
	}
	
	/**
	 * this method returns status of product after perform update operation
	 * @param productId - id of product
	 * @param productName - name of product
	 * @param price - price of product
	 * @return - status of product either update successful or error
	 */
	
	public StatusEnum updateProduct(int productId, String productName, double price ){
		if(inMemoryProductDao.getProductId().contains(productId)){
			inMemoryProductDao.updateProduct(productId, productName, price);
			return StatusEnum.PRODUCT_UPDATED_SUCCESSFULLY;
		} else {
			return StatusEnum.PRODUCT_NOT_FOUND;
		}
	}
}
