package workflowengine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Class name-Workflow
 * 
 * @version 1.0
 * @author Jaya Bapna
 */
public class Workflow {
	int stateCounter = 0;												//counter to fetch state from linked list of state objects
	State currentState;													//state object denoting current state
	String wokflowName;													//variable to store workflow name
	List<Event> listOfEvents = new ArrayList<Event>();					//list of event type objects
	List<Transition> listOfTransition = new ArrayList<Transition>();	//list of transition type objects
	LinkedList<State> listOfStates = new LinkedList<State>();			//linked list of state objects
	
	public Workflow(String workflowName){
		this.wokflowName = workflowName;
	}
	
	public LinkedList<State> getState_list() {
		return listOfStates;
	}

	public List<Transition> getTransitionList(){
		return this.listOfTransition;
	}
	
	public List<Event> getEvent_list() {
		return listOfEvents;
	}
	
	public void setCurrentState(){
		this.currentState = listOfStates.get(stateCounter);
	}
	
	/**
	 * method that adds the event in event list and manages the next move
	 * @param  the current event that occurred
	 */
	public void transition_step(Event event){
		listOfEvents.add(event);
		checkEvent(event, event.eventName);
	}
	
	/**
	 * method that checks if the event has reject or ok keyword in it
	 * @param event object of event class in which variable ok or reject have to 
	 * be changed
	 * @param eventStatus name of the event to be checked
	 */
	public void checkEvent(Event event, String eventStatus){
		String status = null;
		event.changeStatus(eventStatus);
		if(event.isReject()){
			status = "Rejected";
			Transition transition = new Transition(currentState, currentState, event);
			listOfTransition.add(transition);
		}
		if(event.isOk()){
			status = "Ok";
			currentState = listOfStates.get(++stateCounter);
			Transition transition = new Transition(listOfStates.get(stateCounter-1), currentState, event);
			listOfTransition.add(transition);
		}
	}
	
	/**
	 * method to add state to the list
	 * @param state - new state
	 */
	public void addState(State state) {
		listOfStates.add(state);
	}
}
