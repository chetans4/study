package facade;

import java.util.ArrayList;
import java.util.List;

import entitites.Entity;

/**
 * @author - Jaya Bapna
 * Class name - PrinterFacade
 */
public class PrinterFacade {

	Heap<Entity> queue = new Heap<Entity>();							//Queue to store the entities.
	public List<String> listOfPrintingOrder = new ArrayList<String>();	//List to store the entities on the basis of their priorities.
	private static PrinterFacade printerFacadeInstance;
	
	private PrinterFacade() {
	}
	/**
	 * Below function creates Single Instance of PrinterFacade class
	 */
	public static PrinterFacade getInstance() {
		if( printerFacadeInstance == null) {
			printerFacadeInstance = new PrinterFacade();
		}
		return printerFacadeInstance;
	}
	
	/**
	 * Below function adds entity in the queue
	 * @param item
	 */
	public void addToPrint(Entity item) {
		queue.addItem(item);
	}
	
	/**
	 * Below function retruns the final list of order of printing on basis of priorities.
	 * @return list of order of printing
	 */
	public List<String> print(){
		while(!queue.isEmpty()) {
			listOfPrintingOrder.add(queue.removeMax().toString());
			print();
		}
		return listOfPrintingOrder;
	}
}
