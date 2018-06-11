package testCases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.DepartmentalChairPerson;
import entities.GraduateStudent;
import entities.Professor;
import entities.UnderGraduate;
import facade.PrinterFacade;

/**
 * This class is to test the working of printing job scheduling
 * @author Akshita Dixit
 */
public class PrinterQueueTest {

	private DepartmentalChairPerson deptChairEntity;
	private Professor profEntity;
	private GraduateStudent graduateEntity;
	private UnderGraduate undergradEntity;
	private List<String> actualList;
	private List<String> expectedList;
	
	/**
	 * method to test the printing of jobs as per the priority
	 */
	@Test
	public void testPrintJobAsPrioritySuccess() {
		deptChairEntity = new DepartmentalChairPerson("This is from department chair person");
		profEntity = new Professor("This is from professor");
		graduateEntity = new GraduateStudent("This is from grad student");
		undergradEntity = new UnderGraduate("This is from under grad student");
		undergradEntity.sendToPrinter();
		deptChairEntity.sendToPrinter();
		deptChairEntity.sendToPrinter();
		graduateEntity.sendToPrinter();
		profEntity.sendToPrinter();
		actualList = new ArrayList<>();
		expectedList = new ArrayList<>();
		actualList = PrinterFacade.getInstance().print();
		expectedList.add("This is from department chair person");
		expectedList.add("This is from department chair person");
		expectedList.add("This is from professor");
		expectedList.add("This is from grad student");
		expectedList.add("This is from under grad student");
		assertEquals(expectedList, actualList);
	}
	
	/**
	 * method to test the printing of jobs as per the priority
	 */
	@Test
	public void testPrintJobAsPriorityFailure() {
		deptChairEntity = new DepartmentalChairPerson("This is from department chair person");
		profEntity = new Professor("This is from professor");
		graduateEntity = new GraduateStudent("This is from grad student");
		undergradEntity = new UnderGraduate("This is from under grad student");
		undergradEntity.sendToPrinter();
		deptChairEntity.sendToPrinter();
		deptChairEntity.sendToPrinter();
		graduateEntity.sendToPrinter();
		profEntity.sendToPrinter();
		actualList = new ArrayList<>();
		expectedList = new ArrayList<>();
		actualList = PrinterFacade.getInstance().print();
		expectedList.add("This is from department chair person");
		expectedList.add("This is from department chair person");
		expectedList.add("This is from professor");
		expectedList.add("This is from under grad student");
		assertNotEquals(expectedList, actualList);
	}
	

	
}

