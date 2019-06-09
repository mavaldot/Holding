package model;

import java.util.ArrayList;

/**
 * Models a holding i.e. a company that owns other companies.
 * 
 * @author Mateo Valdes
 *
 */
public class Holding extends Company {

	private ArrayList<Company> companies;
	
	/**
	 * Class constructor.
	 * <p>
	 * post: The companies ArrayList is initialized
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
	public Holding(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
					String dateF, String typ, String legalR) {
		
		super(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR);
		companies = new ArrayList<Company>();
	}
	
	/**
	 * Sets up the variables requiered to evaluate the proper execution of the program.
	 * <p>
	 * post: A new TechCompany is added to the list of companies <br>
	 * post: A new MedicationCompany is added to the list of companies <br>
	 * post: A new EducationCompany is added to the list of companies <br>
	 * post: A new building is added to the TechCompany <br>
	 * post: A new building is added to the MedicationCompany <br>
	 * post: A new building is added to the EducationCompany <br>
	 * post: A new employee is added to the EducationCompany <br>
	 * post: A new employee is added to the MedicationCompany <br>
	 * post: A new employee is added to the TechCompany <br>
	 * post: Various surveys are now registered in the TechCompany and the EducationCompany <br>
	 */
	public void setUp() {
		boolean[] s = {true, false, true, true, false};
		companies.add(new TechCompany("JohanTech", "2", "Calle 5 # 120 - 25", "5556677", 10, 1000000, "1/1/1991", Company.TYPES[3], "Nahoj", 500, s));
		companies.add(new MedicationCompany("Ariza Pharmaceuticals", "1", "Calle 5 # 5 - 25", "5554343", 10, 1000000, "1/1/1991", Company.TYPES[2], "Sebastian Giraldo",
												"156463", true, "7/7/2022", "FABRICATION AND SELLING"));
		companies.add(new EducationCompany("Johan University", "3", "Calle 8 # 6 - 16", "8936145", 50, 400000, "1/3/1998", Company.TYPES[8], "Esteban Ariza",
											11334564, 20, 1, "Oetam Sedlav", "UNIVERSITY", 120, 20));
		addProduct("1", "Dolex", "12345", 100, 20);
		
		addBuilding("1", 3);
		addBuilding("2", 4);
		addBuilding("3", 5);
		
		addEmployee("1", "Nahoj", "CEO", "nahoj1234@gmail.com");
		addEmployee("2", "Ariza", "Pensador", "ariza.correo@gmail.com");
		addEmployee("3", "Pepe", "Asistente Personal", "pepe4321@gmail.com");
		
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
	
	/**
	 * Adds a new food company to the holding's list of companies
	 * <p>
	 * post: a food company is initialized and added to the holding's companies ArrayList
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
	 * @param sanitationR The sanitation registry of the company
	 * @param valid Whether the sanitation registry of the company is currently valid
	 * @param expD The expiration date of the sanitation registry of the company
	 * @param cat The category of the company
	 * @param koshr Whether the company has a kosher certificate
	 * @param bpaC Whether the company has a BPA certificate
	 */
	public void registerFoodCompany(String nam, String nt, String addr, String phone, int employeeN, double assetVal,
									String dateF, String typ, String legalR, String sanitationR, boolean valid, String expD,
									String cat, boolean koshr, boolean bpaC) {
		companies.add(new FoodCompany(	nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, sanitationR, valid,
										expD, cat, koshr, bpaC));
	}
	
	/**
	 * Adds a new medication company to the holding's list of companies
	 * <p>
	 * post: a medication company is initialized and added to the holding's companies ArrayList
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
	 * @param sanitationR The sanitation registry of the company
	 * @param valid Whether the sanitation registry of the company is currently valid
	 * @param expD The expiration date of the sanitation registry of the company
	 * @param cat The category of the company
	 */
	public void registerMedicationCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal,
											String dateF, String typ, String legalR, String sanitationR, boolean st, String expD,
											String cat) {
		companies.add(new MedicationCompany(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, sanitationR, st,
											expD, cat));
	}
	
	/**
	 * Adds a new education company to the holding's list of companies
	 * <p>
	 * post: an education company is initialized and added to the holding's companies ArrayList
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
	 * @param regNum The registry number of the company given by the National Education Ministry
	 * @param aYears The number of years the company has been accredited
	 * @param sRank The Saber11/SaberPro rank
	 * @param pName The name of the principal
	 * @param eduSector The education sector that the company is in
	 * @param aStudents The total number of active students within the company
	 * @param s12Students The number of stratum 1 and 2 students in the company
	 */
	public void registerEducationCompany(	String nam, String nt, String addr, String phone, int employeeN, double assetVal, 
											String dateF, String typ, String legalR, int regNum, int aYears, int sRank, 
											String pName, String eduSector, int aStudents, int s12Students) {
		
		companies.add(new EducationCompany(	nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, regNum, aYears,
											sRank, pName, eduSector, aStudents, s12Students));
	}
	
