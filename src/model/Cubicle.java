package model;

public class Cubicle {

	private String employeeName;
	private String employeePost;
	private String employeeEmail;
	private int ext;
	
	public Cubicle(int ex) {
		this.ext = ex;
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
	}
	
	
}
