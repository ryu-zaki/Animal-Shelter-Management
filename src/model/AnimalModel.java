package model;
import controller.AnimalController;
import com.shelter.types.*;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalModel {

	private static Animal addPendingAnimal = new Animal("", 0, AnimalType.DOG);

	public static ArrayList<Animal> renderAnimals() {
		return AnimalController.getAllAnimals();
	}

	public static List<Animal> filterAnimalsByName(String searchedName) {
	   	return AnimalController.getAllAnimals().stream()
				.filter(animal -> animal.getName().contains(searchedName))
				.collect(Collectors.toList());
	}

	public static void addTypeModel(String userInput) throws Exception {
		try {
			AnimalType type = AnimalType.valueOf(userInput.toUpperCase());
			addPendingAnimal.setType(type);

		}  catch(Exception err) {
              throw new Exception("Animal Type not available");
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
