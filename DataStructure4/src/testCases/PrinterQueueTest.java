package testCases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entitites.ChairPerson;
import entitites.GraduateStudent;
import entitites.Professor;
import entitites.UnderGraduate;
import facade.PrinterFacade;

public class PrinterQueueTest {

	ChairPerson chairPersonInstance;
	Professor professorInstance;
	GraduateStudent graduateStudentInstance;
	UnderGraduate underGraduateInstance;
	List<String> actualList;
	List<String> expectedList;
	
	@Test
	public void testPrintJobAsPrioritySuccess() {
		chairPersonInstance = new ChairPerson("This data is from Chair Person");
		professorInstance = new Professor("This data is from Professor");
		graduateStudentInstance = new GraduateStudent("This data is from Graduate Student");
		underGraduateInstance = new UnderGraduate("This data is from Under Graduate Student");
		underGraduateInstance.sendDataToPrinter();
		chairPersonInstance.sendDataToPrinter();
		chairPersonInstance.sendDataToPrinter();
		graduateStudentInstance.sendDataToPrinter();
		professorInstance.sendDataToPrinter();
		actualList = new ArrayList<>();
		expectedList = new ArrayList<>();
		actualList = PrinterFacade.getInstance().print();
		expectedList.add("This data is from Under Graduate Student");
		expectedList.add("This data is from Professor");
		expectedList.add("This data is from Graduate Student");
		expectedList.add("This data is from Chair Person");
		expectedList.add("This data is from Chair Person");
		assertEquals(expectedList, actualList);
		PrinterFacade.getInstance().listOfPrintingOrder.clear();
	}
	
	@Test
	public void testPrintJobAsPriorityFailure() {
		chairPersonInstance = new ChairPerson("This data is from Chair Person");
		professorInstance = new Professor("This data is from Professor");
		graduateStudentInstance = new GraduateStudent("This data is from Graduate Student");
		underGraduateInstance = new UnderGraduate("This data is from Under Graduate Student");
		professorInstance.sendDataToPrinter();
		chairPersonInstance.sendDataToPrinter();
		underGraduateInstance.sendDataToPrinter();
		professorInstance.sendDataToPrinter();
		graduateStudentInstance.sendDataToPrinter();
		actualList = new ArrayList<>();
		expectedList = new ArrayList<>();
		actualList = PrinterFacade.getInstance().print();
		expectedList.add("This data is from Under Graduate Student");
		expectedList.add("This data is from Professor");
		expectedList.add("This data is from Graduate Student");
		expectedList.add("This data is from Chair Person");
		assertNotEquals(expectedList, actualList);
		PrinterFacade.getInstance().listOfPrintingOrder.clear();
	}
}
