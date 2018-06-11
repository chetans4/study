package com.metacube.shoppingcart.entity;
/**
 * this class sets or gets the user entities like name etc
 * @author Jaya Bapna
 *
 */
public class User extends BaseEntity{
	private String name;

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
