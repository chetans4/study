package com.metacube;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

/**
 * Class name-ClientHandler
 * 
 * @version 1.0
 * @author Jaya Bapna
 */

/*
 * A class to handle client request.
 */

public class ClientHandller {
	public static void main(String args[]) throws RemoteException, ServiceException{
		TemperatureServiceLocator serviceLocator = new TemperatureServiceLocator();
		System.out.println(serviceLocator.getTemperature().tempConverter(41.0));
	}
}
