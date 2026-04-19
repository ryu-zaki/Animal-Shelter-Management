package view;
import java.util.*;
import view.ViewUtil;

public class ConsoleView {
	
	 public static int DisplayOption() {
		 System.out.println("Welcome to Animal Shelter System." + "\n" +
					"[1] View All" + "\n" +
				    "[2] Add Animal" + "\n" + 
					"[3] Search by Name \n" + 
				    "[4] Update Animal \n" + 
					"[5] Exit");
		    Scanner scan = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
			
			return choice;
	 }
   
     public static void DisplayMenu() {
    
		try {
			int choice = DisplayOption();
			
			if (choice > 5 || choice == 0) {
			   	throw new Exception("");
			}
			
			getUserChoice(choice);
		} catch(Exception err) {
			 System.out.println("");
			 System.out.println("Error invalid choice \nPlease try again");
			 System.out.println("");
			 ViewUtil.PressAnyKeyToContinue();
			 DisplayMenu(); // Recursion
		}
		
	}
     
    public static int getUserChoice(int choiceNum) {
    	
         try {
        	int choice = (int) choiceNum;
        	System.out.println("Your choice: " + choice);
         }
         
         catch(Exception e) {
        	
         }
    	
    	
    	return 0;
    	
    }
	
}
