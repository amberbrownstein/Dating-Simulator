import java.util.Scanner;

public class Setting{
	
	// declares field variables to be used throughout the class
	boolean single = true;
	private Player user;
	private int day = 0;
	private int time = 0;
	private int location;	// 0-2: active, neutral, and passive
	private int act;		// number of actions successfully completed within the time slot, max of 2 per time
	private String active;
	private String neutral;
	private String passive;
	private Character[] chars;
	private Scanner sc;
	private Character[] speakable;
	
	// constructor takes the Player created in the main method as a parameter
	// uses scanner variable from player class
	Setting(Player p, Character[] c){
		user = p;
		chars = c;
		speakable = new Character[chars.length];
		sc = Main.sc;
		timeAndDay();
	}

	// starts the game, keeping count of time and day
	// prints the day and time
	public void timeAndDay(){
		// game ends at the end of the week or after going on 2 dates with the same character (for now)
		while(single && day < 5){		

			while(time < 3){
				// change this to switch/case
				if(day == 0)
					System.out.print("It's Monday ");
				else if(day == 1)
					System.out.print("It's Tuesday ");
				else if(day == 2)
					System.out.print("It's Wednesday ");
				else if(day == 3)
					System.out.print("It's Thursday ");
				else System.out.print("It's Friday  ");
				
				if(time == 0)
					System.out.println("before school.");
				else if(time == 1)
					System.out.println("after school.");
				else System.out.println("night.");
				
				sc.nextLine();
				
				play();

				time++;

			}			
		
			day++;
			time = 0;
	
		}
		
	}

	// retrieves the active, neutral, and passive locations specific to the given time and day
	// allows the character to talk to people or retreat to the passive location
	private void play(){
		if(time == 3){
			active = "ask someone to hang out";
			neutral = "call someone";
		}
		else switch(day){
		case 0:	active = monday();
				break;
		case 1:	active = tuesday();
				break;
		case 2:	active = wednesday();
				break;
		case 3:	active = thursday();
				break;
		case 4:	active = friday();
				break;
		}
		
		neutral = getNeutral();
		passive = getPassive();
		
		location = 0;
		act = 0;	
		
		while(act < 2 && location < 3){
			int choice = options();
			
			if(location > 0 && choice > 2){
				int temp = speakable[choice - 3].speak(time, day, location);
				if(speakable[choice - 3].dated == 2){
					single = false;
					return;
				}
				act = act + temp;
			}
		}
		
		if(time == 0){
			System.out.println("You go to class.");
			sc.nextLine();
		}
		if(time == 1){
			System.out.println("You go home.");
			sc.nextLine();
		}
		if(time == 2){
			System.out.println("You go to sleep.");
			sc.nextLine();
		}
		
	}
	
	// the following determine the active location specific to the day and time	
	private String monday(){
		if(time == 0)
			return "go to the science club meeting";
		else return "go to the anime club meeting";
	}	
	private String tuesday(){
		if(time == 0)
			return "go to the nature club meeting";
		else return "go to the music club meeting";
	}	
	private String wednesday(){
		if(time == 0)
			return "go to the video game club meeting";
		else return "go to the movie club meeting";
	}	
	private String thursday(){
		if(time == 0)
			return "go to the international club meeting";
		else return "go to the cooking club meeting";
	}	
	private String friday(){
		if(time == 0)
			return "go to the art club meeting";
		else return "go to the drama club meeting";
	}
	
	//returns the three location prompts specific to the day and time	
	private String getNeutral(){
		if(time == 0)
			return "go to the cafeteria";
		else if(time == 1)
			return "go to study hall";
		else return "call someone";
	}	
	private String getPassive(){
		if(time == 0)
			return "go to class";
		else if(time == 1)
			return "go home";
		else return "go to bed";
	}
	
	// tells the player what their choices are for actions
	// retrieves player's choice input and changes location if choice is a location
	private int options(){
		System.out.println("What would you like to do?");
		
		if(location == 0){
			System.out.println("1: " + active);
			System.out.println("2: " + neutral);
			System.out.println("3: " + passive);
		}
		else if(location == 1){
			System.out.println("1: " + neutral);
			System.out.println("2: " + passive);
		}
		else if(location == 2){
			System.out.println("1: " + active);
			System.out.println("2: " + passive);
		}
		
		int choices = getCharacters();
		
		int choice = user.getInt(choices);
		
		if(location == 0){
			if(choice < 4){
				location = choice;
			}
		}
		else if(location == 1){
			if(choice < 3){
				location = choice + 1;
			}
		}
		else if(location == 2){
			if(choice == 1){
				location = choice;
			}
			else if(choice == 2){
				location = 3;
			}
		}
		
		return choice;
	}
	
	// tells the player what their choices are in terms of characters to interact with depending on their time, day, and location
	// returns the number of total choices the player has, including location changes
	public int getCharacters(){
		int choices;
		
		if(location == 0)
			return 3;
		else choices = 2;
		
		for(int i = 0; i < chars.length; i++){
			if(time == 3){
				if(location == 1){
					choices++;
					System.out.println(choices + ": Hang out with " + chars[i].name + ".");
					speakable[choices - 3] = chars[i];
				}
				else if(location == 2){
					choices++;
					System.out.println(choices + ": Call " + chars[i].name + ".");
					speakable[choices - 3] = chars[i];
				}
			}
			else if(chars[i].present(time, day, location)){
				choices++;
				System.out.println(choices + ": Talk to " + chars[i].name + ".");
				speakable[choices - 3] = chars[i];
			}
		}
		
		return choices;
	}
}