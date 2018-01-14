import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	// TODO: make it so that the Characters can be read and created from a file
	// fix the Character class so that it can contain method declarations
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("characters.txt"));
		
		// prompts the user to create a Player, and creates a Setting object
		Player p = new Player();
		Setting s = new Setting(p);
		
		// creates an array of Characters, retrieving the length and Characters from a text file
		Character[]  chars = new Character[Integer.parseInt(br.readLine())];
		
		for(int i = 0; i < chars.length; i++){
			String temp = br.readLine();
			chars[i] = new temp(s);
		}
		
		br.close();
		
		// gives Setting class access to the characters
		s.getChars(chars);

		// begins the game
		s.timeAndDay();
		
		// prints a message when the game is over
		System.out.println("Thanks for playing!");
	}
}
