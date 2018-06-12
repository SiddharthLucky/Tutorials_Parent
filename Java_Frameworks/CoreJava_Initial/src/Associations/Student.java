package Associations;

import java.util.Arrays;

public class Student extends Person
{
	private int numCourses;
	private String[] courses;
	private int[] grades;
	
	public int getNumCourses() {
		return numCourses;
	}

	public void setNumCourses(int numCourses) {
		this.numCourses = numCourses;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	public int[] getGrades() {
		return grades;
	}

	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	public Student(String name, String address) {
		super(name, address);
		// TODO Auto-generated constructor stub
	}
	
	public void addCourseGrade(String course, int grade)
	{
		
	}
	
	public void printGrades()
	{
		
	}
	
	public double getAvarageGrade()
	{
		double value =0.0;
		return value;
	}

	@Override
	public String toString() {
		return "Student [numCourses=" + numCourses + ", courses=" + Arrays.toString(courses) + ", grades="
				+ Arrays.toString(grades) + ", getName()=" + getName() + ", getAddress()=" + getAddress() + "]";
	}

	

	
}
