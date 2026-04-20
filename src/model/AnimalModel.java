package model;
import controller.AnimalController;
import com.shelter.model.*;

public class AnimalModel {

	public static Animal[] renderAnimals() {
		return AnimalController.getAllAnimals();
	}
	
}
