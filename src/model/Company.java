package model;

/**
 * Models a company (abstract)
 * @author Mateo Valdes
 *
 */
public abstract class Company {

	//Static attributes
	public static final String[] TYPES = {	"AGRICULTURE, HUNTING, SILVICULTURE AND FISHING", "MINING AND QUARRYING",
														"MANUFACTURING", "ELECTRICITY, GAS AND VAPOR", "CONSTRUCTION", "WHOLESALING AND RETAIL",
														"TRANSPORTATION, STORAGE AND COMMUNICATION", "FINNANCIAL SECTOR", "SOCIAL/COMMUNAL" };
	
	public static final int NUMCUBICLES = 20;
	//Non-static attributes
	private String name;
	private String nit;
	private String address;
	private String phoneNum;
	private int employeeNum;
	private double assetValue;
	private String dateFounded;
	private String type;
	private String legalRep;
	
	private Cubicle[][] building;
	
	/**
	 * Class constructor
	 * 
	 * @param nam The company's name
	 * @param nt The company's NIT
	 * @param addr The company's address
	 * @param phone The company's phone number
	 * @param employeeN The company's number of employees
	 * @param assetVal The company's asset value
	 * @param dateF The date that the company was founded
	 * @param typ The type of company
	 * @param legalR The name of the legal representative
	 */
	public Company(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
					String dateF, String typ, String legalR) {
		
		name = nam;
		nit = nt;
		address = addr;
		phoneNum = phone;
		employeeNum = employeeN;
		assetValue = assetVal;
		dateFounded = dateF;
		type = typ;
		legalRep = legalR;
		
	}
	
	/**
	 * Shows all the types of organizations defined in this class
	 * 
	 * @return A list of all the types of organizations
	 */
	public String showTypes() {
		String ret = "";
		
		for(int i = 0; i < TYPES.length; i++) {
			ret += (i+1) + ". " + TYPES[i] + "\n"; 
		}
		
		return ret;
	}
	
	/**
	 * Returns a String with all the important available attributes and information of this company.
	 * 
	 * 
	 * @return A String with all the available attributes of this company
	 */
	public String toString() {
		String ret = "";
		
		ret += "Name: " + name + "\n";
		ret += "NIT: " + nit + "\n";
		ret += "Address: " + address + "\n";
		ret += "Phone number: " + phoneNum + "\n";
		ret += "Number of employees: " + employeeNum + "\n";
		ret += "Asset value: " + assetValue + "\n";
		ret += "Date founded: " + dateFounded + "\n";
		ret += "Type: " + type + "\n";
		ret += "Legal representative's name: " + legalRep + "\n";
		
		return ret;
	}
	
	/**
	 * Returns the name of the company
	 * 
	 * @return A string containing the name of the company
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the nit of the company
	 * 
	 * @return A string containing the nit of the company
	 */
	public String getNit() {
		return nit;
	}
	
	/**
	 * Adds a building to the company if it has not been added yet. The building is represented by a matrix of 
	 * cubicles.
	 * 
	 * @param floors The number of floors in the building
	 * @return True if the building was added successfully, false if it was not
	 */
	public boolean addBuilding(int floors) {
		boolean success = false;
		if(building == null) {
			building = new Cubicle[floors][NUMCUBICLES];
			int count = 1;
			
			for(int i = 0; i < floors; i++) {
				for(int j = 0; j < NUMCUBICLES; j++) {
					building[i][j] = new Cubicle(count);
					count++;
				}
			}
			
			success = true;
		}
		
		return success;

	}
	
	/**
	 * Adds a new employee to the building (a matrix of cubicles). 
	 * 
	 * @param name The name of the employee
	 * @param post The post of the employee
	 * @param email The email of the employee
	 * @return True if the employee was added successfully, false if the employee could not be added
	 */
	public boolean addEmployee(String name, String post, String email) {
		boolean success = false;
		
		if(building != null) {
			for(int i = 0; i < building.length && !success; i++) {
				for(int j = 0; j < NUMCUBICLES && !success; j++) {
					if(!building[i][j].getFilled()) {
						building[i][j].addNewEmployee(name, post, email);
						success = true;
					}
				}
			}	
		}
		
		return success;
	}
	
