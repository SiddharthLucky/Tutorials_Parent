package Associations;

import java.util.Arrays;

public class Teacher extends Person 
{
	private int numCourses;
	private String[] courses;
	
	
	public Teacher(String name, String address) {
		super(name, address);
		// TODO Auto-generated constructor stub
	}
	
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

	public boolean addCourse(String course)
	{
		boolean val = true;
		return val;
	}
	public boolean removeCourse(String course)
	{
		boolean val = true;
		return val;
	}

	@Override
	public String toString() {
		return "Teacher [numCourses=" + numCourses + ", courses=" + Arrays.toString(courses) + ", getName()="
				+ getName() + ", getAddress()=" + getAddress() + "]";
	}
	
}
