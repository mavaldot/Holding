package model;

public class ServiceCompany extends Company{

	public static final int MAXSURVEYS = 50;
	private Survey[] surveys;
	
	
	public ServiceCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
							String dateF, String typ, String legalR) {
		
		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		surveys = new Survey[MAXSURVEYS];
		for(int i = 0; i < MAXSURVEYS; i++) {
			surveys[i] = new Survey();
		}
	
	}
	
	public String toString() {
		
		String ret = super.toString();
		
		return ret;
		
	}
	
	public void doSurvey(int a, int b, int c) {
		
		boolean found = false;
		for(int i = 0; i < MAXSURVEYS && !found; i++) {
			
			if(!surveys[i].getDone()) {
				surveys[i].doSurvey(a, b, c);
				found = true;
			}
		}
		
	}
	
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
	
	public String reportAvgConsumerSatisfaction() {
		
		String rprt = "";
		double avgS = calculateAvgSatisfaction();
		
		if(avgS > 0) {
			rprt = getName() + "'s average consumer satisfaction: " + avgS + "\n";
		}
		
		return rprt;
	}
}
