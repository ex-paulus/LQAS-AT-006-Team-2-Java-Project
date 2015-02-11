package ua.com.lits.team2.javaproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentList {
	
	public ArrayList<Student> sList;

	@JsonCreator
	public StudentList(
			@JsonProperty("students") ArrayList<Student> list) {
		this.sList = list;
	}
	
	public void sortStudents (){
		Comparator<Student> cmp = new Comparator<Student>(){

			@Override
			public int compare(Student s1, Student s2) {

				// Sort by surname
		        int cmpS = s1.surname.compareTo(s2.surname);
		        if (cmpS != 0)
		        {
		            return cmpS;
		        }

		        // Next by name
				return s1.name.compareTo(s2.name);
			}			
		};	
		Collections.sort(sList, cmp);
	}

	public void printStudentList() {
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}

	}
}
