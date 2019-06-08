package model;

import java.util.ArrayList;

public class TechCompany extends ServiceCompany {

	public static String[] possibleServices = {"Consulting", "Training", "Custom Sorfware Development", 
												"Infrastructure as Service", "Software as Service", "Platform as Service"};
	
	ArrayList<String> services;
	
	public TechCompany(String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
			String dateF, String typ, String legalR, boolean[] serv) {

		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
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
	
}
