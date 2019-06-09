package model;

import java.util.ArrayList;

/**
 * Models a fabrication company with products
 * @author Mateo Valdes
 *
 */
public class FabricationCompany extends Company{

	private ArrayList<Product> products;
	
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
	 */
	public FabricationCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
								String dateF, String typ, String legalR) {

		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		products = new ArrayList<Product>();
	}
	
	/**
	 * Adds a new product to the fabrication company's list of products
	 * 
	 * @param nam The name of the product
	 * @param cod The code of the product
	 * @param waterQ The water quantity needed to manufacture the products
	 * @param unts The amount of units available of the product
	 */
	public void addProduct(String nam, String cod, double waterQ, int unts) {
		
		products.add(new Product(nam, cod, waterQ, unts));
		
	}
	
	/**
	 * Returns a String with all the important available attributes and information of this company.
	 * Includes the information inherited from its superclass and information about its products.
	 * 
	 * @return A String with all the available attributes of this company
	 */
	public String toString() {
		
		String ret = super.toString();
		ret += "\nPRODUCTS:\n";						
		
		for(Product p : products) {
			ret += p.toString();
		}
		
		return ret;
		
	}
	
	/**
	 * Calculates the water consumed by the fabrication company based on how much water was consumed by their products.
	 * 
	 * @return A double representing the water consumed by the company (in liters)
	 */
	public double calculateWaterConsumed() {
		double wc = 0;
		for(Product p : products) {
			wc += p.waterConsumed();
		}
		
		return wc;
	}
	
}
