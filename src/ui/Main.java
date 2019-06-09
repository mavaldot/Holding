package ui;

import java.util.Scanner;
import model.Holding;

public class Main {

	private Scanner s;
	private Holding holding;
	
	public Main() {
		init();
	}
	
	public static void main(String args[]) {
		
		Main m = new Main();
		m.setUp();
		m.menu();

	}
	
	public void init() {
		s = new Scanner(System.in);
		holding = new Holding("Johannios Holding", "1234FA", "Calle 5 # 47 - 121", "5554646", 20, 1000000, "1/1/2000", "Holding", "Esteban Ariza");
	}
	
	public void setUp() {
		holding.setUp();
	}
	
	public void pln(String str) {
		System.out.println(str);
	}

	
	public void menu() {
		
		boolean running = true;
		
		while(running) {
			
			pln("\nWELCOME TO JOHANNIO'S HOLDING");
			pln("Please choose an option:");
			pln("1. Register a new company");
			pln("2. Show all information");
			pln("3. Display companies who pay the Procultura Tax");
			pln("4. Display companies with a tree-planting program");
			pln("5. Register a new survey");
			pln("6. Display average consumer satisfaction for each service company");
			pln("7. Add a new product to a company");
			pln("8. Add a building to a company");
			pln("9. Add an employee to a company");
			pln("10. Search for an employee's extension");
			pln("11. Exit");
			
			int choice = askInt();
			
			switch(choice) {
			
			case 1:
				pln("Please enter the type of company:");
				pln("1. Food company");
				pln("2. Medication company");
				pln("3. Education company");
				pln("4. Tech company");
				pln("5. Public service company");
				pln("6. Fabrication company");
				
				int comChoice = askInt();
				
				String 	comName = 		askString("Please enter the company's registered name");
				String 	nit = 			askString("Please enter the company's NIT");
				String 	address = 		askString("Please enter the company's address");
				String 	phoneNum = 		askString("Please enter the company's phone number");
				int 	employeeNum = 	askInt("Please the number of employees in the company");
				double 	assetValue = 	askDouble("Please enter the asset value of the company");
				String dateF = 			askString("Please enter the date the company was founded");
				int typeChoice = 		askInt("Please enter the type of organization. CHOICES:\n" + holding.showTypes()) ;
				String type = 			Holding.TYPES[typeChoice + 1];
				String 	legalRep = 		askString("Please enter the name of the company's legal representative");
				
				switch(comChoice) {
				case 1:
					
					boolean kosher = 		askBoolean("Does the company have a Kosher certificate?");
					boolean bpaCert = 		askBoolean("Does the company have a BPA certificate?");
					String sanitationReg = 	askString("Please enter the company's sanitation registry");
					boolean vld = 			askBoolean("Is the sanitation certificate currently valid?");
					String expirationDate = askString("Please enter the sanitation certificate's expiration date");
					String category = 		askString("Please enter the company's category. OPTIONS:\n"
							+ "-FABRICATE AND EXPORT\n-FABRICATE AND SELL\n-IMPORT AND SELL");
					
					holding.registerFoodCompany(comName, nit, address, phoneNum, employeeNum, assetValue,
												dateF, type, legalRep, sanitationReg, vld, expirationDate, category, 
												kosher, bpaCert);
					pln("The company was registered successfully");
					
					break;
				case 2:
					String sanitationReg2 = 	askString("Please enter the company's sanitation registry");
					boolean vld2 = 				askBoolean("Is the sanitation certificate currently valid?");
					String expirationDate2 = 	askString("Please enter the sanitation certificate's expiration date");
					String category2 = 		askString("Please enter the company's category. OPTIONS:\n"
							+ "- FABRICATE AND EXPORT\n-FABRICATE AND SELL\n-IMPORT AND SELL");
				
					holding.registerMedicationCompany(comName, nit, address, phoneNum, employeeNum, assetValue,
							dateF, type, legalRep, sanitationReg2, vld2, expirationDate2, category2);
					pln("The company was registered successfully");
				
					break;
					
				case 3:
					int regNum = 	askInt("Please enter the company's registration number given by the National Education Ministry");
					int yAcc = 		askInt("Please enter the years the company has been accredited");
					int sRank = 	askInt("Please enter the company's rank in the Saber 11 or Saber Pro examinations");
					String pName = 	askString("Please enter the principal's name");
					String sec = 	askString("Please enter the company's education sector");
					int aStu = 		askInt("Please enter the number of active students in the educational institution");
					int s12Stu = 	askInt("Please enter the number of stratum 1 ans 2 students in the educational institution");
					holding.registerEducationCompany(comName, nit, address, phoneNum, employeeNum, assetValue,
							dateF, type, legalRep, regNum, yAcc, sRank, pName, sec, aStu, s12Stu);
					pln("The company was registered successfully");
					break;
					
				case 4:
					
					double ec = askDouble("How much energy (in kilowatts) does the company use in one year?");
					boolean s1 = askBoolean("Does the company offer consulting?");
					boolean s2 = askBoolean("Does the company offer training?");
					boolean s3 = askBoolean("Does the company offer custom software development?");
					boolean s4 = askBoolean("Does the company offer infrastructure as a service?");
					boolean s5 = askBoolean("Does the company offer software as a service?");
					boolean s6 = askBoolean("Does the company offer platform as a service?");
					boolean[] s = {s1, s2, s3, s4, s5, s6};
					holding.registerTechCompany(comName, nit, address, phoneNum, employeeNum, assetValue,
							dateF, type, legalRep, ec, s);
					pln("The company was registered successfully");
					break;
					
				case 5:
					String servT = 	askString("Please enter the type of service. OPTIONS:\n"
							+ 					"- Sewage\n- Energy\n- Aqueduct\n");
					int totS = 		askInt("Please enter the number of subscribers");
					int s12su = 	askInt("Please enter the number of stratum 1 and 2 subscribers");
					holding.registerPublicServiceCompany(comName, nit, address, phoneNum, employeeNum, assetValue,
							dateF, type, legalRep, servT, totS, s12su);
					pln("The company was registered successfully");
					break;
					
				case 6:
					
					holding.registerFabricationCompany(comName, nit, address, phoneNum, employeeNum, assetValue,
							dateF, type, legalRep);
					pln("The company was registered successfully");
					
					break;
					
				default:
					pln("ERROR. Please enter a valid choice");
					break;
				}
				
				break;
				
			case 2:
				
				pln(holding.toString());
				break;
				
			case 3:
				
				pln(holding.reportProculturaTax());
				break;
				
			case 4:
				pln(holding.reportTrees());
				break;
				
			case 5:
				
				String surveyNit = askString("Please enter the company's NIT");
				pln(holding.showSurveyQuestions());
				int res1 = askInt1to5("Please enter the response to question 1");
				int res2 = askInt1to5("Please enter the response to question 2");
				int res3 = askInt1to5("Please enter the response to question 3");
				pln(holding.doSurvey(surveyNit, res1, res2, res3));
				
				break;
				
				
			case 6:
				
				pln(holding.reportAvgConsumerSatisfaction());
				break;
				
			case 7:
				
				String pNit = askString("Please enter the NIT of the company this product belongs to");
				String name = askString("Please enter the name of the product");
				String code = askString("Please enter the code of the product");
				double waterQ = askDouble("Please enter the amount of water (in liters) needed to manufacture this product");
				int units = askInt("Please enter the number of units in inventory");
				
				pln(holding.addProduct(pNit, name, code, waterQ, units));
				break; 
				
			case 8:
				
				String bNit = askString("Please enter the NIT");
				int floors = askInt("How many floors does the building have?");
				pln(holding.addBuilding(bNit, floors));
				break;
				
			case 9:
				
				String emNit = askString("Please enter the NIT of the company");
				String emName = askString("Please enter the employee's name");
				String emPost = askString("Please enter the employee's post");
				String emEmail = askString("Please enter the employee's email");
				pln(holding.addEmployee(emNit, emName, emPost, emEmail));
				break;
				
			case 10:
				
				String sNit = askString("Please enter the company's NIT");
				String sName = askString("Please enter the employee's name");
				int sChoice = askInt("Please enter the type of search. OPTIONS:\n"
						+ "1. L SEARCH\n2. Z SEARCH\n3. X SEARCH\n4. O SEARCH\n5. E SEARCH\n6. ROW SPIRAL SEARCH\n7. COLUMN SPIRAL SEARCH\n");
				pln(holding.search(sNit, sName, sChoice));
				
				break;
				
			case 11:
				
				pln("Goodbye!");
				running = false;
				break;
				
			default:
					pln("ERROR. Please enter a valid choice.");
					break;
				
			}
			
			
		}
		
	}
	
