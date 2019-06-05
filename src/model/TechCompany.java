package model;

import java.util.ArrayList;

public class TechCompany extends ServiceCompany {

	ArrayList<String> services;
	
	public TechCompany(String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
			String dateF, String typ, String legalR) {

		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		services = new ArrayList<String>();
	}
	
	public String toString() {
		
		String ret = super.toString();
		
		return ret;
		
	}
	
}
