package model;

import java.util.ArrayList;

public class Holding extends Company {

	private ArrayList<Company> companies;
	
	public Holding(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
					String dateF, String typ, String legalR) {
		
		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		companies = new ArrayList<Company>();
	}
	
	public void registerFoodCompany(String nam, String nt, String addr, String phone, int employeeN, double assetVal,
									String dateF, String typ, String legalR, String sanitationR, boolean valid, String expD,
									String cat, boolean koshr, boolean bpaC) {
		companies.add(new FoodCompany(	nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, sanitationR, valid,
										expD, cat, koshr, bpaC));
	}
	
	public void registerMedicationCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal,
											String dateF, String typ, String legalR, String sanitationR, boolean st, String expD,
											String cat) {
		companies.add(new MedicationCompany(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, sanitationR, st,
											expD, cat));
	}
	
	public void registerEducationCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
											String dateF, String typ, String legalR, int regNum, int aYears, int sRank, 
											String pName, String eduSector, int aStudents, int s12Students) {
		
		companies.add(new EducationCompany(	nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, regNum, aYears,
											sRank, pName, eduSector, aStudents, s12Students));
	}
	
	public void registerFabricationCompany(	String nam, String nt, String addr, String phone,int employeeN, double assetVal,
											String dateF, String typ, String legalR) {
		
		companies.add(new FabricationCompany(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR));
	}
	
	public void registerTechCompany(String nam, String nt, String addr, String phone,int employeeN, double assetVal,
									String dateF, String typ, String legalR, boolean[] s)   {

		companies.add(new TechCompany(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, s));
	}
	
	public void registerPublicServiceCompany(	String nam, String nt, String addr, String phone,int employeeN, double assetVal,
			String dateF, String typ, String legalR, String sTyp, int tSubs, int s12Subs) {

		companies.add(new PublicServiceCompany(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, sTyp, tSubs, s12Subs));
	}
	
	public String toString() {
		String ret = super.toString() + "\n";
		int count = 1;
		
		for(Company c : companies) {
			ret += "Company #" + count + ":\n" + c.toString() + "\n";
			count++;
		}
		
		return ret;
	}

	public void setUp() {
		
		
	}
	
	public void doSurvey(int a, int b, int c) {
		for (Company com : companies) {
			if(com.getClass().getSuperclass().getSimpleName().equals("ServiceCompany")) {
				ServiceCompany s = (ServiceCompany) com;
				s.doSurvey(a, b, c);
			}
		}
	}
	
}