	/**
	 * Searches for the extension of an employee given their name
	 * 
	 * @param name The name of the employee
	 * @param mode The mode of the search (L, Z, X, O, E, row spiral and column spiral)
	 * @return A String containing employee's extension. If there is an error, the string notifies the user.
	 */
	public String search(String name, int mode) {
		
		String ret = "";
		int ext = 0;
		
		switch(mode) {
		case 1:
			ext = searchL(name);
			break;
			
		case 2:
			ext = searchZ(name);
			break;
			
		case 3:
			ext = searchX(name);
			break;
			
		case 4:
			ext = searchO(name);
			break;
			
		case 5:
			ext = searchE(name);
			break;
			
		case 6:
			ext = searchRowSpiral(name);
			break;
			
		case 7:
			ext = searchColumnSpiral(name);
			break;
			
		default:
			ext = -1;
			break;
		}
		if(ext == -1) {
			ret = "ERROR. Please enter a valid number\n";
		} else if(ext == 0) {
			ret = "ERROR. The employee could not be found\n";
		} else {
			ret = name + "'s extension is: " + ext + "\n";
		}
			
		return ret;
		
	}
	
	/**
	 * Searches the building (a matrix of Cubicles) in an L shape (first row and first column) for an employee and returns their extension.
	 * If the employee is not found it returns 0.
	 * 
	 * @param name The name of the employee
	 * @return The extension of the employee
	 */
	public int searchL(String name) {
		
		int ext = 0;
		
		for(int i = 0; i < building.length; i++) {
			if(building[i][0].getEmployeeName().equals(name))
				ext = building[i][0].getExt();
				
		}
		for(int j = 1; j < NUMCUBICLES; j++) {
			if(building[0][j].getEmployeeName().equals(name))
				ext = building[0][j].getExt();
		}
		
		return ext;
	}
	
	/**
	 * Searches the building (a matrix of Cubicles) in a Z shape (first and last rows and the right to left diagonal) for an employee and returns their extension.
	 * If the employee is not found it returns 0.
	 * 
	 * @param name The name of the employee
	 * @return The extension of the employee
	 */
	public int searchZ(String name) {
		
		int ext = 0;
		
		for(int i = 0; i < building.length; i++) {
			if(building[0][i].getEmployeeName().equals(name))
				ext = building[0][i].getExt();
			if(building[i][building.length - 1 - i].getEmployeeName().equals(name))
				ext = building[i][building.length - 1 - i].getExt();
			if(building[building.length - 1][i].getEmployeeName().equals(name))
				ext = building[building.length - 1][i].getExt();
		}
		
		return ext;
		
	}
	
	/**
	 * Searches the building (a matrix of Cubicles) in an X shape (both diagonals) for an employee and returns their extension.
	 * If the employee is not found it returns 0.
	 * 
	 * @param name The name of the employee
	 * @return The extension of the employee
	 */
	public int searchX(String name) {
		int ext = 0;
		
		for(int i = 0; i < building.length; i++) {
			if(building[i][i].getEmployeeName().equals(name))
				ext = building[i][i].getExt();
			if(building[i][building.length - 1 - i].getEmployeeName().equals(name))
				ext = building[i][building.length - 1 - i].getExt();
		}
		
		return ext;
	}
	
	/**
	 * Searches the building (a matrix of Cubicles) in an O shape (first and last rows and first and last columns) for an employee and returns their extension.
	 * If the employee is not found it returns 0.
	 * 
	 * @param name The name of the employee
	 * @return The extension of the employee
	 */
	public int searchO(String name) {
		
		int ext = 0;
		
		for(int j = 0; j < NUMCUBICLES; j++) {
			if(building[0][j].getEmployeeName().equals(name))
				ext = building[0][j].getExt();
			if(building[building.length - 1][j].getEmployeeName().equals(name))
				ext = building[building.length - 1][j].getExt();
			
		}
		
		for(int i = 1; i < building.length - 1; i++) {
			if(building[i][0].getEmployeeName().equals(name))
				ext = building[i][0].getExt();
			if(building[i][building.length - 1].getEmployeeName().equals(name))
				ext = building[i][building.length - 1].getExt();		
		}
		
		return ext;
	}
	
