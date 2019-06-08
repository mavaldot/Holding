package model;

public class MedicationCompany extends FabricationCompany implements TreePlanter {

	private String sanitationReg;
	private boolean valid;
	private String expirationDate;
	private String category;
	
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
	
	public String toString() {
		String ret = super.toString();
		ret += "Sanitation registry: " + sanitationReg + "\n";
		ret += "Valid certificate: " + valid + "\n";
		ret += "Certificate expiration date: " + expirationDate + "\n";
		ret += "Category: " + category + "\n";
		
		return ret;
	}
	
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
	
	public String reportTrees() {
		String name = getName();
		int trees = calculateTrees();
		
		String rprt = name + " must plant " + trees + " trees.\n";
		
		return rprt;
 	}
}
		
		
