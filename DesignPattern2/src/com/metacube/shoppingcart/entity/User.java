package com.metacube.shoppingcart.entity;
/**
 * this class sets or gets the user entities like name etc
 * @author Jaya Bapna
 *
 */
public class User extends BaseEntity{
	private String userName;
	private String password;
	/**
	 * Constructor to set all the details of user
	 * @param username
	 * @param pass
	 */
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	/* Getters and Setters for all data variables */
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
