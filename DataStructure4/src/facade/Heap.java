package facade;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author - Jaya Bapna
 * Class name - Heap
 */
public class Heap<T> {
	List<T> listOfHeapTree = new ArrayList<T>();		//List to store entities    
	
	/**
	 * Below function adds entity to the list.
	 * @param item
	 */
	public void addItem(T item) {
		listOfHeapTree.add(item);
	}
	
	/**
	 * Below function heapify or sorts the entities in the list on the basis of priority.
	 * @param position
	 */
	public void heapify(int position) {
		if(position != 0 && compare( listOfHeapTree.get( position ), listOfHeapTree.get( ( position - 1 ) / 2 ) ) > 0) {
			swapItems( position, ( position - 1) / 2);
			heapify( ( position - 1 ) / 2);
		}
	}
	
	/**
	 * Below function compare the entities on the basis of their priorities.
	 * @param item1
	 * @param item2
	 */
	public int compare(T item1, T item2){
		if(item1 instanceof Comparable){
			return ((Comparable) item1).compareTo(item2);
		}
		else{
			return item1.toString().compareTo(item2.toString());
		}
	}
	
	/**
	 * Below functions swaps the value at two positions in the list.
	 * @param position1
	 * @param position2
	 */
	public void swapItems(int position1, int position2) {
		T item = listOfHeapTree.get(position1);
		listOfHeapTree.set(position1, listOfHeapTree.get(position2));
		listOfHeapTree.set(position2, item);
	}
	
	/**
	 * below function removes the maximum heap from the list of heap.
	 * @return maximum heap in the list.
	 */
	public T removeMax() {
		T item = listOfHeapTree.get(0);
		listOfHeapTree.set(0, listOfHeapTree.get(listOfHeapTree.size() - 1));
		listOfHeapTree.remove(listOfHeapTree.size() - 1);
		reHeapify(0);
		return item;
	}
	
	/**
	 * Below function reheapify the heap.
	 * @param nodeIndex
	 */
	public void reHeapify(int nodeIndex) {
		
		if(nodeIndex < listOfHeapTree.size()) {
			int left = 2 * nodeIndex + 1;
			int right = 2 * nodeIndex + 2;
				if(left < listOfHeapTree.size() && right < listOfHeapTree.size() && compare( listOfHeapTree.get(left), listOfHeapTree.get(right) ) < 0 ) {
					checkParent(nodeIndex, right);
					
				} 
				else if(left < listOfHeapTree.size() ) {
					checkParent(nodeIndex, left);
				}
		}
	}
	
	/**
	 * Below functions checks whether given node is parent node or not.
	 * @param parentIndex
	 * @param childIndex
	 */
	public void checkParent(int parentIndex, int childIndex) {
		if( compare(listOfHeapTree.get(parentIndex), listOfHeapTree.get(childIndex)) < 0) {
			swapItems(parentIndex, childIndex);
			reHeapify(childIndex);
		}
	}
	
	/**
	 * Below function checks if the list of heap is empty or not.
	 * @return
	 */
	public boolean isEmpty() {
		return listOfHeapTree.size() == 0;
	}
}
