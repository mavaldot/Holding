package model;

public class PublicServiceCompany extends ServiceCompany implements ProculturaTax {

	private String serviceType;
	private int totalSubs;
	private int stratum1and2Subs;
	
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
	 * @param sTyp The type of service the company provides
	 * @param totalS The total number of subscribers the company has
	 * @param s12Subs The number of stratum 1 and 2 the company has
	 */
	public PublicServiceCompany(String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
			String dateF, String typ, String legalR, String sTyp, int totalS, int s12Subs) {

		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		serviceType = sTyp;
		totalSubs = totalS;
		stratum1and2Subs = s12Subs;
	}
	
	/**
	 * Returns a String with all the important available attributes and information of this company.
	 * Includes the information inherited from its superclass.
	 * 
	 * @return A String with all the available attributes of this company
	 */
	public String toString() {
		
		String ret = super.toString();
		ret += "Service type: " + serviceType + "\n";
		ret += "Total subscribers: " + totalSubs + "\n";
		ret += "Stratum 1 and 2 subscribers: " + stratum1and2Subs + "\n";
		return ret;
		
	}
	
	/**
	 * Calculates the procultura tax based on the percentage of stratum 3, 4, 5 and 6 subscribers
	 * 
	 * @return A double representing the percentage the company must pay as part of the procultura tax.
	 */ 
	public double calculateProculturaTax() {
		double ret = .40 - ( (totalSubs - stratum1and2Subs) / totalSubs);
		
		if(ret < 0) {
			ret = 0;
		}
		
		ret *= 10;
		
		return ret;
	}
	
	/**
	 * Reports the name of the company and the percentage of procultura tax it must pay
	 * 
	 * @return A string containing the name of the company and the percentage of procultura tax it must pay
	 */
	public String reportProculturaTax() {
		String name = getName();
		double tax = calculateProculturaTax();
		
		String rprt = name + " must pay " + tax + "% procultura tax.\n";
		
		return rprt;
 	}
	
}
