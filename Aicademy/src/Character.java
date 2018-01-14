import java.util.Scanner;

public class Character {
	public String name;				// what the character's name appears to be to the player
	public int ap = 0;				// the affection point this character has for the player
	public boolean date;			// whether or not the player can date this character (based on gender)
	public boolean phone = false;	// if the player has this character's phone number
	public int dated = 0;			// number of dates the player has had with this character
	public String previous = "";	// previous dialogue; ensures dialogue does not repeat, provided ap increases
	boolean intro = false;			// whether or not character's name is established; ensures no repeat of introduction in case of no ap increase
	Scanner sc;						// this should point to the Scanner declared in the Player class, retrieved from Setting
	public Setting set;			// gives access to the following variables in the Setting class:
	public int day;
	public int time;
	public int location;
	public Player user;
	
	public boolean present(int time, int day, int location);
	public boolean date();
	public boolean call();
	public void speak();
}