package com.metacube.counselling;

/*
 * Class name- CandidateList
 * Below class stores list of candidates in the queue.
 */
public class CandidateList {
	Candidate[] queueOfCandidate = new Candidate[150];					//Queue to store candidate details.
	int front = -1, rear = -1;											//Points to the front and rear element of queue.
	
	static private CandidateList candidateListInstance;
	private CandidateList() {}
	
	/**
	 * Below function creates singleton object.
	 * @return object if not created once.
	 */
	public static CandidateList getInstance() {
		if(candidateListInstance == null) {
			candidateListInstance = new CandidateList();
		}
		return candidateListInstance;
	}
	
	/**
	 * Below function adds candidate in the queue.
	 * @param candidate
	 */
	public void enqueue( Candidate candidate ) {
		if ( rear == queueOfCandidate.length-1 ) {
			System.out.println("Queue overflow");
		}
		else if ( rear == -1 ) {
				front = 0;
				rear = 0;
				queueOfCandidate[rear] = candidate;
				
			}
	   else {
				 rear++;
				 queueOfCandidate[rear] = candidate;
			} 
		sortQueue();
	}
	
	/**
	 * Below function sorts the candidates on the basis of their rank.
	 */
	public void sortQueue() {
		Candidate candidate;
		for( int i = front; i <= rear; i++) {
			 for (int j = front; j < rear; j++) {
				 if(queueOfCandidate[j].rank > queueOfCandidate[j+1].rank) {
					 candidate = queueOfCandidate[j];
					 queueOfCandidate[j] = queueOfCandidate[j+1];
					 queueOfCandidate[j+1] = candidate;
				 }
			 }
		}
	}
	
	/**
	 * Below function removes candidate from the queue.
	 * @return popped candidate
	 */
	public Candidate dequeue() {
		if (front == - 1 || front > rear)
	    {
			System.out.println("Queue underflow");
			return null;
	    }
		else {
				Candidate candidate = queueOfCandidate[front];
				front = front + 1;
				return candidate;
		}
	}
	
	/**
	 * Below function display all the candidates.
	 */
	public void display() {
		sortQueue();
		for( int i = front; i <= rear; i++) {
			System.out.println(queueOfCandidate[i].name+" "+queueOfCandidate[i].rank);
		}
	}
}
