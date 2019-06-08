package model;

public class ServiceCompany extends Company{

	private Survey[] surveys;
	
	public ServiceCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
							String dateF, String typ, String legalR) {
		
		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		surveys = new Survey[50];
	
	}
	
	public String toString() {
		
		String ret = super.toString();
		
		return ret;
		
	}
	
	public void doSurvey(int a, int b, int c) {
		for(Survey s : surveys) {
			if(!s.getDone()) {
				s.doSurvey(a, b, c);
			}
		}
	}
}
