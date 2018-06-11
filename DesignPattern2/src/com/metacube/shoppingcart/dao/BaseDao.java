package com.metacube.shoppingcart.dao;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
/**
 *interface name-BaseDao
 *
 *@version 1.0
 *author Jaya Bapna
 */
public interface BaseDao<T> {
	public List<T> getAll();
	public void addEntity(T entity);
	public void removeEntity(int id);
	public void updateEntity(int id, T... members);
}
