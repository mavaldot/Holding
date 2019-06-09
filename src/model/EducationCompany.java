package model;

/**
 * Models an education company and implements the procultura tax interface
 * 
 * @author Mateo Valdes
 *
 */
public class EducationCompany extends ServiceCompany implements ProculturaTax {

	private int regNumber;
	private int yearsAccredited;
	private int saberRank;
	private String principalName;
	private String educationSector;
	private int activeStudents;
	private int stratum1and2Students;
	
	/**
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
	 * @param regNum
	 * @param aYears
	 * @param sRank
	 * @param pName
	 * @param eduSector
	 * @param aStudents
	 * @param s12Students
	 */
	public EducationCompany(String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
							String dateF, String typ, String legalR, int regNum, int aYears, int sRank, 
							String pName, String eduSector, int aStudents, int s12Students) {
		
		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		regNumber = regNum;
		yearsAccredited = aYears;
		saberRank = sRank;
		principalName = pName;
		educationSector = eduSector;
		activeStudents = aStudents;
		stratum1and2Students = s12Students;
	
	}

	/**
	 * Returns a String with all the important available attributes and information of this company.
	 * Includes the information inherited from its superclass.
	 * 
	 * @return A String with all the available attributes of this company
	 */
	public String toString() {
		String ret = super.toString();
		
		ret += "Registry number: " + regNumber + "\n"; 
		ret += "Number of years accredited: " + yearsAccredited + "\n"; 
		ret += "Saber 11/Saber Pro rank: " + saberRank + "\n"; 
		ret += "Name of the principal: " + principalName + "\n"; 
		ret += "Education sector: " + educationSector + "\n"; 
		ret += "Number of active students: " + activeStudents + "\n"; 
		ret += "Number of stratum 1 and 2 students: " + stratum1and2Students + "\n"; 
		
		return ret;
	}
	
	/**
	 * Calculates the procultura tax based on the percentage of stratum 1 and 2 students
	 * 
	 * @return A double representing the percentage the company must pay as part of the procultura tax.
	 */ 
	public double calculateProculturaTax() {
		double ret = .20 - ( (double) stratum1and2Students/activeStudents);
		
		if(ret < 0) {
			ret = 0;
		}
		
		ret *= 100;
		
		return ret;
	}
	
	/**
	 * Reports the name of the company and the percentage of procultura tax it must pay
	 * 
	 * @return A string containing the name of the company and the percentage of procultura tax it must pay
	 */
	public String reportProculturaTax() {
		String name = getName();
		double tax = calculateProculturaTax();
		
		String rprt = name + " must pay " + tax + "% procultura tax.\n";
		
		return rprt;
 	}
}
