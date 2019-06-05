package model;

import java.util.ArrayList;

public class FabricationCompany extends Company{

	private ArrayList<Product> products;
	
	public FabricationCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
								String dateF, String typ, String legalR) {

		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		products = new ArrayList<Product>();
	}
	
	public void addProduct(String nam, String cod, double waterQ, int unts) {
		
		products.add(new Product(nam, cod, waterQ, unts));
		
	}
	
	public String toString() {
		
		String ret = super.toString();
		
		return ret;
		
	}
	
}