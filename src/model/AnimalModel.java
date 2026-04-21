package model;
import controller.AnimalController;
import com.shelter.model.*;
import java.util.*;

public class AnimalModel {

	public static ArrayList<Animal> renderAnimals() {
		return AnimalController.getAllAnimals();
	}
	
}
