package entities;

import facade.PrinterFacade;

/**
 * Base class for all the types of entities 
 * @author Akshita Dixit
 */
public class Entity implements Comparable<Entity>{

	private int priority;
	private String dataToPrint;
	
	/**
	 * constructor  to initialize data members
	 * @param priority - priority of particular entity
	 * @param data - data to print
	 */
	public Entity(int priority, String data) {
		
		this.priority = priority;
		this.dataToPrint = data;
	}
	
	/**
	 * sends the entity details to the printer
	 */
	public void sendToPrinter() {
		
		PrinterFacade.getInstance().addToPrint(this);
	}

	/**
	 * Implementing compareTo method to compare the objects based on the priority 
	 * @param entity - object of entity
	 */
	@Override
	public int compareTo(Entity entity) {
		
		return this.priority > entity.priority ? 1 : -1;
	}

	/**
	 * overriding the default toString method based on our requirements
	 */
	@Override
	public String toString() {
		
		return this.dataToPrint;
	}
	
}