	/**
	 * Searches the building (a matrix of Cubicles) in an E shape (first, middle and last rows) for an employee and returns their extension.
	 * If the employee is not found it returns 0.
	 * 
	 * @param name The name of the employee
	 * @return The extension of the employee
	 */
	public int searchE(String name) {
		
		int ext = 0;
		
		for(int j = 0; j < NUMCUBICLES; j++) {
			if(building[0][j].getEmployeeName().equals(name))
				ext = building[0][j].getExt();
			if(building[building.length - 1][j].getEmployeeName().equals(name))
				ext = building[building.length - 1][j].getExt();
			if(building[building.length / 2][j].getEmployeeName().equals(name))
				ext = building[building.length - 1][j].getExt();
		}
		
		for(int i = 1; i < building.length - 1; i++) {
			if(building[i][0].getEmployeeName().equals(name))
				ext = building[i][0].getExt();	
		}
		
		return ext;
	}
	
	/**
	 * Searches the building (a matrix of Cubicles) in a row spiral (starting from left to right) for an employee and returns their extension.
	 * If the employee is not found it returns 0.
	 * 
	 * @param name The name of the employee
	 * @return The extension of the employee
	 */
	public int searchRowSpiral(String name) {
		
		int ext = 0;
		boolean reverse = false;
		int count = 0;
		int total = building.length * NUMCUBICLES;
		int row = 0;
		
		while(count < total) {
			if(reverse) {
				for(int i = NUMCUBICLES - 1; i >= 0; i--) {
					if(building[row][i].getEmployeeName().equals(name))
						ext = building[row][i].getExt();
					count++;
				}
			} else {
				for(int i =0; i < NUMCUBICLES; i++) {
					if(building[row][i].getEmployeeName().equals(name))
						ext = building[row][i].getExt();
					count++;
				}
			}
			
			reverse = !reverse;
		}

		return ext;
	}
	
	/**
	 * Searches the building (a matrix of Cubicles) in a spiral shape (starting from the first column) for an employee and returns their extension.
	 * If the employee is not found it returns 0.
	 * 
	 * @param name The name of the employee
	 * @return The extension of the employee
	 */
	public int searchColumnSpiral(String name) {
		
		int ext = 0;
		int count = 0;
		boolean vertical = true;
		boolean reverse = false;
		int total = building.length * NUMCUBICLES;
		int skip = 0;

		
		while(count < total) {
			
			if(reverse) {
				if(vertical) {
					for(int i = building.length - 1 - skip; i >= 0 + skip; i--) {
						if(building[i][NUMCUBICLES - 1 - skip].getEmployeeName().equals(name))
							ext = building[i][NUMCUBICLES - 1 - skip].getExt();
						count++;
					}
					
				} else {
					for(int j = NUMCUBICLES - 2 - skip; j > 0 + skip; j--) {
						if(building[skip][j].getEmployeeName().equals(name))
							ext = building[skip][j].getExt();
						count++;
					}
					skip += 1;
					reverse = !reverse;
				}
			} else {
				if(vertical) {
					for(int i = 0 + skip; i < building.length - skip; i++) {
						if(building[i][skip].getEmployeeName().equals(name))
							ext = building[i][skip].getExt();
						count++;
					}
					
				} else {
					for(int j = 1 + skip; j < NUMCUBICLES - 2 - skip; j++) {
						if(building[building.length - 1 - skip][j].getEmployeeName().equals(name))
							ext = building[building.length - 1 - skip][j].getExt();
						count++;
					}
					reverse = !reverse;
				}
			}
			vertical = !vertical;
		}
		return ext;
	}
	
}
