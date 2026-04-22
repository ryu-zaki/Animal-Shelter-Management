package controller;
import com.shelter.types.*;

import java.util.ArrayList;
import java.util.Optional;

public class AnimalController {
  
    private static ArrayList<Animal> animals = new ArrayList<Animal>();
	
    public static ArrayList<Animal> getAllAnimals() {;
       return animals;
    }

    public static void AddAnimal(Animal newAnimal) {
        animals.add(newAnimal); //Adding animal
    }

    public static void UpdateAnimal(String animalName, Animal animal) {

        animals.stream()
                .filter(a -> a.getName().equals(animalName))
                .findFirst()
                .ifPresent((existing -> {
                    existing.setName(animal.getName());
                    existing.setType(animal.getType());
                    existing.setAge(animal.getAge());
                }));

    }
	
}
