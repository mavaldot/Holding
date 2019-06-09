package model;

import java.util.ArrayList;

public class TechCompany extends ServiceCompany implements TreePlanter {

	public static String[] possibleServices = {"Consulting", "Training", "Custom Software Development", 
												"Infrastructure as Service", "Software as Service", "Platform as Service"};
	
	private double energyConsumed;
	ArrayList<String> services;
	
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
	 * @param ec The energy consumed by the company (in kilowatts)
	 * @param serv An array of all the services performed by the company
	 */
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
	
	/**
	 * Returns a String with all the important available attributes and information of this company.
	 * Includes the information inherited from its superclass.
	 * 
	 * @return A String with all the available attributes of this company
	 */
	public String toString() {
		
		String ret = super.toString();
		ret += "SERVICES:\n";
		
		for(String serv : services) {
			ret += serv + "\n"; 
		}
		
		return ret;
		
	}
	
	/**
	 * Calculates how many trees the company must plant based on how much energy it consumes
	 * 
	 * @return A number representing the number of trees the company must plant
	 */
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
	
	/**
	 * Reports the name of company and the number of trees it must plant
	 * 
	 * @return A string containing the name of the company and how many trees it must plant
	 */
	public String reportTrees() {
		String name = getName();
		int trees = calculateTrees();
		
		String rprt = name + " must plant " + trees + " trees.\n";
		
		return rprt;
 	}
	
}
