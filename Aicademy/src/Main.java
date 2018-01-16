import java.util.Scanner;

public class Main {
	// TODO: add visuals, finish dialogue, write second date, add second week, finish then add the other characters
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// prompts the user to create a Player
		Player p = new Player();
		
		// creates an array of Characters
		// length 1 for now, but will be longer once other Characters are added
		Character[]  chars = new Character[1];
		chars[0] = new Aera(p);
		
		//begins game
		new Setting(p, chars);
		
		// prints a message when the game is over
		System.out.println("Thanks for playing!");
	}
}
