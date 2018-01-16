import java.util.Scanner;

public class Main {
	// TODO: add visuals, finish dialogue, write second date, add second week, finish then add the other characters
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// prompts the user to create a Player, and creates a Setting object
		Player p = new Player();
		Setting s = new Setting(p);
		
		// creates an array of Characters
		// length 1 for now, but will be longer once other Characters are added
		Character[]  chars = new Character[1];
		chars[0] = new Aera(s);
		
		// gives Setting class access to the characters
		s.getChars(chars);

		// begins the game
		s.timeAndDay();
		
		// prints a message when the game is over
		System.out.println("Thanks for playing!");
	}
}
