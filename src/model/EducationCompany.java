package model;

public class EducationCompany extends ServiceCompany implements ProculturaTax {

	private int regNumber;
	private int yearsAccredited;
	private int saberRank;
	private String principalName;
	private String educationSector;
	private int activeStudents;
	private int stratum1and2Students;
	
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
	
	public double calculateProculturaTax() {
		double ret = .20 - (stratum1and2Students/activeStudents);
		
		if(ret < 0) {
			ret = 0;
		}
		
		ret *= 10;
		
		return ret;
	}
	
}
