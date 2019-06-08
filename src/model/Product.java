package model;

public class Product {

	String name;
	String code;
	double waterQuantity;
	int units;
	
	public Product(String nam, String cod, double waterQ, int unts) {
		name = nam;
		code = cod;
		waterQuantity = waterQ;
		units = unts;
	}
	
	public String toString() {
		String ret = "";
		
		ret += "Name: " + name + "\n";
		ret += "Code: " + code + "\n";
		ret += "Water Quantity consumed: " + waterQuantity + "\n";
		ret += "Units: " + units + "\n";
		
		return ret;
	}
	
	public double waterConsumed() {
		double wc = units * waterQuantity;
		
		return wc;
	}
	
}
