import java.util.Scanner;

public class Setting1{
	
	// declares field variables to be used throughout the class
	// public variables are used in other classes (generally Characters)
	// for now at least, rather than using getter methods for these variables
	public Player user;
	public int i;			// number of actions successfully completed within the time slot
	public int day = 0;		// max of 2 actions per time, characters need to reduce i if action is unsuccessful
	public int time = 0;
	public int location;	// 0-2: active, neutral, and passive
	private String active;
	private String neutral;
	private String passive;
	public String gender;
	public String playerName;
	public boolean single = true;
	
	// declares characters so this class can have access to the characters that were created in the main method
	Aera aE;
/*	Antimony aN;
	Arnold aR;
	Bart bA;
	Chrysanthemum cH;
	Crystal cR;
	Deni dE;
	Heartless hE;
	Izzy iZ;
	Kat kA;
	Maggie mA;
	Sammie sA;
*/	
	// creates instance of scanner class to be used across class
	Scanner sc;
	
	// constructor takes the Player created in the main method as a parameter and sets field variables:
	// user, gender, and playerName as appropriate
	Setting1(Player p){
		user = p;
		gender = user.gender;
		playerName = user.playerName;
		sc = user.sc;
	}

	// sets characters declared above to the characters created in the main method
	public void getAE(Aera aer){
		aE = aer;
	}
/*	public void getAN(Antimony ant){
		aN = ant;
	}
	public void getAR(Arnold arn){
		aR = arn;
	}
	public void getBA(Bart bar){
		bA = bar;
	}
	public void getCH(Chrysanthemum chr){
		cH = chr;
	}
	public void getCR(Crystal cry){
		cR = cry;
	}
	public void getDE(Deni den){
		dE = den;
	}
	public void getHE(Heartless hea){
		hE = hea;
	}
	public void getIZ(Izzy izz){
		iZ = izz;
	}
	public void getKA(Kat kat){
		kA = kat;
	}
	public void getMA(Maggie mag){
		mA = mag;
	}
	public void getSA(Sammie sam){
		sA = sam;
	}
*/	
	// starts the game, keeping count of time and day
	// prints the day and time
	public void timeAndDay(){
		while(single && day < 5){		

			while(time < 3){

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
		if(time == 3)
			active = "ask someone to hang out";
		else switch(day){
		case 0:	active = monday();
		case 1:	active = tuesday();
		case 2:	active = wednesday();
		case 3:	active = thursday();
		case 4:	active = friday();
		}
		
		neutral = getNeutral();
		passive = getPassive();
		
		location = 0;
		i = 0;	
		
		while(i < 2 && location < 3){
			int choice = options();
			
			if(location > 0 && choice > 2){
				dialogue(choice);
				i++;
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
	
	//tells the player what their choices are in terms of characters to interact with depending on their time, day, and location
	//returns the number of total choices the player has, including location changes
	public int getCharacters(){
		int choices;
		
		if(location == 0)
			return 3;
		else choices = 2;
		
		if(time == 0){
			if(day == 0){
				if(location == 1){
					System.out.println("3: Talk to " + aE.name + ".");
					choices++;
/*					System.out.println("4: Talk to " + aN.name + ".");
					choices++;
					System.out.println("5: Talk to " + aR.name + ".");
					choices++;
					System.out.println("6: Talk to " + cR.name + ".");
					choices++;
					System.out.println("7: Talk to " + hE.name + ".");
					choices++;
					System.out.println("8: Talk to " + mA.name + ".");
					choices++;
				}
				else if(location == 2){
					System.out.println("3: Talk to " + bA.name + ".");
					choices++;
					System.out.println("4: Talk to " + cH.name + ".");
					choices++;
					System.out.println("5: Talk to " + dE.name + ".");
					choices++;
					System.out.println("6: Talk to " + iZ.name + ".");
					choices++;
					System.out.println("7: Talk to " + kA.name + ".");
					choices++;
					System.out.println("8: Talk to " + sA.name + ".");
					choices++;
*/				}
			}
			else if(day == 1){
				if(location == 1){
					System.out.println("3: Talk to " + aE.name + ".");
					choices++;
/*					System.out.println("4: Talk to " + aN.name + ".");
					choices++;
					System.out.println("5: Talk to " + cR.name + ".");
					choices++;
					System.out.println("6: Talk to " + dE.name + ".");
					choices++;
					System.out.println("7: Talk to " + mA.name + ".");
					choices++;	
				}
				else if(location == 2){
					System.out.println("3: Talk to " + aR.name + ".");
					choices++;
					System.out.println("4: Talk to " + bA.name + ".");
					choices++;
					System.out.println("5: Talk to " + cH.name + ".");
					choices++;
					System.out.println("6: Talk to " + hE.name + ".");
					choices++;
					System.out.println("7: Talk to " + iZ.name + ".");
					choices++;
					System.out.println("8: Talk to " + kA.name + ".");
					choices++;
					System.out.println("9: Talk to " + sA.name + ".");
					choices++;
*/				}
			}
			else if(day == 2){
				if(location == 1){
					System.out.println("3: Talk to " + aE.name + ".");
					choices++;
/*					System.out.println("4: Talk to " + aR.name + ".");
					choices++;
					System.out.println("5: Talk to " + bA.name + ".");
					choices++;
					System.out.println("6: Talk to " + cR.name + ".");
					choices++;
					System.out.println("7: Talk to " + kA.name + ".");
					choices++;
					System.out.println("8: Talk to " + hE.name + ".");
					choices++;
				}
				else if(location == 2){
					System.out.println("3: Talk to " + aN.name + ".");
					choices++;
					System.out.println("4: Talk to " + cH.name + ".");
					choices++;
					System.out.println("5: Talk to " + dE.name + ".");
					choices++;
					System.out.println("6: Talk to " + iZ.name + ".");
					choices++;
					System.out.println("7: Talk to " + mA.name + ".");
					choices++;
					System.out.println("8: Talk to " + sA.name + ".");
					choices++;
*/				}
			}
			else if(day == 3){
				if(location == 1){
					System.out.println("3: Talk to " + aE.name + ".");
					choices++;
/*					System.out.println("4: Talk to " + aN.name + ".");
					choices++;
					System.out.println("5: Talk to " + aR.name + ".");
					choices++;
					System.out.println("6: Talk to " + cH.name + ".");
					choices++;
					System.out.println("7: Talk to " + cR.name + ".");
					choices++;
				}
				else if(location == 2){
					System.out.println("3: Talk to " + bA.name + ".");
					choices++;
					System.out.println("4: Talk to " + dE.name + ".");
					choices++;
					System.out.println("5: Talk to " + hE.name + ".");
					choices++;
					System.out.println("6: Talk to " + iZ.name + ".");
					choices++;
					System.out.println("7: Talk to " + kA.name + ".");
					choices++;
					System.out.println("8: Talk to " + mA.name + ".");
					choices++;
					System.out.println("9: Talk to " + sA.name + ".");
*/					choices++;
				}
			}
			else if(day == 4){
				if(location == 1){
/*					System.out.println("3: Talk to " + aN.name + ".");
					choices++;
					System.out.println("4: Talk to " + bA.name + ".");
					choices++;
					System.out.println("5: Talk to " + cH.name + ".");
					choices++;
					System.out.println("6: Talk to " + cR.name + ".");
					choices++;
					System.out.println("7: Talk to " + dE.name + ".");
					choices++;
					System.out.println("8: Talk to " + iZ.name + ".");
					choices++;
					System.out.println("9: Talk to " + kA.name + ".");
					choices++;
					System.out.println("10: Talk to " + mA.name + ".");
					choices++;
*/				}
				else if(location == 2){
					System.out.println("3: Talk to " + aE.name + ".");
					choices++;
/*					System.out.println("4: Talk to " + aR.name + ".");
					choices++;
					System.out.println("5: Talk to " + hE.name + ".");
					choices++;
					System.out.println("6: Talk to " + sA.name + ".");
					choices++;
*/				}
			}
		}
		else if(time == 1){
			if(day == 0){
				if(location == 1){
					System.out.println("3: Talk to " + aE.name + ".");
					choices++;
/*					System.out.println("4: Talk to " + aN.name + ".");
					choices++;
					System.out.println("5: Talk to " + aR.name + ".");
					choices++;
					System.out.println("6: Talk to " + bA.name + ".");
					choices++;
					System.out.println("7: Talk to " + cH.name + ".");
					choices++;
					System.out.println("8: Talk to " + cR.name + ".");
					choices++;
					System.out.println("9: Talk to " + iZ.name + ".");
					choices++;
					System.out.println("10: Talk to " + kA.name + ".");
					choices++;
				}
				else if(location == 2){
					System.out.println("3: Talk to " + dE.name + ".");
					choices++;
					System.out.println("4: Talk to " + hE.name + ".");
					choices++;
					System.out.println("5: Talk to " + mA.name + ".");
					choices++;
					System.out.println("6: Talk to " + sA.name + ".");
					choices++;
*/				}
			}
			else if(day == 1){
				if(location == 1){
					System.out.println("3: Talk to " + aE.name + ".");
					choices++;
/*					System.out.println("4: Talk to " + aN.name + ".");
					choices++;
					System.out.println("5: Talk to " + aR.name + ".");
					choices++;
					System.out.println("6: Talk to " + cH.name + ".");
					choices++;
					System.out.println("7: Talk to " + cR.name + ".");
					choices++;
					System.out.println("8: Talk to " + mA.name + ".");
					choices++;	
					System.out.println("9: Talk to " + sA.name + ".");
					choices++;	
				}
				else if(location == 2){
					System.out.println("3: Talk to " + bA.name + ".");
					choices++;
					System.out.println("4: Talk to " + dE.name + ".");
					choices++;
					System.out.println("5: Talk to " + hE.name + ".");
					choices++;
					System.out.println("6: Talk to " + iZ.name + ".");
					choices++;
					System.out.println("7: Talk to " + kA.name + ".");
					choices++;
*/				}
			}
			else if(day == 2){
				if(location == 1){
					System.out.println("3: Talk to " + aE.name + ".");
					choices++;
/*					System.out.println("4: Talk to " + aR.name + ".");
					choices++;
					System.out.println("5: Talk to " + bA.name + ".");
					choices++;
					System.out.println("6: Talk to " + cR.name + ".");
					choices++;
					System.out.println("7: Talk to " + hE.name + ".");
					choices++;
					System.out.println("8: Talk to " + iZ.name + ".");
					choices++;
					System.out.println("9: Talk to " + mA.name + ".");
					choices++;
				}
				else if(location == 2){
					System.out.println("3: Talk to " + aN.name + ".");
					choices++;
					System.out.println("4: Talk to " + cH.name + ".");
					choices++;
					System.out.println("5: Talk to " + dE.name + ".");
					choices++;
					System.out.println("6: Talk to " + kA.name + ".");
					choices++;
					System.out.println("7: Talk to " + sA.name + ".");
					choices++;
*/				}
			}
			else if(day == 3){
				if(location == 1){
					System.out.println("3: Talk to " + aE.name + ".");
					choices++;
/*					System.out.println("4: Talk to " + aR.name + ".");
					choices++;
					System.out.println("5: Talk to " + cH.name + ".");
					choices++;
					System.out.println("6: Talk to " + cR.name + ".");
					choices++;
				}
				else if(location == 2){
					System.out.println("3: Talk to " + aN.name + ".");
					choices++;
					System.out.println("4: Talk to " + aR.name + ".");
					choices++;
					System.out.println("5: Talk to " + dE.name + ".");
					choices++;
					System.out.println("6: Talk to " + hE.name + ".");
					choices++;
					System.out.println("7: Talk to " + iZ.name + ".");
					choices++;
					System.out.println("8: Talk to " + kA.name + ".");
					choices++;
					System.out.println("9: Talk to " + mA.name + ".");
					choices++;
					System.out.println("10: Talk to " + sA.name + ".");
					choices++;
*/				}
			}
			else if(day == 4){
				if(location == 1){
					System.out.println("3: Talk to " + aE.name + ".");
/*					choices++;
					System.out.println("4: Talk to " + aR.name + ".");
					choices++;
					System.out.println("5: Talk to " + cR.name + ".");
					choices++;
					System.out.println("6: Talk to " + sA.name + ".");
					choices++;
				}
				else if(location == 2){
					System.out.println("3: Talk to " + aN.name + ".");
					choices++;
					System.out.println("4: Talk to " + bA.name + ".");
					choices++;
					System.out.println("5: Talk to " + cH.name + ".");
					choices++;
					System.out.println("6: Talk to " + dE.name + ".");
					choices++;
					System.out.println("7: Talk to " + hE.name + ".");
					choices++;
					System.out.println("8: Talk to " + iZ.name + ".");
					choices++;
					System.out.println("9: Talk to " + kA.name + ".");
					choices++;
					System.out.println("10: Talk to " + mA.name + ".");
					choices++;
*/				}
			}
		}
		else if(time == 2){
			if(location == 1){
				System.out.println("3: Ask " + aE.name + " to hang out.");
				choices++;
/*				System.out.println("4: Ask " + aN.name + " to hang out.");
				choices++;
				System.out.println("5: Ask " + aR.name + " to hang out.");
				choices++;
				System.out.println("6: Ask " + bA.name + " to hang out.");
				choices++;
				System.out.println("7: Ask " + cH.name + " to hang out.");
				choices++;
				System.out.println("8: Ask " + cR.name + " to hang out.");
				choices++;
				System.out.println("9: Ask " + dE.name + " to hang out.");
				choices++;
				System.out.println("10: Ask " + hE.name + " to hang out.");
				choices++;
				System.out.println("11: Ask " + iZ.name + " to hang out.");
				choices++;
				System.out.println("12: Ask " + kA.name + " to hang out.");
				choices++;
				System.out.println("13: Ask " + mA.name + " to hang out.");
				choices++;
				System.out.println("14: Ask " + sA.name + " to hang out.");
				choices++;
*/			}
			else if(location == 2){
				System.out.println("3: Call " + aE.name + ".");
				choices++;
/*				System.out.println("4: Call " + aN.name + ".");
				choices++;
				System.out.println("5: Call " + aR.name + ".");
				choices++;
				System.out.println("6: Call " + bA.name + ".");
				choices++;
				System.out.println("7: Call " + cH.name + ".");
				choices++;
				System.out.println("8: Call " + cR.name + ".");
				choices++;
				System.out.println("9: Call " + dE.name + ".");
				choices++;
				System.out.println("10: Call " + hE.name + ".");
				choices++;
				System.out.println("11: Call " + iZ.name + ".");
				choices++;
				System.out.println("12: Call " + kA.name + ".");
				choices++;
				System.out.println("13: Call " + mA.name + ".");
				choices++;
				System.out.println("14: Call " + sA.name + ".");
				choices++;
*/			}
		}
		
		return choices;
		
	}
	
	// runs the chosen character's dialogue
	private void dialogue(int choice){
		if(time == 0){
			if(day == 0){
				if(location == 1){
					switch(choice){				
				case 3: aE.speak();
						break;
/*				case 4:	aN.speak();
						break;						
				case 5:	aR.speak();
						break;						
				case 6: cR.speak();
						break;						
				case 7:	hE.speak();
						break;						
				case 8:	mA.speak();
*/					}
				}
				
				else if(location == 2){
					switch(choice){
/*				case 3:	bA.speak();
						break;						
				case 4:	cH.speak();
						break;						
				case 5:	dE.speak();
						break;						
				case 6:	iZ.speak();
						break;						
				case 7:	kA.speak();
						break;						
				case 8:	sA.speak();
*/					}
				}
			}
			else if(day == 1){
				if(location == 1){
					switch(choice){
				case 3:	aE.speak();
						break;
/*				case 4:	aN.speak();
						break;				
				case 5:	cR.speak();
						break;						
				case 6:	dE.speak();
						break;
				case 7:	mA.speak();
					}
				}
				else if(location == 2){
					switch(choice){
				case 3:	dE.speak();
						break;
				case 4:	hE.speak();
						break;
				case 5:	mA.speak();
						break;
				case 6:	sA.speak();
*/					}
				}
			}
			else if(day == 2){
				if(location == 1){
					switch(choice){
				case 1:	aE.speak();
						break;
/*				case 4:	aR.speak();
						break;
				case 5:	bA.speak();
						break;
				case 6:	cR.speak();
						break;
				case 7:	kA.speak();
						break;
				case 8:	hE.speak();
					}
				}
				else if(location == 2){
					switch(choice){
				case 3:	aN.speak();
						break;
				case 4:	cH.speak();
						break;
				case 5:	dE.speak();
						break;
				case 6:	iZ.speak();
						break;
				case 7:	mA.speak();
						break;
				case 8:	sA.speak();
*/					}
				}
			}
			else if(day == 3){
				if(location == 1){
					switch(choice){
				case 3:	aE.speak();
						break;
/*				case 4:	aN.speak();
						break;
				case 5:	aR.speak();
						break;
				case 6:	cH.speak();
						break;
				case 7:	cR.speak();
					}
				}
				else if(location == 2){
					switch(choice){
				case 3:	bA.speak();
						break;
				case 4:	dE.speak();
						break;
				case 5:	hE.speak();
						break;
				case 6:	iZ.speak();
						break;
				case 7:	kA.speak();
						break;
				case 8:	mA.speak();
						break;
				case 9:	sA.speak();
*/					}
				}
			}
			else if(day == 4){
				if(location == 1){
					switch(choice){
/*				case 3:	aN.speak();
						break;
				case 4:	bA.speak();
						break;
				case 5:	cH.speak();
						break;
				case 6:	cR.speak();
						break;
				case 7:	dE.speak();
						break;
				case 8:	iZ.speak();
						break;
				case 9:	kA.speak();
					break;
				case 10:mA.speak();
					}
				}
				else if(location == 2){
					switch(choice){
				case 3:	aE.speak();
						break;
				case 4:	aR.speak();
						break;
				case 5:	hE.speak();
						break;
				case 6:	sA.speak();
*/					}
				}
			}
		}
		else if(time == 1){
			if(day == 0){
				if(location == 1){
					switch(choice){
				case 3:	aE.speak();
						break;
/*				case 4:	aN.speak();
						break;
				case 5:	aR.speak();
						break;
				case 6:	bA.speak();
						break;
				case 7:	cH.speak();
						break;
				case 8:	cR.speak();
						break;
				case 9:	iZ.speak();
					break;
				case 10:kA.speak();
					}
				}
				else if(location == 2){
					switch(choice){
				case 3:	dE.speak();
						break;
				case 4:	hE.speak();
					break;
				case 5:	mA.speak();
					break;
				case 6:	sA.speak();
*/					}
				}
			}
			else if(day == 1){
				if(location == 1){
					switch(choice){
				case 3:	aE.speak();
						break;
/*				case 4:	aN.speak();
						break;
				case 5:	aR.speak();
						break;
				case 6:	cH.speak();
						break;
				case 7:	cR.speak();
						break;
				case 8:	mA.speak();
						break;
				case 9:	sA.speak();
					}	
				}
				else if(location == 2){
					switch(choice){
				case 3:	bA.speak();
						break;
				case 4:	dE.speak();
						break;
				case 5:	hE.speak();
						break;
				case 6:	iZ.speak();
						break;
				case 7:	kA.speak();
*/					}
				}
			}
			else if(day == 2){
				if(location == 1){
					switch(choice){
				case 3:	aE.speak();
						break;
/*				case 4:	aR.speak();
						break;
				case 5:	bA.speak();
						break;
				case 6:	cR.speak();
						break;
				case 7:	hE.speak();
						break;
				case 8:	iZ.speak();
						break;
				case 9:	mA.speak();
					}
				}
				else if(location == 2){
					switch(choice){
				case 3:	aN.speak();
						break;
				case 4:	cH.speak();
						break;
				case 5:	dE.speak();
						break;
				case 6:	kA.speak();
						break;
				case 7:	sA.speak();
*/					}
				}
			}
			else if(day == 3){
				if(location == 1){
					switch(choice){
				case 3:	aE.speak();
						break;
/*				case 4:	aR.speak();
						break;
				case 5:	cH.speak();
						break;
				case 6:	cR.speak();
					}
				}
				else if(location == 2){
					switch(choice){
				case 3:	aN.speak();
						break;
				case 4:	aR.speak();
						break;
				case 5:	dE.speak();
						break;
				case 6:	hE.speak();
						break;
				case 7:	iZ.speak();
						break;
				case 8:	kA.speak();
						break;
				case 9:	mA.speak();
						break;
				case 10:sA.speak();
*/					}
				}
			}
			else if(day == 4){
				if(location == 1){
					switch(choice){
				case 3:	aE.speak();
						break;
/*				case 4:	aR.speak();
						break;
				case 5:	cR.speak();
						break;
				case 6:	sA.speak();
					}
				}
				else if(location == 2){
					switch(choice){
				case 3:	aN.speak();
						break;
				case 4:	bA.speak();
						break;
				case 5:	cH.speak();
						break;
				case 6:	dE.speak();
						break;
				case 7:	hE.speak();
						break;
				case 8:	iZ.speak();
						break;
				case 9:	kA.speak();
						break;
				case 10:mA.speak();
*/					}
				}
			}
		}
		else if(time == 2){
			if(location == 1){
				switch(choice){
			case 3:	aE.date();
					break;
/*			case 4:	aN.date();
					break;
			case 5:	aR.date();
					break;
			case 6:	bA.date();
					break;
			case 7: cH.date();
					break;
			case 8:	cR.date();
					break;
			case 9:	dE.date();
					break;
			case 10:hE.date();
					break;
			case 11:iZ.date();
					break;
			case 12:kA.date();
					break;
			case 13:mA.date();
					break;
			case 14:sA.date();
*/				}
			}
			else if(location == 2){
				switch(choice){
			case 3:	aE.call();
					break;
/*			case 4:	aN.call();
					break;
			case 5:	aR.call();
					break;
			case 6:	bA.call();
					break;
			case 7:	cH.call();
					break;
			case 8:	cR.call();
					break;
			case 9:	dE.call();
					break;
			case 10:hE.call();
					break;
			case 11:iZ.call();
					break;
			case 12:kA.call();
					break;
			case 13:mA.call();
					break;
			case 14:sA.call();
*/				}
			}
		}
	}
}