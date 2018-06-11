package survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class name-SurveyApplication
 * 
 * @version 1.0
 * @author Jaya Bapna
 */
//Driver Class
public class SurveyApplication {
	static ArrayList<Participants> listOfParticipants = new ArrayList<Participants>();
	public static void main(String args[]){
		
		int []countOptions = new int[5];    								//To store the count of selected options
		
		FileOperations fileRead = new FileOperations();
		fileRead.readFile();
		
		Participants[] participantObject = new Participants[5];			  //Represents total number of participants
		int noOfParticipants = participantObject.length;				  
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < participantObject.length; i++){
			participantObject[i] = new Participants();
		}
		
		int i = 0, j = 0;
		
		
		FileOperations fo = new FileOperations();
		
		ArrayList<Question> listOfQuestionObject = fo.getListOfQuestions();		
		int size = listOfQuestionObject.size();							//Total number of Questions in survey
		String [][] answersOfParticipants = new String[noOfParticipants][size];
		
		while(i < noOfParticipants) {
			ArrayList<String> listOfAnswers = new ArrayList<String>();
			System.out.println("Hello Participant "+(i+1));
			for(j = 0; j < size; j++) {
				Question questionObject = listOfQuestionObject.get(j);
				System.out.println(questionObject.questionHeading);
				
				if(!questionObject.listOfOptions.isEmpty()){
					for(String option : questionObject.listOfOptions){
						System.out.println(option);
					}
				}
				
				
				answersOfParticipants[i][j] = scan.nextLine();
				if(questionObject.type.equals("Single select")){
					if(answersOfParticipants[i][j].equals("1")){
						countOptions[0]++;
					}
					else if(answersOfParticipants[i][j].equals("2")){
						countOptions[1]++;
					}
					else if(answersOfParticipants[i][j].equals("3")){
						countOptions[2]++;
					}
					else if(answersOfParticipants[i][j].equals("4")){
						countOptions[3]++;
					}
					else if(answersOfParticipants[i][j].equals("5")){
						countOptions[4]++;
					}
					else{
						//Incorrect Option then print the same Question again
					}
				}
			}
			listOfAnswers.addAll(Arrays.asList(answersOfParticipants[i]));
			participantObject[i].setAnswerByParticipantId(i,listOfAnswers);
			listOfParticipants.add(participantObject[i]);
			i++;
		}
		ReportGeneration report = new ReportGeneration();
		report.analyzeSingleSelectOptions(noOfParticipants,countOptions);
		report.analyzeMultipleSelectOptions(listOfParticipants);
		Collections.sort(listOfQuestionObject);
		System.out.println("Questions After Sorting");
		for (Question q: listOfQuestionObject)
        {
            System.out.println(q.questionId+" "+q.type+" "+q.questionHeading);
                
	}
	}
}

