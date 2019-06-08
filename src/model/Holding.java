package model;

import java.util.ArrayList;

public class Holding extends Company implements ProculturaTax {

	public double calculateProculturaTax() {
		// TODO Auto-generated method stub
		return 0;
	}
	
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
									String dateF, String typ, String legalR, double ec, boolean[] s)   {

		companies.add(new TechCompany(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, ec, s));
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
	
	public String showSurveyQuestions() {
		int count = 1;
		String ret = "SURVEY QUESTIONS:\n";
		for(String ques : Survey.QUESTIONS) {
			ret += count + ". " + ques + "\n";
			count++;
		}
		
		return ret;
	}
	
	public String doSurvey(String nit, int a, int b, int c) {
		boolean found = false;
		String ret = "ERROR. Could not do the survey successfully.";
		for (Company com : companies) {
			if(com.getClass().getSuperclass().getSimpleName().equals("ServiceCompany")) {
				if(com.getNit().equals(nit)) {
					ServiceCompany s = (ServiceCompany) com;
					s.doSurvey(a, b, c);
					found = true;
				}
			}
		}
		
		if(found)
			ret = "The company's survey was done successfully.";
		
		return ret;
	}
	
	public String addProduct(String nit, String nam, String cod, double waterQ, int unts) {
		
		String ret = "ERROR. Could not add the product.";
		boolean found = false;
		for(Company com : companies) {
			if(com.getNit().equals(nit)) {
				if(com instanceof FabricationCompany) {
					FabricationCompany f = (FabricationCompany) com;
					f.addProduct(nam, cod, waterQ, unts);
					found = true;
				}
			}
		}
		
		if(found)
			ret = "The product was added successfully!";
		
		return ret;
	}
	
	public String reportTrees() {
		String rprt = "";
		for (Company com : companies) {
			if(com instanceof MedicationCompany) {
				MedicationCompany m = (MedicationCompany) com;
				rprt += m.reportTrees();
			} else if(com instanceof TechCompany) {
				TechCompany t = (TechCompany) com;
				rprt += t.reportTrees();
			}
		}
		
		return rprt;
	}
	
	public String reportProculturaTax() {
		String rprt = "";
		
		for (Company com : companies) {
			if(com instanceof EducationCompany) {
				EducationCompany e = (EducationCompany) com;
				rprt += e.reportProculturaTax();
			} else if(com instanceof PublicServiceCompany) {
				PublicServiceCompany p = (PublicServiceCompany) com;
				rprt += p.reportProculturaTax();
			}
		}
		
		return rprt;
	}
	
	public String reportAvgConsumerSatisfaction() {
		
		String rprt = "";
		
		for (Company com : companies) {
			if(com instanceof ServiceCompany) {
				ServiceCompany s = (ServiceCompany) com;
				 rprt += s.reportAvgConsumerSatisfaction();
			}
		}
		
		return rprt;
	}
	
}