	public String askString(String prompt) {
		pln(prompt);
		String ret = s.nextLine();
		
		return ret;
	}
	
	public int askInt(String prompt) {
		boolean asking = true;
		int ret = 0;
		
		while(asking) {
			pln(prompt);
			String str = s.nextLine();
			try {
				ret = Integer.parseInt(str);
				asking = false;
			} catch (NumberFormatException e) {
				pln("ERROR. Please enter a number.");
			}

		}
		
		return ret;
	}
	
	public int askInt() {
		boolean asking = true;
		int ret = 0;
		
		while(asking) {
			String str = s.nextLine();
			try {
				ret = Integer.parseInt(str);
				asking = false;
			} catch (NumberFormatException e) {
				pln("ERROR. Please enter a number.");
			}

		}
		
		return ret;
	}
	
	public int askInt1to5(String prompt) {
		boolean asking = true;
		int ret = 0;
		
		while(asking) {
			pln(prompt);
			String str = s.nextLine();
			try {
				ret = Integer.parseInt(str);
				if(ret >= 1 && ret <= 5)
					asking = false;
				else
					pln("ERROR. Please enter a number between 1 and 5");
			} catch (NumberFormatException e) {
				pln("ERROR. Please enter a number.");
			}

		}
		
		return ret;
	}
	
	public double askDouble(String prompt) {
		boolean asking = true;
		double ret = 0;
		
		while(asking) {
			pln(prompt);
			String str = s.nextLine();
			try {
				ret = Double.parseDouble(str);
				asking = false;
			} catch (NumberFormatException e) {
				pln("ERROR. Please enter a number.");
			}

		}
		
		return ret;
	}
	
	public boolean askBoolean(String prompt) {
		boolean asking = true;
		int choice = 0;
		boolean ret = false;
		
		while(asking) {
			pln(prompt);
			pln("1. Yes");
			pln("2. No");
			String str = s.nextLine();
			try {
				choice = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				pln("ERROR. Please enter a number.");
			}
			
			switch(choice) {
			
			case 1:
				ret = true;
				asking = false;
				break;
			case 2:
				asking = false;
				break;
			default:
				pln("ERROR. Please enter 1 or 2.");
				break;
			
			}

		}
		
		return ret;
	}
	
}
