package view;
import java.io.IOException;
import java.util.*;
import model.AnimalModel;
import com.shelter.types.*;

import view.ViewUtil;

import javax.swing.text.View;

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

	public static void displayAnimalByName(String name) {

	}

	public static void searchByNameAnimal() {
		 System.out.print("Search Name: ");
		 Scanner scan = new Scanner(System.in);
		 String name = scan.nextLine();

		 List<Animal> results = AnimalModel.filterAnimalsByName(name);
         if (results.isEmpty()) {
			 System.out.println("List is Empty. Name doesnt have a match");
		 } else {
			 results.forEach(animal -> {
				 System.out.println(animal.getName() + " | " + animal.getType() + " | " + animal.getAge());
			 });
		 }

		ViewUtil.PressAnyKeyToContinue();
		DisplayMenu(); // Recursion
	}

	public static void updateAnimalByName() {
         Scanner scan = new Scanner(System.in);
		 System.out.println("===== EDIT ANIMAL =====");
		 System.out.print("Enter animal's name: ");
		 String name = scan.nextLine();

		 Optional<Animal> targetAnimal = AnimalModel.checkIfAnimalExist(name);

		 if (targetAnimal.isPresent()) {
			 System.out.println("[1] NAME");
			 System.out.println("[2] TYPE");
			 System.out.println("[3] AGE");

			 System.out.print("Enter your choice: ");

			 String userChoice = scan.nextLine();

			 switch(userChoice) {
				 case "1":
					 System.out.print("Update your name: ");
					 String newName = scan.nextLine();
					 AnimalModel.updateName(newName);
					 break;

				 case "2":
					 System.out.print("Update your type: ");
					 String targetType = scan.nextLine();
					 AnimalType type = AnimalType.valueOf(targetType.toUpperCase());
					 AnimalModel.updateType(type);
					 break;

				 case "3":
					 System.out.print("Update your age: ");
					 int age = scan.nextInt();
					 AnimalModel.updateAge(age);
					 break;

				 default:

					 System.out.println("Option not available");
					 break;
			 }

			 System.out.println("Animal Data has been updated.");
			 ViewUtil.PressAnyKeyToContinue();
			 System.out.println("");
			 System.out.println("[1] UPDATE MORE");
			 System.out.println("[2] MENU");
			 System.out.print("Your choice: ");
			 String choice = scan.nextLine();

			 switch(choice) {
				 case "1":
					updateAnimalByName();
					scan.nextLine();
					 break;

				 case "2":
					 DisplayMenu();
					 break;
			 }


		 } else {
			 System.out.println("Animal Doesn't Exist.");
		 }

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
				searchByNameAnimal();
            break;
            
        	case 4:
				updateAnimalByName();
        	break;
    	}
    	
    	
    }
	
}
