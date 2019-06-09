package model;

/**
 * Models a medication company and implements the tree planter interface
 * @author Mateo Valdes
 *
 */
public class MedicationCompany extends FabricationCompany implements TreePlanter {

	private String sanitationReg;
	private boolean valid;
	private String expirationDate;
	private String category;
	
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
	 * @param sanitationR The sanitation registry of the company
	 * @param valid Whether the sanitation registry of the company is currently valid
	 * @param expD The expiration date of the sanitation registry of the company
	 * @param cat The category of the company
	 */
	public MedicationCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
								String dateF, String typ, String legalR, String sanitationR, boolean vld, String expD, String cat) {
		
		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		sanitationReg = sanitationR;
		valid  = vld;
		expirationDate = expD;
		category = cat;
	}
	
	public void addProduct(String nam, String cod, double waterQ, int unts) {
		
		super.addProduct(nam, cod, waterQ, unts);
		
	}
	
	/**
	 * Returns a String with all the important available attributes and information of this company.
	 * Includes the information inherited from its superclass.
	 * 
	 * @return A String with all the available attributes of this company
	 */
	public String toString() {
		String ret = super.toString();
		ret += "Sanitation registry: " + sanitationReg + "\n";
		ret += "Valid certificate: " + valid + "\n";
		ret += "Certificate expiration date: " + expirationDate + "\n";
		ret += "Category: " + category + "\n";
		
		return ret;
	}
	
	/**
	 * Calculates how many trees the company must plant based on how much water it consumes
	 * 
	 * @return A number representing the number of trees the company must plant
	 */
	public int calculateTrees() {
		double wc = calculateWaterConsumed();
		int trees = 0;
		
		if(wc > 1 && wc < 140) 
			trees = 6;
		else if(wc < 800) 
			trees = 25;
		else 
			trees = 200;
		
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
		
		
