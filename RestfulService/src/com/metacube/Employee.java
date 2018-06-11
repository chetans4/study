package com.metacube;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/employee")
public class Employee {
	private JSONParser parser = new JSONParser();
	private File file = new File("C:/Users/admin/workspace/RestfulService/src/com/metacube/employee.txt");
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllEmployees() {
		String jsonObj = getFileContent();
		return jsonObj;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeeById(@PathParam("id") String id) throws ParseException{
		String message = "{}";
		
		JSONObject employeesJsonObject = (JSONObject) parser.parse(getFileContent());
		JSONArray employeesArray = (JSONArray) employeesJsonObject.get("employee");
		JSONObject employee;
		
		for ( int i = 0 ; i < employeesArray.size() ; i++ ){
			employee = ((JSONObject) employeesArray.get(i));
			
			if(employee.get("id").toString().equalsIgnoreCase(id)){
				message = employee.toString();
				break;
			}
		}
		return message;
	}
	
	@GET
	@Path("name")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeesByName(@QueryParam("name") String employeeName) throws ParseException{
		
		JSONObject employeesJsonObject = (JSONObject) parser.parse(getFileContent());
		JSONArray employeesArray = (JSONArray) employeesJsonObject.get("employee");
		JSONObject employee;
		JSONArray requiredEmployees = new JSONArray();
		
		for ( int i = 0 ; i < employeesArray.size() ; i++ ){
			employee = ((JSONObject) employeesArray.get(i));
			
			if(!employee.get("name").toString().equalsIgnoreCase(employeeName)){
				requiredEmployees.add(employee);
			}
		}
		return requiredEmployees.toString();
	}
	
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public String createEmployee(@QueryParam("employee") String employeeJsonString) throws ParseException{
		int id = 0;
		JSONObject employee = (JSONObject) parser.parse(employeeJsonString);
		JSONObject employeesJsonObject = (JSONObject) parser.parse(getFileContent());
		JSONArray employeesArray = (JSONArray) employeesJsonObject.get("employee");
		
		if(employeesArray.size() > 0) {
			id = Integer.parseInt(((JSONObject) employeesArray.get(employeesArray.size() - 1)).get("id").toString());
		}
		addEmployee(id + 1, employee);
		employeesArray.add(employee);
		insertIntoFile(employeesJsonObject.toString());
		return employee.toString();
	}
	
	private static void addEmployee(int id, JSONObject employee){
		employee.put("id", Integer.toString(id));
	}

	private void insertIntoFile(String data){
		OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}    
	private String getFileContent() {
		
		File file = new File("C:/Users/admin/workspace/RestfulService/src/com/metacube./employee.txt");
		String employeesJsonString = "";
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				employeesJsonString += scan.nextLine();
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("file error");
		}
		return employeesJsonString;
	} 
	
	
	@GET
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee(@QueryParam("id") String id) throws ParseException {
		
		JSONObject employeesJsonObject = (JSONObject) parser.parse(getFileContent());
		JSONArray employeesArray = (JSONArray) employeesJsonObject.get("employee");
		JSONObject employee;
		
		for ( int i = 0 ; i < employeesArray.size() ; i++ ){
			employee = ((JSONObject) employeesArray.get(i));
			
			if(employee.get("id").toString().equalsIgnoreCase(id)){
				employeesArray.remove(employee);
				break;
			}
		}

		insertIntoFile(employeesJsonObject.toString());
		return "success";
	}
}
