package workflowengine;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import workflowengine.Event;
import workflowengine.State;
import workflowengine.Transition;
import workflowengine.Workflow;

public class TestWorkflow {

	Workflow w = new Workflow("MetaCube hiring process");

	@Before
	public void beginWorkflow(){
		
		State startState = new State("start");
		w.addState(startState);
		State hrReviewstate = new State("hr Review");
		w.addState(hrReviewstate);
		State l1_Interview_State = new State("l1 Interview");
		w.addState(l1_Interview_State);
		State l2_Interview_State = new State("l2 Interview");
		w.addState(l2_Interview_State);
		State management_Interview_State = new State("management Interview");
		w.addState(management_Interview_State);
		State offer_state = new State("offer");
		w.addState(offer_state);
		w.setCurrentState();
		
	}
	@Test
	public void test_selected_success() {
		Event event1 = new Event("hr process");
		
		w.transition_step(event1);
		Event event2 = new Event("hr ok");
		w.transition_step(event2);
		Event event3 = new Event("l1 ok");
		w.transition_step(event3);
		Event event4 = new Event("l2 ok");
		w.transition_step(event4);
		Event event5 = new Event("management ok");
		w.transition_step(event5);
		List<Transition> actual_object = w.getTransitionList();
		List<String> actual = new ArrayList<String>() ;
		actual.add("Selected");
		for(Transition se : actual_object) {
			actual.add(se.initialState.stateName + se.finalState.stateName + se.event.eventName);
		}
		List<String> expected = new ArrayList<String>();
		 expected.addAll(Arrays.asList("Selected","starthr Reviewhr process" ,"hr Reviewl1 Interviewhr ok" ,
				 "l1 Interviewl2 Interviewl1 ok" , "l2 Interviewmanagement Interviewl2 ok" , 
				 "management Interviewoffermanagement ok"));
		assertEquals(expected,actual);
		
		
	}

	
	@Test
	public void test_reject_success() {
		Event event1 = new Event("hr process");
		w.transition_step(event1);
		Event event2 = new Event("hr ok");
		w.transition_step(event2);
		Event event3 = new Event("l1 ok");
		w.transition_step(event3);
		Event event4 = new Event("l2 reject");
		w.transition_step(event4);
		
		List<Transition> actual_object = w.getTransitionList();
		List<String> actual = new ArrayList<String>() ;
		actual.add("rejected");
		for(Transition se : actual_object) {
			actual.add(se.initialState.stateName + se.finalState.stateName + se.event.eventName);
		}
		List<String> expected = new ArrayList<String>();
		 expected.addAll(Arrays.asList("rejected","starthr Reviewhr process" ,"hr Reviewl1 Interviewhr ok" ,
				 "l1 Interviewl2 Interviewl1 ok" , "l2 Interviewmanagement Interviewl2 reject"));
		assertEquals(expected,actual);	
	}
	
	@Test
	public void test_reject_failure() {
		Event event1 = new Event("hr process");
		w.transition_step(event1);
		Event event2 = new Event("hr ok");
		w.transition_step(event2);
		Event event3 = new Event("l1 ok");
		w.transition_step(event3);
		Event event4 = new Event("l2 reject");
		w.transition_step(event4);
		
		List<Transition> actual_object = w.getTransitionList();
		List<String> actual = new ArrayList<String>() ;
		actual.add("rejected");
		for(Transition se : actual_object) {
			actual.add(se.initialState.stateName + se.finalState.stateName + se.event.eventName);
		}
		List<String> expected = new ArrayList<String>();
		 expected.addAll(Arrays.asList());
		assertNotEquals(expected,actual);
		
		
	}
	@Test(expected=NullPointerException.class)
	public void test_exception() {
		Event event1 = new Event(null);
		w.transition_step(event1);
		Event event2 = new Event("hr ok");
		w.transition_step(event2);
		Event event3 = new Event("l1 ok");
		w.transition_step(event3);
		Event event4 = new Event("l2 reject");
		w.transition_step(event4);
		
		List<Transition> actual_object = w.getTransitionList();
		List<String> actual = new ArrayList<String>() ;
		actual.add("rejected");
		for(Transition se : actual_object) {
			actual.add(se.initialState.stateName + se.finalState.stateName + se.event.eventName);
		}
		List<String> expected = new ArrayList<String>();
		 expected.addAll(Arrays.asList());
		assertNotEquals(expected,actual);
		
		
	}
	
}
