package survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class name-ReportGeneration
 * 
 * @version 1.0
 * @author Jaya Bapna
 */
/*
 * A class to generate report on the basis of choice of Participants.
 */
public class ReportGeneration {
	ArrayList<String> listOfAnswrsById = new ArrayList<String>();
	FileOperations reportFile = new FileOperations();
	/*
	 * Below function analysis the overall rating of, Single Select(1/2/3/4/5)
	 */
	public void analyzeSingleSelectOptions(int noOfParticipants, int countOption[]){
		int[] percentage = new int[noOfParticipants];
		for(int i=0; i< countOption.length; i++){
				percentage[i] = (countOption[i]*100)/noOfParticipants;
		}
		reportFile.writeToFile1(percentage);	
	}
	
	/*
	 * Below function analysis the answers of Participant
	 */
	public void analyzeMultipleSelectOptions(ArrayList<Participants> listOfParticipants){
		reportFile.writeTMultipleSelectToFile(listOfParticipants);
	}
	
}
