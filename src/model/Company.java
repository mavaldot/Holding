package model;

public abstract class Company {

	//Static attributes
	public static final String[] organizationTypes = {	"AGRICULTURE, HUNTING, SILVICULTURE AND FISHING", "MINING AND QUARRYING",
														"MANUFACTURING", "ELECTRICITY, GAS AND VAPOR", "CONSTRUCTION", "WHOLESALING AND RETAIL",
														"TRANSPORTATION, STORAGE AND COMMUNICATION", "FINNANCIAL SECTOR", "SOCIAL/COMMUNAL" };
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
	
	public String showTypes() {
		String ret = "";
		
		for(int i = 0; i < organizationTypes.length; i++) {
			ret += (i+1) + ". " + organizationTypes[i] + "\n"; 
		}
		
		return ret;
	}
	
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
	
	
}
