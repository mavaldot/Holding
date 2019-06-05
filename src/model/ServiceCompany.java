package model;

public class ServiceCompany extends Company{

	public ServiceCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
							String dateF, String typ, String legalR) {
		
		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
	
	}
	
	public String registerService() {
		
		return " ";
		
	}
	
	public String toString() {
		
		String ret = super.toString();
		
		return ret;
		
	}
}