	/**
	 * Adds a new fabrication company to the holding's list of companies
	 * <p>
	 * post: a fabrication company is initialized and added to the holding's companies ArrayList
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
	public void registerFabricationCompany(	String nam, String nt, String addr, String phone,int employeeN, double assetVal,
											String dateF, String typ, String legalR) {
		
		companies.add(new FabricationCompany(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR));
	}
	
	/**
	 * Adds a new tech company to the holding's list of companies
	 * <p>
	 * post: a tech company is initialized and added to the holding's companies ArrayList
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
	 * @param ec The energy consumed by the company (in kilowatts)
	 * @param s An array of the services the company performs
	 */
	public void registerTechCompany(String nam, String nt, String addr, String phone,int employeeN, double assetVal,
									String dateF, String typ, String legalR, double ec, boolean[] s)   {

		companies.add(new TechCompany(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, ec, s));
	}
	
	/**
	 * Adds a new public service company to the holding's list of companies
	 * <p>
	 * post: a service company is initialized and added to the holding's companies ArrayList
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
	 * @param tSubs The total number of subscribers the company has
	 * @param s12Subs The number of stratum 1 and 2 the company has
	 */
	public void registerPublicServiceCompany(	String nam, String nt, String addr, String phone,int employeeN, double assetVal,
			String dateF, String typ, String legalR, String sTyp, int tSubs, int s12Subs) {

		companies.add(new PublicServiceCompany(nam, nt, addr, phone, employeeN, assetVal, dateF, typ, legalR, sTyp, tSubs, s12Subs));
	}
	
	/**
	 * Returns a String with all the important available attributes and information of this company.
	 * Includes the information inherited from its superclass.
	 * 
	 * @return A String with all the available attributes of this company
	 */
	public String toString() {
		String ret = super.toString() + "\n";
		int count = 1;
		
		for(Company c : companies) {
			ret += "Company #" + count + ":\n" + c.toString() + "\n";
			count++;
		}
		
		return ret;
	}

	/**
	 * Displays all the survey questions defined in the class Survey
	 * 
	 * @return A String listing all the survey questions
	 */
	public String showSurveyQuestions() {
		int count = 1;
		String ret = "SURVEY QUESTIONS:\n";
		for(String ques : Survey.QUESTIONS) {
			ret += count + ". " + ques + "\n";
			count++;
		}
		
		return ret;
	}
	
	/**
	 * Fills out a survey in the service company with the NIT entered. If the company cannot be found or the survey
	 * cannot be completed, it notifies the user that the survey could not be done successfully.
	 * 
	 * @param nit The NIT of the company whose survey is going to be registered
	 * @param a The answer to the first question
	 * @param b The answer to the second question
	 * @param c The answer to the third question
	 * @return A String notifying the user whether the survey was successfully registered
	 */
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
	
	/**
	 * Adds a product to a fabrication company with the NIT entered. If the product cannot be 
	 * added, it notifies the user.
	 * 
	 * @param nit The NIT of the fabrication company whose product will be added 
	 * @param nam The name of the product
	 * @param cod The code of the product
	 * @param waterQ The water quantity (in liters) needed to manufacture the product
	 * @param unts The amount of units of the product available
	 * @return A message indicating whether the product was added successfully
	 */
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
	
	/**
	 * Gives a report of the trees that all applicable companies in the holding must plant.
	 * 
	 * @return A string with the names of all the companies that must plant trees and how many trees they must plant
	 */
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
	
	/**
	 * Gives a report of all applicable companies in the holding that must pay procultura tax and their tax percentage.
	 * 
	 * @return A string with the names of all the companies that must pay the procultura tax and the
	 * percentage they must pay
	 */
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
	
	/**
	 * Gives a report of the average consumer satisfaction of all the service companies in the holding. The service
	 * companies must first register their surveys.
	 * 
	 * @return A string with the average consumer satisfaction of all the service companies
	 */
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
	
	/**
	 * Adds a building to the company with a specified number of floors
	 * 
	 * @param nit The NIT of the company whose building will be added
	 * @param floors The number of floors in the building
	 * @return Whether the buidling could be added to the company successfully
	 */
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
	
	/**
	 * Adds a new employee to the company with the specified NIT
	 * 
	 * @param nit The NIT of the company
	 * @param name The name of the employee
	 * @param post The post of the employee
	 * @param email The email of the employee
	 * @return A message indicating whether the employee was added successfully
	 */
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
	
	/**
	 * Searches for the extension of an employee of a company given their name
	 * 
	 * @param nit The NIT of the company where the employee works
	 * @param name The name of the employee
	 * @param mode The mode of search (L, Z, X, O, E, row spiral and column spiral)
	 * 
	 * @return
	 */
	public String search(String nit, String name, int mode) {
		String ret = "ERROR. Could not find the company";
		
		if(getNit().equals(nit)) {
			ret = search(name, mode);
		}
		
		for(Company com : companies) {
			if(com.getNit().equals(nit)) {
				ret = com.search(name, mode);
			}
		}
		
		return ret;
	}
	
}
