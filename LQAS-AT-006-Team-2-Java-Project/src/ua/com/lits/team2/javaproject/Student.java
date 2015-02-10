package ua.com.lits.team2.javaproject;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

	public String name;
	public String surname;
	public int age;
	public ArrayList<String> courses;
	
	@JsonCreator
	public Student(@JsonProperty("name") String name, 
			@JsonProperty("surname") String surname, 
			@JsonProperty("age") int age,
			@JsonProperty("courses") ArrayList<String> courses) {

		this.name = name;
		this.surname = surname;
		this.age = age;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}

	public StringBuilder buildCoursestString() {
		StringBuilder coursesList = new StringBuilder();
		if (!courses.isEmpty()) {
			for (int i = 0; i < courses.size(); i++) {
				if (i != courses.size() - 1) {
					coursesList.append(courses.get(i)).append(", ").toString();
				} else {
					coursesList.append(courses.get(i)).append("").toString();
				}
			}
			coursesList.append(".");
			
		} else { // case when no courses assigned to student. 
			coursesList.append("-");
		}

		return coursesList;
	}
	
	@Override
	public String toString() {
		StringBuilder stud = new StringBuilder();
		return stud.append(surname).append(" ").append(name)
				.append(", age: ").append(age)
				.append(", courses: ").append(buildCoursestString())
				.toString();	
	}
}


