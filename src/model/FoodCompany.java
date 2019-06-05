package model;

public class FoodCompany extends FabricationCompany{

	private String sanitationReg;
	private boolean valid;
	private String expirationDate;
	private String category;
	private boolean kosher;
	private boolean bpaCertificate;
	
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
