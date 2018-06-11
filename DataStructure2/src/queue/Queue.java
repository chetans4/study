package queue;

/*
 * Class name- Queue
 * This class implements all the functions of queue using array.
 */
public class Queue {
	int size;
	int[] queueArray = new int[25];
	int front = -1, rear = -1;						//Points to the front and rear element in the queue.
	
	/**
	 * Below function inserts element in queue.
	 * @param element
	 */
	public void enqueue( int element ) {
		if ( rear == size-1 ) {
			System.out.println("Queue overflow");
		}
		else if ( rear == -1 ) {
				front = 0;
				rear = 0;
				queueArray[rear] = element;
			}
	   else {
				 rear++;
				 queueArray[rear] = element;
			} 
		}
	
	/**
	 * Below function removes the front element from the queue.
	 * @return popped element if queue is not empty otherwise -1
	 */
	public Object dequeue() {
		if (front == - 1 || front > rear)
	    {
			System.out.println("Queue underflow");
			return -1;
	    }
		else {
				int x =queueArray[front];
				front = front + 1;
				return x;
		}
	}
	
	/**
	 * Below function removes all the element from the queue.
	 */
	public void makeEmpty() {
		for ( int i = 0; i <= rear; i++) {
			dequeue();
		}
	}
	
	/**
	 * Below funtion returns front element of queue.
	 * @return front element
	 */
	public Object getFront() {
		return queueArray[front];
	}
	
	/**
	 * Below function displays all elements in queue.
	 */
	public void display() {
		for( int i = front; i <= rear; i++) {
			System.out.println(queueArray[i]);
		}
	}
}
