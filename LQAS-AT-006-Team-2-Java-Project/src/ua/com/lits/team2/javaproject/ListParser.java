package ua.com.lits.team2.javaproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListParser {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	    InputStream input = new FileInputStream("src/ua/com/lits/team2/javaproject/students.json");
	    ObjectMapper mapper = new ObjectMapper();	    
	    StudentList sl = mapper.readValue(input, StudentList.class);
	   
	    System.out.println("Students:");
	    System.out.println();
	    
	    sl.sortStudents();
	    sl.printStudentList(); 
	    
	}
}
