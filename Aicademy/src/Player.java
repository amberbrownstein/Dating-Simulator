import java.util.Scanner;

public class Player {
	
	//creates a gender variable for the player (which determines which characters the player can date)
	//creates a playerName variable for the player
	//creates a single variable (once the player has been on two dates with the same character, single will be false, and the game will end)
	int gender;
	String playerName;
	static Scanner sc = Main.sc;
	
	//constructor sets the name and gender of the player
	Player(){
		getGender();
		getName();
	}
	
	// program's method for retrieving an int from the user
	// in this class because all classes have access to the Player class
	public static int getInt(int choices){
		int choice;
		while(true){
			try{
				String temp = sc.nextLine();
				choice = Integer.decode(temp);
				break;
			}
			catch(NumberFormatException e){
				System.out.println("Please input a valid number.");
			}
		}
		if(choice < 1 || choice > choices){
			System.out.println("Please input a valid number.");
			choice = getInt(choice);
		}
		return choice;
	}
	
	//sets the gender of the player
	private void getGender(){
		boolean valid = false;
		String correct;
		
		while(!valid){
			System.out.println("Please choose a gender for your character.");
			System.out.println("1: boy");
			System.out.println("2: girl");
			System.out.println("3: other");
		
			gender = getInt(3);
			
			if(gender == 1){
				System.out.println("You are a boy, correct?");
				correct = sc.nextLine();
			}
			else if(gender == 2){
				System.out.println("You are a girl, correct?");
				correct = sc.nextLine();
			}
			else{
				System.out.println("You are other, correct?");
				correct = sc.nextLine();
			}
				
			while(correct.compareTo("yes") != 0 && correct.compareTo("no") != 0){
				System.out.println("Please answer yes or no");
				correct = sc.nextLine();
			}
			
			if(correct.compareTo("yes") == 0){
				valid = true;
			}
		}
		
		sc.nextLine();
	}
	
	//sets the name of the player
	private void getName(){
		
		boolean name = false;
		
		while(!name){
			System.out.println("Please enter a name for your character.");
			playerName = sc.nextLine();
			
			System.out.println("Is " + playerName + " correct?");
			String correct = sc.nextLine();
			
			while(correct.compareTo("yes") != 0 && correct.compareTo("no") != 0){
				System.out.println("Please answer yes or no");
				correct = sc.nextLine();
			}
			
			if(correct.compareTo("yes") == 0){
				name = true;
				System.out.println("Then your name will be " + playerName + ".");
			}
		}
		
		sc.nextLine();
		
	}
}
