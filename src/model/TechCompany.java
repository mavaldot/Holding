package model;

import java.util.ArrayList;

public class TechCompany extends ServiceCompany implements TreePlanter {

	public static String[] possibleServices = {"Consulting", "Training", "Custom Sorfware Development", 
												"Infrastructure as Service", "Software as Service", "Platform as Service"};
	
	private double energyConsumed;
	ArrayList<String> services;
	
	public TechCompany(String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
			String dateF, String typ, String legalR, double ec, boolean[] serv) {

		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		energyConsumed = ec;
		services = new ArrayList<String>();
		for(int i = 0; i < serv.length; i++) {
			if(serv[i]) {
				services.add(possibleServices[i]);
			}
		}
	}
	
	public String toString() {
		
		String ret = super.toString();
		ret += "SERVICES:\n";
		
		for(String serv : services) {
			ret += serv + "\n"; 
		}
		
		return ret;
		
	}
	
	public int calculateTrees() {
		int trees = 0;
		
		if(energyConsumed > 1 && energyConsumed < 1000) 
			trees = 8;
		else if(energyConsumed < 3000) 
			trees = 35;
		else 
			trees = 500;
		
		return trees;
	}
	
	public String reportTrees() {
		String name = getName();
		int trees = calculateTrees();
		
		String rprt = name + " must plant " + trees + " trees.\n";
		
		return rprt;
 	}
	
}
