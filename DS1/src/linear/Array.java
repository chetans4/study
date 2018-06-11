package linear;

import java.util.Scanner;

/**
 * Class name-Array
 * 
 * @version 1.0
 * @author Jaya Bapna
 */
/*
 * This class implements all the methods of List using array.
 */
public class Array {
	static int[] array = new int[15];
	static int i = 0;
	
	/**
	 * Below function adds the element in the list.
	 * @param element
	 */
	void addElement(int element) {
		if ( i == array.length ) {
			int array2[] = new int[array.length];
			System.arraycopy(array, 0, array2, 0, array2.length);
		}
		else {
			array[i++] = element;
		}
	}
	
	/**
	 * Below function adds the element at particular location.
	 * @param element
	 * @param location
	 */
	void addElementAtLocation (int element, int location) {
		for ( int j = i; j >= location; j--) {
			array[j+1] = array[j];
		}
		array[location] = element;
	}
	
	/**
	 * Below function retrieves the element at particular location.
	 * @param location
	 * @return
	 */
	int elementAtLocation(int location) {
		return array[location];
	}
	
	/**
	 * Below function searches for the element in the list.
	 * @param element
	 */
	void searchElement(int element) {
		int flag = -1;
		for (int j = 0; j < i; j++ ) {
			if ( array[j] == element) {
				System.out.println("Element found at : "+(j+1));
			}
		}
		
	}
	
	/**
	 * Below function removes the element from specified location.
	 * @param location
	 */
	void removeElementAtLocation(int location) {
		for ( int j = 0; j <= i; j++) {
			if( j == location ){
				for ( int k = j; k <=i; k++) {
					array[k] = array[k+1];
				}
				i--;
			}
		}
		display();
	}
	
	/**
	 * Below function removes the element from the list.
	 * @param element
	 */
	void removeElement(int element) {
		for ( int j = 0; j <= i; j++) {
			if (array[j] == element) {
				for ( int k = j; k <i; k++) {
					array[k] = array[k+1];
				}
				i--;
			}
		}
		display();
	}
	
	/**
	 * Below function removes all the elements from the list.
	 * @param array
	 */
	void removeAllElements(int array[]) {
		for (int j = 0; j < i; j++) {
			removeElement(array[j]);
		}
	}
	
	/**
	 * Below function reverse the list.
	 * @return
	 */
	int[] reverseList() {
		int size =  i;
		System.out.println(size);
		int reverseArray[] = new int[size];
		for ( int  j = 0; j < i; j++) {
			reverseArray[j] = array[--size];
			
		}
		return reverseArray;
	}
	
	/**
	 * Below function sorts the list.
	 * @return
	 */
	int[] sortList() {
		int []sortedArray = new int[i];
		System.arraycopy(array, 0, sortedArray, 0, i);
		int temp;
		for(int j = 0; j < sortedArray.length; j++) {  
            for(int k = 1; k < sortedArray.length; k++) {  
                     if(array[k-1] > sortedArray[k]) {   
                            temp = sortedArray[k-1];  
                            sortedArray[k-1] = sortedArray[k];  
                            sortedArray[k] = temp;  
                    }
            }
		} 
		return sortedArray;
	}
	
	void display() {
		for (int j = 0; j < i; j++){
			System.out.println(array[j]);
		}
	}
	
	public static void main(String args[]) {
		Array arrayInstance = new Array();
		Scanner scan = new Scanner(System.in);
		int element, location;
		do{
			int choice;
			System.out.println("***Menu***");
			System.out.println("1. Add element ");
			System.out.println("2. Adding element at particular location");
			System.out.println("3. Search element");
			System.out.println("4. Retrieving location of element");
			System.out.println("5. Removing element by location");
			System.out.println("6. Removing element");
			System.out.println("7. Clear list");
			System.out.println("8. Reverse list");
			System.out.println("9. Sort list");
			System.out.println("Enter ur choice");
			choice = scan.nextInt();
			switch(choice) {
			case 1: System.out.println("Enter element");
					element = scan.nextInt();
					arrayInstance.addElement(element);
					break;
			case 2: System.out.println("Enter element");
					element = scan.nextInt();
					System.out.println("Enter location");
					location = scan.nextInt();
					arrayInstance.addElementAtLocation(element, location);
					break;
			case 3:System.out.println("Enter location");
				   location = scan.nextInt();
				   int result = arrayInstance.elementAtLocation(location);
				   System.out.println("Element at location : "+result);
				   break;
			case 4:System.out.println("Enter element");
				   element = scan.nextInt();
				   arrayInstance.searchElement(element);
				   break;
			case 5:System.out.println("Enter location");
				   location = scan.nextInt();
				   arrayInstance.removeElementAtLocation(location);
				   break;
			case 6:System.out.println("Enter element");
			   	   element = scan.nextInt();
			   	   arrayInstance.removeElement(element);
			   	   break;
			case 7: break;
			case 8:int resultantArray[] = arrayInstance.reverseList();	
				   for (int i = 0; i < resultantArray.length; i++) {
					   System.out.println(resultantArray[i]);
				   }
				   break;
			case 9:int sortedArray[] = arrayInstance.sortList();	
			       for (int i = 0; i < sortedArray.length; i++) {
				       System.out.println(sortedArray[i]);
			       } 
			       break;
		   default:
					System.out.println("Please enter a valid option");
			}
	}while(true);
	}
}
