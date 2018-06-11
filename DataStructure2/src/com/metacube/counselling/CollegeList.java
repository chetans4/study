package com.metacube.counselling;

import java.util.ArrayList;
import java.util.List;

/*
 * Class name- CollegeList
 * This class stores details of colleges.
 */
public class CollegeList {
	public List<College> listOfColleges = new ArrayList<College>();				//List to store college details
	
	public CollegeList() {
		College c1 = new College("College1", 1);
		College c2 = new College("College2", 2);
		College c3 = new College("College3", 3);
		College c4 = new College("College4", 4);
		College c5 = new College("College5", 5);
		listOfColleges.add(c1);
		listOfColleges.add(c2);
		listOfColleges.add(c3);
		listOfColleges.add(c4);
		listOfColleges.add(c5);
	}
}
