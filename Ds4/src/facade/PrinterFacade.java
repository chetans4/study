package facade;

import java.util.ArrayList;
import java.util.List;

import entities.Entity;

/**
 * this class performs the prinitng operation according to 
 * the queue.
 * @author Akshita Dixit
 *
 */
public class PrinterFacade {

	private static PrinterFacade printerFacade;
	private Heap<Entity> queue = new Heap<>();
	private List<String> printPool = new ArrayList<>();
	
	/**
	 * declaring a singleton object
	 * @return object of PrinterFacade
	 */
	public static PrinterFacade getInstance() {
		if(printerFacade == null) {
			printerFacade = new PrinterFacade();
		}
		return printerFacade;
	}
	
	/**
	 * creating private constructor to keep it singleton
	 */
	private PrinterFacade() {
	}
	
	/**
	 * adds the job to print based on priority in the heap
	 * @param item - item to add in a queue 
	 */
	public void addToPrint(Entity item) {
		
		queue.addItem(item);
	}
	
	/**
	 * picks up the job according to the priority and prints them
	 * @return printpool
	 */
	public List<String> print() {
		while(!queue.isEmpty()) {
			printPool.add(queue.removeMax().toString());
			print();
		}
		return printPool;
	}
}
