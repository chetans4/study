package com.metacube.counselling;

import java.util.Scanner;

/**
 * Class name-CounsellingProcess
 * 
 * @version 1.0
 * @author Jaya Bapna
 */
public class CounsellingProcess {
	public static void main(String args[]) {
		CandidateList queueInstance = CandidateList.getInstance();
		Scanner scan = new Scanner(System.in);
		do {
			int choice;
			System.out.println("***Menu***");
			System.out.println("1. Add candidate ");
			System.out.println("2. Remove candidate");
			System.out.println("3. Display");
			System.out.println("4. Allocate College");
			choice = scan.nextInt();
			switch(choice) {
				case 1: Candidate candidate = new Candidate();
					    System.out.println("Enter candidate Name"); 
					    candidate.name = scan.next();
					    System.out.println("Enter candidate rank");
					    candidate.rank = scan.nextInt();
					    queueInstance.enqueue(candidate);
					    break;
				case 2: System.out.println(queueInstance.dequeue());
						break;
				case 3: queueInstance.display();
						break;
				case 4: AllocatedCollege allocation = new AllocatedCollege();
						allocation.AllocationOfCollege();
						break;
			    default: System.out.println("Please enter a valid option");
			}	
		}while(true);
	}
}	
