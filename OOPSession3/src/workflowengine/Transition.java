package workflowengine;
/**
 * Class name-Transition
 * 
 * @version 1.0
 * @author Jaya Bapna
 */
public class Transition {
		//Variables to store initial state and final state of a candidate.
		State initialState, finalState;
		
		//Variable to store current event.
		Event event;
		
		//method to get initial state
		public State getinitialState(){
			return initialState;
		}
		
		//method to get the final state
		public State getfinalState(){
			return finalState;
		}
		
		//method to get current event
		public Event getEvent(){
			return event;
		}
		
		//Constructor to set the values of the variables.
		public Transition(State initialState, State finalState, Event event){
			this.initialState = initialState;
			this.finalState = finalState;
			this.event = event;
		}
}

