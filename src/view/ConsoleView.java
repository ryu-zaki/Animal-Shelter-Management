package view;
import java.util.*;
import model.AnimalModel;
import com.shelter.model.*;

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
     
    public static void DisplayAllAnimals() {
    	Animal[] animals = AnimalModel.renderAnimals();
    	if (animals.length == 0) {
    		System.out.println("Animals list is empty.");
    		
    		ViewUtil.PressAnyKeyToContinue();
			DisplayMenu(); // Recursion
    		return;
    	}
    	System.out.println("Animal List:");
    	for (Animal a: animals) {
    		System.out.println(
    			 a.getName() + " | " + a.getType() + " | " + a.getAge()
    		);
    	}
    }
     
    
     
    public static void getUserChoice(int choiceNum) {
    	switch(choiceNum) {
        	case 1:
        		DisplayAllAnimals();
    		break;
    		
        	case 2:
        		
            break;
            
        	case 3: 
        		
            break;
            
        	case 4:
        		
        	break;
    	}
    	
    	
    }
	
}
