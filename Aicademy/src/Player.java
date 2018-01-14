import java.util.Scanner;

public class Player {
	
	//creates a gender variable for the player (which determines which characters the player can date)
	//creates a playerName variable for the player
	//creates a single variable (once the player has been on two dates with the same character, single will be false, and the game will end)
	public String gender;
	public String playerName;
	static Scanner sc = Main.sc;
	
	//constructor sets the name and gender of the player
	Player(){
		getGender();
		getName();
	}
	
	// program's method for retrieving an int from the user
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
		boolean trueGender = false;
		String correct;
		
		while(!trueGender){
			System.out.println("Please choose a gender for your character.");
			System.out.println("1: boy");
			System.out.println("2: girl");
			System.out.println("3: other");
		
			int valid = getInt(3);
			
			if(valid == 1){
				gender = "boy";
			}
			else if(valid == 2){
				gender = "girl";
			}
			else if(valid == 3){
				gender = "other";
			}
			
			if(valid != 3){
				System.out.println("You are a " + gender + " correct?");
				correct = sc.nextLine();
			}
			else{
				System.out.println("You are " + gender + " correct?");
				correct = sc.nextLine();
			}
				
			while(correct.compareTo("yes") != 0 && correct.compareTo("no") != 0){
				System.out.println("Please answer yes or no");
				correct = sc.nextLine();
			}
				
			if(correct.compareTo("yes") == 0){
				trueGender = true;
				System.out.println("Then your gender will be " + gender + ".");
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
