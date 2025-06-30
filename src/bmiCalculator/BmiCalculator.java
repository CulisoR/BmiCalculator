package bmiCalculator;

import java.util.Scanner;
import java.util.Locale;

public class BmiCalculator {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the BMI calculator!");
		
		String intro = " Welcome to the BMI calculator:";
		System.out.println("");
		
		System.out.println("                     PERSONAL DETAILS:   ");
		System.out.println("");
		
		System.out.print("Please enter user Name: ");
		
		String userName = scanner.nextLine();
		
		//System.out.println(userName);
		
		System.out.print("Please enter your Surname: ");
		
		String Surname = scanner.nextLine();
		
		//System.out.println(Surname);
		
		
		System.out.print("Are you ? (Female|Male):");
		
		String gender = scanner.nextLine();
		
		//System.out.println(gender);
		
		int age;
		while (true) {
			System.out.print ("Enter your age:  ");
			if (scanner.hasNextInt()) {
				age = scanner.nextInt();
				if (age > 0 && age <= 105) {
					break;
				}else {
					System.out.println("Please enter your age between 1 and 105.");
				}
			}else {
				System.out.println("invalid input. Please enter a valid number");
				
				scanner.next();
				
				System.out.println("");
				
			}
		}
		scanner.nextLine();
		String IdNumber;
		while (true) {
			System.out.print("Enter your Identification Number:  ");
			IdNumber = scanner.nextLine();
			if (IdNumber.matches("\\d{13}")) {
				break;
			}else {
				System.out.println("Invalid id number. It must be exactly 13 digits");
			
				System.out.println("***************************************");
			}
		}
		scanner.useLocale(Locale.US);
		
		String repeat;
		
		do {
		// All Our code
			int unitChoice = getUnitChoice(scanner);
		
			double weight = (unitChoice == 1) ? getValidInput(scanner, "Enter your weight in kilograms : " , 10, 600)
                   : getValidInput(scanner, "Enter your weight in pounds", 22, 1300);
			
                   double height = ( unitChoice == 1) ? getValidInput(scanner, "Enter your height in meters: ",0.5, 2.5)
                		   : getValidInput(scanner, "Enter your height in inches", 20 , 100);
                   
                   
                   double bmi = calculateBMI(unitChoice, weight, height);
           
                 System.out.println("Your BMI is : " + String.format("%.1f", bmi)); 
                 
                 System.out.println("");
                 
                 System.out.println("***********************************************************");
                 
                 // Print Report
                 System.out.println("          BMI REPORT:   ");
                 System.out.println("Name: "  + userName);
                 System.out.println("Surname: "  + Surname);
                 System.out.println("gender:  " + gender);
                 System.out.println("age: "  + age);
                 System.out.println("IdNumber:"  + IdNumber);
                 System.out.println("Weight: "  + weight);
                 System.out.println("Height:  " + height);
                 System.out.println("BMI Score: " + String.format("%.1f", bmi) );
                 
                 
                   String category;
                 
                 	 if (bmi < 18.5) {
                 	 category = "Under Weight";
                  }else if (bmi < 25) {
                 	 category = "Normal Weight";
                  }else if (bmi < 30) {
                 	 category = "Over Weight";
                  }else { 
                 	 category = "Obese";
	}
                 	 
                  System.out.println("You are classified as:  " + category);
                  
                  String advice;
                  
                  switch (category) {
               	   case "Under Weight":
               		    advice = "Consider eating more nutritious food.";
               		   System.out.println("Advice: " +  advice);
               		   break;
               	   case "Normal Weight":
               		   advice = "keep up the healthy lifestyle!";
               		   System.out.println("Advice: " +  advice);
               		   break;
               	   case "Over Weight":
               	   advice = "Try to include regular exercise in your routine.";
               	   System.out.println("Advice: " +  advice);
               	   break;
               	   case "Obese":
               		   advice = "Speak to a healthcare provider for guidance";
               		   System.out.println("Advice :"  +  advice);
               		   break;
               		   default:
               			   advice = "";
                  }
             System.out.println("**********************************************************************");
     
                   //repeat = askToRepeat(scanner);
                 scanner.nextLine();
                 System.out.println("Do you want to calculate again:?");
                 repeat  = scanner.nextLine();
                 
    
		
		} while(repeat.equalsIgnoreCase("Yes"));
		
		scanner.close();
		
   }
      

	// Unit - Metric and Imperial
	public static int getUnitChoice(Scanner scanner) {
		System.out.println("");
		int choice;
		
		while(true) {
			System.out.println("Select a preferred unit:\n"
					+" 1. Metric (kg, m)\n"
					+"2. Imperial(lbs, in)\n"
					+ "Please select either option 1 or option 2");
			
			if(scanner.hasNextInt()) {
				choice = scanner.nextInt();
				if(choice == 1 || choice == 2) {
					break;
				} else {
					System.out.println("Invalid choice. Please enter either 1 or 2");
				}
			} else {
				System.out.println("Invalid input. Please enter a number(1 or 2");
				scanner.next();
			
			}
		} 
		return choice;
		
	}
	
	public static double getValidInput(Scanner scanner, String prompt, double min, double max) {
		double value;
		
		while(true) {
			System.out.println(prompt);
			
			if (scanner.hasNextDouble()) {
				value = scanner.nextDouble();
				if (value >= min && value <= max) {
					break;
				} else {
					System.out.printf("Please enter a value between %.if and %.if./n", min, max);
				}
			} else {
				System.out.println("Invalid input. please enter a value");
				//scanner.next();
			}
			
			
		}
		return value;
	
	}

	public static double calculateBMI(int unitChoice,double weight,double height) {
		double totalBMI;
		
		if(unitChoice == 1) {
			totalBMI = weight / (height * height);
			
		} else {
			totalBMI = (703 * weight) / ( height / height);
			
		}
		
		return totalBMI;
		
	}
		
	}
	


