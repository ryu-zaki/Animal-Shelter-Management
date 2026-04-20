package view;
import java.io.IOException;
import java.util.*;
import model.AnimalModel;
import com.shelter.model.*;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp.Capability;
import org.jline.utils.NonBlockingReader;

import view.ViewUtil;

public class ConsoleView {
	
	 public static int DisplayOption() {

		 String[] options = { "View All", "Add Animal", "Search by Name", "" };
         int selectedIndex = 0;

		 try(Terminal terminal = TerminalBuilder.builder().system(true).build()) {
          terminal.enterRawMode();
		  NonBlockingReader reader = terminal.reader();

		  while(true) {
			  terminal.puts(Capability.clear_screen);
			  terminal.flush();

			  for (int i= 0; i < options.length; i++) {
                  if (selectedIndex == i) {
                     System.out.println("> " + options[i] + " <");
				  } else {
					  System.out.println("  " + options[i]);
				  }
			  }

			  int read = reader.read();

			  if (read == 13 || read == 10) {
				  return selectedIndex + 1;
			  }

			  if (read == 27) {
				  int next1 = reader.read();
				  int next2 = reader.read();

				  if(next1 == '[') {
                      if (next2 == 'A') {
						  selectedIndex = (selectedIndex > 0) ? selectedIndex - 1 : options.length - 1;
					  } else {
						  selectedIndex = (selectedIndex < options.length - 1) ? selectedIndex + 1 : 0;
					  }
				  }
			  }

		  }
		  }

		 catch(IOException e) {
			 e.printStackTrace();
			 return -1;
		 }
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
