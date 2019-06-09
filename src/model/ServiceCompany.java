package model;

/**
 * Models a service company
 * @author Mateo Valdes
 *
 */
public class ServiceCompany extends Company{

	public static final int MAXSURVEYS = 50;
	private Survey[] surveys;
	
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
	public ServiceCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
							String dateF, String typ, String legalR) {
		
		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		surveys = new Survey[MAXSURVEYS];
		for(int i = 0; i < MAXSURVEYS; i++) {
			surveys[i] = new Survey();
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
		
		return ret;
		
	}
	
	/**
	 * Registers a new survey to the service company's list of survey
	 * @param a The answer to the first question of the survey
	 * @param b The answer to the second question of the survey
	 * @param c The answer to the third question of the survey
	 */
	public void doSurvey(int a, int b, int c) {
		
		boolean found = false;
		for(int i = 0; i < MAXSURVEYS && !found; i++) {
			
			if(!surveys[i].getDone()) {
				surveys[i].doSurvey(a, b, c);
				found = true;
			}
		}
		
	}
	
	/**
	 * Calculates the average consumer satisfaction based on all the completed surveys
	 * @return A number between 1 and 5 representing the average consumer satisfaction with respect to the service company
	 */
	public double calculateAvgSatisfaction() {
		
		double totalAvg = 0;
		int count = 0;
		double avg = 0;
		for(Survey s : surveys) {
			if(s.getDone()) {
				totalAvg += s.calculateAverage();
				count++;
			}
		}
		
		if(count != 0) {
			avg = totalAvg / count;
		}
		
		return avg;
	}
	
	/**
	 * Reports the name of the company and the average consumer satisfaction
	 * 
	 * @return A string containing the name of the company and the average consumer satisfaction
	 */
	public String reportAvgConsumerSatisfaction() {
		
		String rprt = "";
		double avgS = calculateAvgSatisfaction();
		
		if(avgS > 0) {
			rprt = getName() + "'s average consumer satisfaction: " + avgS + "\n";
		}
		
		return rprt;
	}
}
