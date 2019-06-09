package model;

public class Cubicle {

	private String employeeName;
	private String employeePost;
	private String employeeEmail;
	private int ext;
	private boolean filled;
	
	public Cubicle(int ex) {
		ext = ex;
		employeeName = "N/A";
		employeePost = "N/A";
		employeeEmail = "N/A";
		filled = false;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public int getExt() {
		return ext;
	}
	
	public void addNewEmployee(String name, String post, String email) {
		employeeName = name;
		employeePost = post;
		employeeEmail = email;
		filled = true;
	}
	
	public boolean getFilled() {
		return filled;
	}
	
}
