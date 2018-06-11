package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.Factory;
import com.metacube.shoppingcart.dao.InMemoryUserDao;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.enums.Database;
import com.metacube.shoppingcart.enums.EntityType;
import com.metacube.shoppingcart.enums.OperationStatus;
/**
 * All the business logic for the user resides here
 * (Singleton class)
 * 
 * @author Jaya Bapna
 *
 */
public class UserFacade {
	private static UserFacade userFacadeInstance;
	InMemoryUserDao inMemoryUserDao =(InMemoryUserDao) Factory.getInstance(EntityType.USER, Database.IN_MEMORY);	//Singleton object creation
	public static UserFacade getInstance(){
		if(userFacadeInstance == null){
			userFacadeInstance = new UserFacade();
		}
		return userFacadeInstance;
	}
	
	private UserFacade(){}
	

	/**
	 * this method returns the list of products came from inmemory storage
	 * @return - list of products
	 */
	public List<User> getAllUsers(){
		return inMemoryUserDao.getAll();
	}
	/**
	 * Performs a check if the user exists
	 * @param name
	 * @return true or false
	 */
	public boolean checkUser(String name){
		List<User> users = inMemoryUserDao.getAll();
		for(User u : users){
			if(name.equals(u.getUserName())){
				return true;
			}
		}
		return false;
    }
	/**
     * Add a new user in the memory
     * @param user
     */
	public OperationStatus addUser(User user){
		inMemoryUserDao.addEntity(user);	
		return OperationStatus.USER_ADDED_SUCCESSFULLY;
	}
	
	/**
	 * this method returns status of product after perform remove operation
	 * @param productId - id of product
	 * @return - status of product either removed or error
	 */
	public OperationStatus removeUser(int userId) {
		if( inMemoryUserDao.getUserId().contains(userId)){
			inMemoryUserDao.removeEntity(userId);
			return OperationStatus.USER_REMOVED_SUCCESSFULLY;
		} else {
			return OperationStatus.USER_NOT_FOUND;
		}
	}
	
	/**
	 * this method returns status of product after perform update operation
	 * @param productId - id of product
	 * @param productName - name of product
	 * @param price - price of product
	 * @return - status of product either update successful or error
	 */
	
	
	
	public OperationStatus updateUser(int id, String	userName, String password ){
		if(inMemoryUserDao.getUserId().contains(id)){
			inMemoryUserDao.updateEntity(id, userName, password);
			return OperationStatus.USER_UPDATED_SUCCESSFULLY;
		} else {
			return OperationStatus.USER_NOT_FOUND;
		}
	}
}
