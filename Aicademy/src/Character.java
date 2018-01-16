import java.util.Scanner;

public class Character {
	String name;			// what the character's name appears to be to the player
	int ap = 0;				// the affection point counter this character has for the player
	boolean phone = false;	// if the player has this character's phone number
	int dated = 0;			// number of dates the player has had with this character
	String previous = "";	// previous dialogue; ensures dialogue does not repeat, provided ap increases
	boolean intro = false;	// whether or not character's name is established; ensures no repeat of introduction in case of no ap increase
	Scanner sc;				// this should point to the Scanner declared in the Player class, retrieved from Setting
	Setting set;			// gives access to the following variables in the Setting class:
	int day;
	int time;
	int location;
	Player user;
	
	boolean present(int time, int day, int location){return false;}
	void speak(int time, int day, int location){}
}