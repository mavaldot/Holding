package model;

/**
 * Models a food company
 * @author Mateo Valdes
 *
 */
public class FoodCompany extends FabricationCompany{

	private String sanitationReg;
	private boolean valid;
	private String expirationDate;
	private String category;
	private boolean kosher;
	private boolean bpaCertificate;
	
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
	 * @param koshr Whether the company has a kosher certificate
	 * @param bpaC Whether the company has a BPA certificate
	 */
	public FoodCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
						String dateF, String typ, String legalR, String sanitationR, boolean vld, String expD, String cat,
						boolean koshr, boolean bpaC) {
		
		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		sanitationReg = sanitationR;
		valid  = vld;
		expirationDate = expD;
		category = cat;
		kosher = koshr;
		bpaCertificate = bpaC;
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
		ret += "Kosher: " + kosher + "\n";
		ret += "BPA Certificate: " + bpaCertificate + "\n";
		
		return ret;
	}
}
