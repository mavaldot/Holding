package model;

import java.util.ArrayList;

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
		
		for(int i = 0; i < TYPES.length; i++) {
			ret += (i+1) + ". " + TYPES[i] + "\n"; 
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
	
	public String getName() {
		return name;
	}
	
	public String getNit() {
		return nit;
	}
	
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
	
	public String search(String name, int type) {
		
		String ret = "";
		int ext = 0;
		
		
		
		return ret;
		
	}
	
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
	
	public int searchZ(String name) {
		
		int ext = 0;
		
		for(int i = 0; i < building.length; i++) {
			if(building[0][i].getEmployeeName().equals(name))
				ext = building[0][i].getExt();
			if(building[i][i].getEmployeeName().equals(name))
				ext = building[i][i].getExt();
			if(building[building.length - 1][i].getEmployeeName().equals(name))
				ext = building[building.length - 1][i].getExt();
		}
		
		return ext;
		
	}
	
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
	
	public int searchE(String name) {
		
		int ext = 0;
		
		for(int j = 0; j < NUMCUBICLES; j++) {
			if(building[0][j].getEmployeeName().equals(name))
				ext = building[0][j].getExt();
			if(building[building.length - 1][j].getEmployeeName().equals(name))
				ext = building[building.length - 1][j].getExt();
			if(building[building.length / 2 + 1][j].getEmployeeName().equals(name))
				ext = building[building.length - 1][j].getExt();
		}
		
		for(int i = 1; i < building.length - 1; i++) {
			if(building[i][0].getEmployeeName().equals(name))
				ext = building[i][0].getExt();	
		}
		
		return ext;
	}
	
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
	
	public int searchColumnSpiral(String name) {
		
		int ext = 0;
		int count = 0;
		boolean vertical = false;
		int total = building.length * NUMCUBICLES;

		int startX = 0;
		int endX = building.length;
		int stepX = 0;
		
		int startY = 0;
		int endY = NUMCUBICLES;
		int stepY = 0;
		
		int paddingX = 0;
		int paddingY = 0;
		
		int stepper = 1;
		
		while(count < total) {
			
			if(vertical) {
				for(stepX = startX; stepX < (endX - paddingX*stepper); stepX += stepper) {
					if(building[stepX][startY].getEmployeeName().equals(name))
						ext = building[stepX][startY].getExt();
					count++;
				}
				endX = startX;
				startX = stepX;
				
			} else {
				for(stepY = startY + stepper; stepY < (endY - paddingY*stepper); stepY += stepper) {
					if(building[startX][stepY].getEmployeeName().equals(name))
						ext = building[stepX][stepY].getExt();
					count++;
				}
				endY = startY;
				startY = stepY;
				stepper *= -1;
			}
			
			vertical = !vertical;
		}
		return ext;
	}

	
	
	
	
	
}
