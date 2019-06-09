package model;

/**
 * Models a fabrication company's product
 * 
 * @author Mateo Valdes
 *
 */
public class Product {

	String name;
	String code;
	double waterQuantity;
	int units;
	
	/**
	 * Class constructor
	 * 
	 * @param nam The name of the product
	 * @param cod The code of the product
	 * @param waterQ The water quantity needed to manufacture the products
	 * @param unts The amount of units available of the product
	 */
	public Product(String nam, String cod, double waterQ, int unts) {
		name = nam;
		code = cod;
		waterQuantity = waterQ;
		units = unts;
	}
	
	/**
	 * Returns a String with all the important available attributes and information of this company.
	 * 
	 * @return A String with all the available attributes of this company
	 */
	public String toString() {
		String ret = "";
		
		ret += "Name: " + name + "\n";
		ret += "Code: " + code + "\n";
		ret += "Water Quantity consumed: " + waterQuantity + "\n";
		ret += "Units: " + units + "\n";
		
		return ret;
	}
	
	/**
	 * Calculates the total water consumed by this product.
	 * 
	 * @return A double representing the water consumed by this product (in liters).
	 */
	public double waterConsumed() {
		double wc = units * waterQuantity;
		
		return wc;
	}
	
}
