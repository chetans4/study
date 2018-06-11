package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.enums.EntityType;
import com.metacube.shoppingcart.enums.OperationStatus;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;

public class UserController<T> {
	UserFacade userFacade = UserFacade.getInstance();
	
	public OperationStatus add(User user) {
		return userFacade.addUser(user);
	}
	
	public OperationStatus remove(int id) {
		return userFacade.removeUser(id);
	}
	public OperationStatus update(int id, String name, String password) {
		return userFacade.updateUser(id, name, password);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		return (List<User>) userFacade.getAllUsers();
	}
}
