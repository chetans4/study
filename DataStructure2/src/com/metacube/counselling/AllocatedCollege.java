package com.metacube.counselling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class name- AllocatedCollege
 * @author Jaya Bapna
 * This class allocates college to candidates.
 */
public class AllocatedCollege {
	/**
	 * Below function allocates college to students on basis of their ranks.
	 */
	public void AllocationOfCollege() {
		CollegeList colleges = new CollegeList();
		CandidateList candidates = CandidateList.getInstance();
		Map<College, List<Candidate>> mapOfCandidateAndCollege = new HashMap();			//Map to store College and List of students who have been allocated the college.
		int i = 0, flag = 0;
		
		while( i < colleges.listOfColleges.size())  {
			List<Candidate> listOfCandidates = new ArrayList<Candidate>();				//List to store candidates in particular college.
			int capacity = colleges.listOfColleges.get(i).capacity;
			for ( int j = 0; j < capacity; j++) {
				if(candidates.front <= candidates.rear) {
				listOfCandidates.add(candidates.dequeue());
				}
				else {
					System.out.println("Less number of students");
					flag = 1;
					break;
				}
			}
			mapOfCandidateAndCollege.put(colleges.listOfColleges.get(i), listOfCandidates);
			if( flag  == 1) {
				break;
			}
			i++;
		}
		for(College key : mapOfCandidateAndCollege.keySet()){
			System.out.println("College = "+ key.name);
			for(Candidate c :mapOfCandidateAndCollege.get(key)) {
				System.out.println("List of Students = "+ c.name);
			}
		}
	}
	
}
