package survey;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class name-Participants
 * 
 * @version 1.0
 * @author Jaya Bapna
 */
/*
 * A class represents Participant who will go through survey.
 */
public class Participants {
	//A map between Participant Id and their corresponding answers.
	HashMap<Integer, ArrayList<String>> mapOfIdAndListOfAnswers = new HashMap<Integer, ArrayList<String>>();
	
	public void setAnswerByParticipantId(int participantID, ArrayList<String> listOfAnswers ) {
		mapOfIdAndListOfAnswers.put(participantID, listOfAnswers);
	}

}
