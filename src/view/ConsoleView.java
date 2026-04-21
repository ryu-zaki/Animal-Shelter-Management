package view;
import java.util.*;
import model.AnimalModel;
import com.shelter.types.*;

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
			 System.out.println(err.getMessage().isEmpty() ? "Error invalid choice \nPlease try again" : err.getMessage());
			 System.out.println("");
			 ViewUtil.PressAnyKeyToContinue();
			 DisplayMenu(); // Recursion
		}
		
	}
     
    public static void DisplayAllAnimals() {
    	ArrayList<Animal> animals = AnimalModel.renderAnimals();
    	if (animals.isEmpty()) {
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

	public static void AddAnimalView() {
		 System.out.flush();
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Add New Animal");
		 System.out.println("====================");
		 AddOptions[] options = {AddOptions.TYPE, AddOptions.NAME, AddOptions.AGE};

		 for (int i = 0; i < options.length; i++) {
			 AddOptions option = options[i];

			 System.out.print("Enter " + option.getDescription() + " :");

			 switch(option) {

				 case AddOptions.TYPE:
					 String animalType = scan.nextLine();
					 try {
						 AnimalModel.addTypeModel(animalType);
					 } catch(Exception err) {
						 System.out.println(err.getMessage());
						 i--;
					 }
				 break;


				 case AddOptions.NAME:
					 String animalName = scan.nextLine();
					 try {
						 AnimalModel.addNameModel(animalName);
					 } catch(Exception err) {
						 System.out.println(err.getMessage());
						i--;
					 }
                 break;

				 case AddOptions.AGE:
					 try {
						 int animalsAge = scan.nextInt();

						 try {
							 AnimalModel.addAgeModel(animalsAge);
						 } catch(Exception err) {
							 System.out.println(err.getMessage());
							 i--;
						 }
					 }

					 catch(Exception err) {
						 System.out.println("Age must be an Integer.");
						 scan.nextLine();
						 i--;
					 }
					 break;
			 }
		 }
         AnimalModel.pushNewAnimal();
		 System.out.println("NEW ANIMAL HAS BEEN ADDED.");
		ViewUtil.PressAnyKeyToContinue();
		DisplayMenu(); // Recursion
	}
    
     
    public static void getUserChoice(int choiceNum) {
    	switch(choiceNum) {
        	case 1:
        		DisplayAllAnimals();
    		break;
    		
        	case 2:
				AddAnimalView();
				break;
        	case 3: 
        		
            break;
            
        	case 4:
        		
        	break;
    	}
    	
    	
    }
	
}
