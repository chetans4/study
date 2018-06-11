package entitites;

import facade.PrinterFacade;

/**
 * @author - Jaya Bapna
 * Class name - Entity
 * Below class represents an entity of the system.
 */
public class Entity {
	int priority;									//Stores the priority of the Entity
	String data;									//Stores the data to be printed by particular Entity
	
	public Entity(int priority, String data) {
		this.priority = priority;
		this.data = data;
	}
	
	/**
	 * Below function sends data of the entity to be printed
	 */
	public void sendDataToPrinter() {
		PrinterFacade.getInstance().addToPrint(this);
	}
	
	/**
	 * Below function compares the priority of the entities.
	 * @param entity
	 * @return 1 if priority is greater else returns -1
	 */
	public int compareTo(Entity entity) {
		return this.priority > entity.priority ? 1 : -1;
	}

}
