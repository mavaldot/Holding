package model;

public class PublicServiceCompany extends ServiceCompany {

	private String serviceType;
	private int totalSubs;
	private int stratum1and2Subs;
	
	public PublicServiceCompany(String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
			String dateF, String typ, String legalR, String sTyp, int totalS, int s12Subs) {

		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		serviceType = sTyp;
		totalSubs = totalS;
		stratum1and2Subs = s12Subs;
	}
	
	public String toString() {
		
		String ret = super.toString();
		ret += "Service type: " + serviceType + "\n";
		ret += "Total subscribers: " + totalSubs + "\n";
		ret += "Stratum 1 and 2 subscribers: " + stratum1and2Subs + "\n";
		return ret;
		
	}
	
}
