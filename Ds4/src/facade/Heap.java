package facade;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap Class (Implemented using ArrayList)
 * @author Akshita Dixit
 * @param <T> - generic parameter
 */
public class Heap<T> {

	private List<T> heapTree = new ArrayList<T>();
	
	/**
	 * appends the incoming item to the end of array
	 * and calls heapify to sort it.
	 * @param item - item to be added into heap
	 */
	public void addItem (T item) {
		
		heapTree.add(item);
		heapify(heapTree.size()-1);
	}
	
	/**
	 * Sorts the Heap from bottom to top using MaxHeap property
	 * @param position - position from where to heapify
	 */
	public void heapify(int position) {
		
		if(position != 0 && compare( heapTree.get( position ), heapTree.get( ( position - 1 ) / 2 ) ) > 0) {
			swapItems(position, (position - 1 ) / 2);
			heapify( ( position - 1 ) / 2);
		}
	}
	
	/**
	 * compare method, used to compare two items, using either the compareTo method implemented
	 * by the calling class, or converting the item to string
	 * @param item1 - item 1 to compare
	 * @param item2 - item 2 to compare
	 * @return compared result
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int compare(T item1, T item2){
		if(item1 instanceof Comparable){
			return ((Comparable) item1).compareTo(item2);
		}
		else{
			return item1.toString().compareTo(item2.toString());
		}
	}
	
	/**
	 * swap method
	 * @param position1 - position 1 to swap element
	 * @param position2 - position 2 to swap element
	 */
	public void swapItems(int position1, int position2) {
		T item = heapTree.get(position1);
		heapTree.set(position1,heapTree.get(position2));
		heapTree.set(position2,item);
	}
	
	/**
	 * removes the item from top, then copies the last element to root and then reheapifies the tree
	 * @return removed element
	 */
	public T removeMax() {
		T element = heapTree.get(0);
		heapTree.set(0, heapTree.get(heapTree.size() - 1));
		heapTree.remove(heapTree.size() - 1);
		reHeapify(0);
		return element;
	}
	
	/**
	 * sorts the tree from top to bottom after removal of the node using maxHeap property
	 * @param nodeIndex - index of node
	 */
	private void reHeapify(int nodeIndex) {
		
		if(nodeIndex < heapTree.size()) {
			int left = 2 * nodeIndex + 1;
			int right = 2 * nodeIndex + 2;
			
			if(left < heapTree.size() && right < heapTree.size() && compare( heapTree.get(left), heapTree.get(right) ) < 0 ) {
				checkParent(nodeIndex, right);
				
			} else if(left < heapTree.size() ) {
				checkParent(nodeIndex, left);
			}
		}
	}
	
	/**
	 * compares the parent and child, if the child is greater, reheapifies after swapping the two
	 * @param parentIndex - index of parent
	 * @param childIndex - index of child
	 */
	private void checkParent(int parentIndex, int childIndex) {
		
		if(compare(heapTree.get(parentIndex), heapTree.get(childIndex)) < 0 ) {
			swapItems(parentIndex, childIndex);
			reHeapify(childIndex);
		}
	}
	
	/**
	 * returns true if tree is empty
	 * @return true or false
	 */
	public boolean isEmpty() {
		return heapTree.size() == 0;
	}
}
