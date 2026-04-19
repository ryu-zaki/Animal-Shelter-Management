package view;

import java.util.Scanner;

public class ViewUtil {
   
	public static void PressAnyKeyToContinue() {
	    System.out.println("Press ENTER key to continue...");
	    Scanner scan = new Scanner(System.in);
	    scan.nextLine();
    }
	
}
