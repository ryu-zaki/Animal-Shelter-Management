package controller;
import com.shelter.types.*;

import java.util.ArrayList;

public class AnimalController {
  
    private static ArrayList<Animal> animals = new ArrayList<Animal>();
	
    public static ArrayList<Animal> getAllAnimals() {;
       return animals;
    }

    public static void AddAnimal(Animal newAnimal) {
        animals.add(newAnimal); //Adding animal
    }
	
}
