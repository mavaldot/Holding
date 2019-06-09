package model;

/**
 * Models a cubicle with or without an employee
 * @author Mateo Valdes
 *
 */
public class Cubicle {

	private String employeeName;
	private String employeePost;
	private String employeeEmail;
	private int ext;
	private boolean filled;
	
	/**
	 * Class constructor
	 * @param ex The extension of the cubicle
	 */
	public Cubicle(int ex) {
		ext = ex;
		employeeName = "N/A";
		employeePost = "N/A";
		employeeEmail = "N/A";
		filled = false;
	}
	
	/**
	 * Returns the name of the employee in the cubicle. If there is no employee, returns "N/A"
	 * @return A String with the name of the employee
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	
	/**
	 * Returns the extension of the cubicle
	 * 
	 * @return A number representing the extension of the cubicle
	 */
	public int getExt() {
		return ext;
	}
	
	/**
	 * Adds a new employee to the cubicle
	 * <p>
	 * post: The name, post and email of the cubicle now contain information about the employee <br>
	 * post: filled is now <code> true </code>
	 * 
	 * @param name The name of the employee
	 * @param post The post of the employee
	 * @param email The email of the employee
	 */
	public void addNewEmployee(String name, String post, String email) {
		employeeName = name;
		employeePost = post;
		employeeEmail = email;
		filled = true;
	}
	
	/**
	 * Returns whether the cubicle is filled (i.e. has an employee)
	 * 
	 * @return <code> true </code> if there is an employee, <code> false </code> if there is no employee
	 */
	public boolean getFilled() {
		return filled;
	}
	
}
