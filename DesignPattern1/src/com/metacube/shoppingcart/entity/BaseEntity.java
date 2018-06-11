package com.metacube.shoppingcart.entity;

import java.util.UUID;
/**
 * this class provide Id to all objects like product, user, shoppingCart etc
 * @author Jaya Bapna
 *
 */
public class BaseEntity {
	protected int id;

	public BaseEntity(){
		UUID uuid = UUID.randomUUID();
		this.id = Integer.parseInt(uuid.toString());
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
