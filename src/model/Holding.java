package model;

import java.util.ArrayList;

public class Holding extends Company {

	private ArrayList<Company> companies;
	
	public Holding(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
					String dateF, String typ, String legalR) {
		
		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		companies = new ArrayList<Company>();
	}
	
	public void setUp() {
		boolean[] s = {true, false, true, true, false};
		companies.add(new TechCompany("JohanTech", "2", "Calle 5 # 120 - 25", "5556677", 10, 1000000, "1/1/1991", Company.TYPES[3], "Nahoj", 500, s));
		companies.add(new MedicationCompany("Ariza Pharmaceuticals", "1", "Calle 5 # 5 - 25", "5556677", 10, 1000000, "1/1/1991", Company.TYPES[2], "Sebastian Giraldo",
												"156463", true, "7/7/2022", "FABRICATION AND SELLING"));
		companies.add(new EducationCompany("Johan University", "3", "Calle 8 # 6 - 16", "8936145", 50, 400000, "1/3/1998", Company.TYPES[8], "Esteban Ariza",
											11334564, 20, 1, "Oetam Sedlav", "UNIVERSITY", 120, 20));
		addProduct("1", "Dolex", "12345", 100, 20);
		addProduct("1", "Ritalin", "2345", 60, 10);
		addProduct("1", "Xanax", "7654", 30, 15);
		
		addBuilding("1", 3);
		addBuilding("2", 4);
		addBuilding("3", 5);
		
		addEmployee("1", "Johan Giraldo", "CEO", "johan@gmail.com");
		addEmployee("2", "Esteban Ariza", "Pensador", "ariza@gmail.com");
		
		doSurvey("2", 4, 5, 5);
		doSurvey("2", 5, 4, 5);
		doSurvey("2", 5, 4, 5);
		doSurvey("2", 4, 5, 5);
		doSurvey("2", 2, 5, 3);
		doSurvey("2", 4, 4, 5);
		doSurvey("2", 4, 5, 4);
		doSurvey("2", 5, 4, 4);
		doSurvey("2", 4, 3, 5);
		doSurvey("2", 4, 4, 4);
		
		doSurvey("3", 3, 5, 5);
		doSurvey("3", 3, 4, 5);
		doSurvey("3", 3, 3, 5);
		doSurvey("3", 4, 5, 5);
		doSurvey("3", 2, 5, 3);
		doSurvey("3", 5, 1, 5);
		doSurvey("3", 4, 1, 4);
		doSurvey("3", 1, 5, 5);
		doSurvey("3", 4, 3, 5);
		doSurvey("3", 5, 5, 5);
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
	
	public String addBuilding(String nit, int floors) {
		String ret = "The building could not be added\n";
		boolean success = false;
		for(Company com : companies) {
			if(com.getNit().equals(nit)) {
				success =com.addBuilding(floors);
			}
		}
		
		if(success) {
			ret = "The building was added succesfully!\n";
		}
		
		return ret;
	}
	
	public String addEmployee(String nit, String name, String post, String email) {
		String ret = "The employee could not be added\n";
		boolean success = false;
		for(Company com : companies) {
			if(com.getNit().equals(nit)) {
				success = com.addEmployee(name, post, email);
			}
		}
		
		if(success) {
			ret = "The employee was added successfully!\n";
		}
		
		return ret;
	}
	
}
