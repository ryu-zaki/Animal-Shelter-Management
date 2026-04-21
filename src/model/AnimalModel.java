package model;
import controller.AnimalController;
import com.shelter.types.*;
import java.util.*;

public class AnimalModel {

	private static Animal addPendingAnimal = new Animal("", 0, AnimalType.DOG);

	public static ArrayList<Animal> renderAnimals() {
		return AnimalController.getAllAnimals();
	}

	public static void addTypeModel(String userInput) {
		try {
			AnimalType type = AnimalType.valueOf(userInput);
			addPendingAnimal.setType(type);

		}  catch(Exception err) {
              throw err;
		}
	}

	public static void addNameModel(String animalName) throws Exception {

		boolean hasDigits = animalName.matches(".*\\d.*");
		if (hasDigits) throw new Exception("Name cannot contain numbers.");

		addPendingAnimal.setName(animalName);
	}

	 public static void addAgeModel(int animalAge) throws Exception {
		if (animalAge >= 30) throw new Exception("Age could not exceed at 30");

		addPendingAnimal.setAge(animalAge);
	 }

	 public static void pushNewAnimal() {
		 AnimalController.AddAnimal(addPendingAnimal);
	 }

}
