public class Aera extends Character{	
	// constructor checks to see if genders are compatible and sets set, day, time, location, and playerName to the variables already created in other classes
	Aera(Setting1 s){
		name = "the quiet girl with long brown hair";		// initializes name of the character (starts out as a description until the name is discovered by talking once)
		set = s;
		date = true;
		user = set.user;
		sc = set.sc;
	}
	
	//runs the dialogue specific to character's ap and location (if at a club)
	//dialogue is chosen randomly from an arraylist determined by potential()
	public void speak(){
		
		day = set.day;
		time = set.time;
		
		if(ap == 0){
			if(!intro){
				System.out.println("Girl: Oh, hi. You're the new kid, " + user.playerName + ", right? I'm Aera.");
				name = "Aera";
				intro = true;
			}
			else{
				System.out.println("Aera: ...");
			}
		}
		else if(ap > 2 && !phone){
			System.out.println("Aera: Hey, um, here's my number for the English project.");
			phone = true;
		}
		else{
			String speech = previous;
			int random = 0;
			String[] d = potential();
			
			while(previous.compareTo(speech) == 0){
				random = (int)((d.length - 1) * Math.random());
				speech = d[random];
			}
		
			if(random % 2 != 0){
				response(speech);
			}
			else System.out.println("Aera: " + speech);
			
			previous = speech;
		}
		
		ap++;
		
		sc.nextLine();
		
	}
	
	//	UNDER CONSTRUCTION
	//	second response in time and ap if statements require user response
	//	creates an array of the potential dialogue options, every other option (odd indexes) requires user response
	//	dialogue options depend on location or ap
	private String[] potential(){
		
		String[] p;
		int i = 0;
		
		if(time < 2)
			p = new String[5];
		else p = new String[3];
		
		if(day == 0){
			if(time == 0){
				p[i] = "I've always wondered if I should talk about my theories on existentialism for one of these meetings...";
				p[i + 1] = "What they're talking about is really cool, isn't it?";
				i = i + 2;
			}
			else if(time == 1){
				p[i] = "I don't know why I'm even in this club...";
				p[i + 1] = "You watch anime?";
				i = i + 2;
			}
		}
		if(day == 1){
			if(time == 0){
				p[i] = "";
				p[i + 1] = "";
				i = i + 2;
			}
			else if(time == 1){
				p[i] = "";
				p[i + 1] = "";
				i = i + 2;
			}
		}
		if(day == 2){
			if(time == 0){
				p[i] = "";
				p[i + 1] = "";
				i = i + 2;
			}
			else if(time == 1){
				p[i] = "";
				p[i + 1] = "";
				i = i + 2;
			}
		}
		if(day == 3){
			if(time == 0){
				p[i] = "";
				p[i + 1] = "";
				i = i + 2;
			}
			else if(time == 1){
				p[i] = "";
				p[i + 1] = "";
				i = i + 2;
			}
		}
		if(day == 4){
			if(time == 0){
				p[i] = "";
				p[i + 1] = "";
				i = i + 2;
			}
			else if(time == 1){
				p[i] = "";
				p[i + 1] = "";
				i = i + 2;
			}
		}
		
		if(ap == 1){
			p[i] = "Oh, hi.";
			p[i + 1] = "Hey, what are your thoughts on the multiverse theory?";
			p[i + 2] = "Did you need something?";
		}
		else if(ap == 2){
			p[i] = "Hey.";
			p[i + 1] = "I'm not really a fan of sunny days.";
			p[i + 2] = "It's too sunny out...";
		}
		else if(ap == 4){
			p[i] = "How's it going?";
			p[i + 1] = "Hey, you should meet my bird sometime.";
			p[i + 2] = "Oh man, my bird is so cute.";
		}
		else if(ap == 5){
			p[i] = "'Sup.";
			p[i + 1] = "Hey, do you prefer the city or quiet towns like this?";
			p[i + 2] = "Man, this town is so boring.";
		}
		else if(ap == 6){
			p[i] = "What's up?";
			p[i + 1] = "Hey, what kind of classes are you taking?";
			p[i + 2] = "Oh man, I have so much homework.";
		}
		else if(ap == 7){
			p[i] = "Hey!";
			p[i + 1] = "Yeah, I know everyone's birthday. Which reminds me; today is my sister's birthday.";
			p[i + 2] = "I should call my sister since today's her birthday...";
		}
		else if(ap == 8){
			p[i] = "I should water my plants when I get home.";
			p[i + 1] = "Hey, what kind of music do you listen to?";
			p[i + 2] = "I wanna go home...";
		}
		else if(ap == 9){
			p[i] = "Man, I haven't written in my book in a while...";
			p[i + 1] = "Out of curiosity, what is your weapon of choice?";
			p[i + 2] = "I really want to play the piano right now...";
		}
		else if(ap == 10){
			p[i] = "I could so do with a cup of tea right now.";
			p[i + 1] = "Do you drink tea?";
			p[i + 2] = "I should play video games when I get home...";
		}
		
		return p;
	}
	
	//not done with this method
	//runs the dialogue exchange for dialogue sequences that require user response
	//takes user input and responds accordingly (in regard to output and ap increment/decrement)
	// double check to make sure Aera's responses are for the correct choice
	private void response(String str){
		int choice;
		if(str.compareTo("What they're talking about is really cool, isn't it?") == 0){
			
			System.out.println("Aera: " + str);		
			sc.nextLine();
			System.out.println("1: Yeah.");
			System.out.println("2: Not really.");
			
			choice = Player.getInt(2);
			
			if(choice == 1){
				ap++;
			}
			
			else if(choice == 0){
				System.out.println("Aera: Oh.");
				sc.nextLine();
				ap--;
			}
		}
		else if(str.compareTo("You watch anime?") == 0){
			
			System.out.println("Aera: " + str);
			sc.nextLine();
			System.out.println("1: Yeah.");
			System.out.println("2: Not really.");
			System.out.println("3: Anime should be destroyed.");
			
			choice = Player.getInt(3);
			
			if(choice == 1){
				System.out.println("Aera: Cool.");
				sc.nextLine();
				ap++;
			}
			
			else if(choice == 2){
				System.out.println("Aera: Then why are you here?");
				sc.nextLine();
			}
			else if(choice == 3){
				System.out.println("Aera: Haha yeah.");
				sc.nextLine();
				ap++;
			}
		}
		else if(str.compareTo("Hey, what are your thoughts on the multiverse theory?") == 0){
			
			System.out.println("Aera: " + str);
			sc.nextLine();
			System.out.println("1: I agree with it.");
			System.out.println("2: I disagree.");
			System.out.println("3: I dont really understand it.");
			System.out.println("4: The what?");
			
			choice  = Player.getInt(4);
			
			if(choice == 1){
				ap++;
			}
			
			else if(choice == 3){
				ap--;
			}
			else if(choice == 4){
				System.out.println("Aera: I can explain it sometime, if you want.");
				sc.nextLine();
			}
		}
		else if(str.compareTo("I'm not really a fan of sunny days.") == 0){
			
			System.out.println("Aera: " + str);
			sc.nextLine();
			System.out.println("1: Me neither.");
			System.out.println("2: Why not?");
			System.out.println("3: I am.");
			
			choice = Player.getInt(3);
			
			if(choice == 1){
				ap++;
			}
			
			else if(choice == 2){
				System.out.println("Aera: They're just too much for me.");
				sc.nextLine();
			}
			else if(choice == 3){
				ap--;
			}
		}
		else if(str.compareTo("Hey, you should meet my bird sometime.") == 0){
			
			System.out.println("Aera: " + str);
			sc.nextLine();
			System.out.println("1: Yeah.");
			System.out.println("2: I don't really like birds.");
			
			choice = Player.getInt(2);
			
			if(choice == 1){
				ap++;
			}
			
			else if(choice == 2){
				System.out.println("Aera: Oh, okay.");
				sc.nextLine();
				ap--;
			}
		}
		else if(str.compareTo("Hey, do you prefer the city or quiet towns like this?") == 0){
			
			System.out.println("Aera: " + str);
			sc.nextLine();
			System.out.println("1: Cities.");
			System.out.println("2: Quiet towns.");
			System.out.println("3: No preference.");
			
			choice = Player.getInt(3);
			
			if(choice == 1){
				System.out.println("Aera: Yeah, same.");
				sc.nextLine();
				ap++;
			}
			
			else if(choice == 2){
				System.out.println("Aera: Oh, really?");
				sc.nextLine();
				ap--;
			}
			else if(choice == 3){
				ap--;
			}
		}
		else if(str.compareTo("Hey, what kind of classes are you taking?") == 0){
			
			System.out.println("Aera: " + str);
			sc.nextLine();
			System.out.println("1: Easy classes.");
			System.out.println("2: Hard classes.");
			System.out.println("3: Average classes.");
			
			choice = Player.getInt(3);
			
			if(choice == 2){
				System.out.println("Aera: Yeah, I know the feel.");
				sc.nextLine();
				ap--;
			}
		}
		else if(str.compareTo("Yeah, I know everyone's birthday. Which reminds me; today is my sister's birthday.") == 0){

			System.out.println("Aera: " + str);
			sc.nextLine();
			System.out.println("1: Crystal?");
			System.out.println("2: Okay.");
			System.out.println("3: Do you know my birthday?");
			
			choice = Player.getInt(3);
			
			if(choice == 1){
				System.out.println("Aera: Nah, I have 6 siblings.");
				sc.nextLine();
				ap++;
			}
			
			else if(choice == 3){
				System.out.println("Aera: You've never told me!");
				sc.nextLine();
				ap--;
			}
		}
		else if(str.compareTo("Hey, what kind of music do you listen to?") == 0){

			System.out.println("Aera: " + str);
			sc.nextLine();
			System.out.println("1: Pop.");
			System.out.println("2: Rock.");
			System.out.println("3: Indie.");
			System.out.println("4: Old music.");
			System.out.println("5: Dubstep/techno.");
			System.out.println("6: Foreign music.");
			System.out.println("7: I don't really listen to music.");
			// add metal, rap, and country
			
			choice = Player.getInt(7);
			
			if(choice == 1){
				ap--;
			}
			else if(choice == 2){
				System.out.println("Aera: Me too!");
				sc.nextLine();
				ap++;
			}
			else if(choice == 6){
				System.out.println("Aera: Yeah, I listen to some Japanese music.");
				sc.nextLine();
				ap++;
			}
			else if(choice == 7){
				ap--;
			}
		}
		else if(str.compareTo("Out of curiosity, what is your weapon of choice?") == 0){

			System.out.println("Aera: " + str);
			sc.nextLine();
			System.out.println("1: Sword");
			System.out.println("2: Gun.");
			System.out.println("3: Scythe.");
			System.out.println("4: Axe.");
			System.out.println("5: Magic.");
			System.out.println("6: Club.");
			System.out.println("7: Bow and arrow.");
			System.out.println("8: Other.");
			System.out.println("9: I don't have one.");
			
			choice = Player.getInt(9);
			
			if(choice == 3){
				System.out.println("Aera: Same.");
				sc.nextLine();
				ap++;
			}
			else if(choice == 5){
				ap++;
			}
			else if(choice == 7){
				ap++;
			}
			else if(choice == 9){
				ap--;
			}
		}
		else if(str.compareTo("Do you drink tea?") == 0){

			System.out.println("Aera: " + str);
			sc.nextLine();
			System.out.println("1: Yeah.");
			System.out.println("2: No.");
			
			choice = Player.getInt(2);
			
			if(choice == 1){
				System.out.println("Aera: Yeah, I love tea.");
				sc.nextLine();
				ap++;
			}
			else if(choice == 2){
				System.out.println("Aera: Oh.");
				sc.nextLine();
				ap--;
			}
		}
	}
	
	//checks to see which date method should run, depending on the number of dates the player has gone on with this character
	public boolean date(){
		if(dated == 0)
			return date1();
		else if(dated == 1)
			return date2();
		return false;
	}
	
	//checks to see if the player is eligible for dating this character, then reacts accordingly
	//if all prerequisites are met, the player will go on their first date with this character

	// make sure all choice variables should not be choice variables
	public boolean date1(){
		if(!phone){
			System.out.println("You do not have her phone number.");
			sc.nextLine();
			return false;
		}
		else if(!date || ap < 10){
			System.out.println("Aera: Sorry, I'm kind of busy.");
			sc.nextLine();
			return false;
		}
		else{
			int dp = 0;
			
			System.out.println("Aera: Sure, you can meet me at my house, if you want. We can play video games or something.");
			sc.nextLine();
			System.out.println("You arrive at Aera's house.");
			sc.nextLine();
			System.out.println("Aera: Hey! Come on in. Do you want something to drink?");
			sc.nextLine();
			System.out.println("1: Yes.");
			System.out.println("2: No.");
			int choice = Player.getInt(2);
			
			if(choice == 1){
				System.out.println("Aera: What would you like?");
				sc.nextLine();
				System.out.println("1: Tea.");
				System.out.println("2: Coffee.");
				System.out.println("3: Water.");
				System.out.println("4: Soda.");
				System.out.println("5: Juice.");
				System.out.println("6: I changed my mind.");
				choice = Player.getInt(6);
				
				if(choice == 1)
					dp++;
			}
			
			System.out.println("Aera: Ok, are you hungry?");
			sc.nextLine();
			System.out.println("1: Yes.");
			System.out.println("2: No.");
			choice = Player.getInt(2);
			
			if(choice == 1){
				System.out.println("Aera: You want me to make you something? It might take a while, but I guarantee it'll be good!");
				sc.nextLine();
				System.out.println("1: Ramen.");
				System.out.println("2: Fried rice.");
				System.out.println("3: Sandwich.");
				System.out.println("4: Miso Soup.");
				System.out.println("5: Never mind.");
				choice = Player.getInt(5);
				
				if(choice == 1 || choice == 2 || choice == 4)
					dp++;
				
				if(choice == 5){
					System.out.println("Aera: Ok, you can pull up a chair and sit here while I cook, if you want.");
					sc.nextLine();
					System.out.println("1: Ok.");
					System.out.println("2: Can I help?");
					System.out.println("3: Nah.");
					choice = Player.getInt(3);
					
					if(choice == 1)
						dp++;
					else if(choice == 3)
						dp--;
					else if(choice == 2){
						dp = dp + 2;
						System.out.println("Aera: Oh, if you want. Thanks!");
						sc.nextLine();
					}
					
					System.out.println("Some time passes before the food is ready.");
					sc.nextLine();
					System.out.println("Aera: Ok, it's done! How does it taste?");
					sc.nextLine();
					System.out.println("1: Great!");
					System.out.println("2: Not bad.");
					System.out.println("3: It needs something...");
					System.out.println("4: Kinda bad.");
					System.out.println("5: Terrible.");
					choice = Player.getInt(5);
					
					if(choice == 1){
						dp++;
						System.out.println("Aera: Really? I'm glad you like it!");
						sc.nextLine();
					}
					else if(choice == 3){
						dp++;
						System.out.println("Aera: Now that you mention it...");
						sc.nextLine();
					}
					else if(choice == 4){
						dp--;
						System.out.println("Aera: Oh. Sorry about that.");
						sc.nextLine();
					}
					else if(choice == 5){
						dp--;
						System.out.println("Aera: Oh, really? Sorry.");
						sc.nextLine();
					}
					
				}
				
			}
			
			System.out.println("Aera: So, you wanna play video games or something?");
			sc.nextLine();
			System.out.println("1: Sure.");
			System.out.println("2: Nah.");	
			choice = Player.getInt(2);
			
			int no = 0;
			
			while(no < 3){
				if(choice == 1){
					System.out.println("Aera: What do you want to play?");
					sc.nextLine();
					System.out.println("1: An arcade game.");
					System.out.println("2: Nothing.");
					System.out.println("3: A shooter game.");
					System.out.println("4: A rhythm game.");
					System.out.println("5: A singleplayer game.");
					System.out.println("6: A dating simulator.");
					System.out.println("7: You choose.");
					choice = Player.getInt(7);
				
					if(choice == 1){
						dp++;
						System.out.println("Aera: Those are always fun.");
						sc.nextLine();
						no = 3;
					}
					else if(choice == 3){
						dp--;
						System.out.println("Aera: Ok.");
						sc.nextLine();
						no = 3;
					}
					else if(choice == 4){
						dp++;
						System.out.println("Aera: I like rhythm games.");
						sc.nextLine();
						no = 3;
					}
					else if(choice == 5){
						dp--;
						System.out.println("Aera: Ok...");
						sc.nextLine();
						no = 3;
					}
					else if(choice == 6){
						System.out.println("Aera: Lol ok.");
						sc.nextLine();
						no = 3;
					}
					else if(choice == 7){
						System.out.println("Aera: I'm kinda bad at choosing... how about an arcade game?");
						sc.nextLine();
						no = 3;
					}
				}
			
				if(choice == 2){
					no++;
					dp--;
					System.out.println("Aera: Then what do you want to do?");
					sc.nextLine();
					System.out.println("1: Play video games.");
					System.out.println("2: Watch a movie.");
					System.out.println("3: Watch TV.");
					System.out.println("4: Play the piano.");
					System.out.println("5: Listen to you play the piano.");
					System.out.println("6: Nothing.");
					choice = Player.getInt(6);
					
					if(choice == 1){
						no++;
						System.out.println("Aera: Lol ok.");
						sc.nextLine();
					}
					else if(choice == 2){
						System.out.println("Aera: Ok.");
						sc.nextLine();
						no = 3;
					}
					else if(choice == 3){
						System.out.println("Aera: Ok...");
						sc.nextLine();
						dp--;
						no = 3;
					}
					else if(choice == 6){
						System.out.println("Aera: Ok...");
						sc.nextLine();
						dp--;
						no = 3;
					}
					else if(choice == 4){
						System.out.println("Aera: You play?");
						sc.nextLine();
						System.out.println("1: Yes.");
						System.out.println("2: No.");
						choice = Player.getInt(2);
						
						if(choice == 1){
							System.out.println("Aera: Ok.");
							sc.nextLine();
							dp++;
						}
						else if(choice == 2){
							dp--;
							System.out.println("Aera: Ok... lol.");
							sc.nextLine();
						}
						no = 3;
					}
					else if(choice == 5){
						dp++;
						System.out.println("Aera: Oh... ok.");
						sc.nextLine();
						System.out.println("She plays Song of Storms from the Legend of Zelda. She seems nervous and makes a few mistakes, but they're hardly noticeable.");
						sc.nextLine();
						System.out.println("1: That was good.");
						System.out.println("2: That wasn't that great.");
						System.out.println("3: Say nothing.");
						choice = Player.getInt(3);
						
						if(choice == 1){
							dp++;
							System.out.println("Aera: Thanks.");
							sc.nextLine();
						}
						else if(choice == 2){
							dp--;
							System.out.println("Aera: Yeah.");
							sc.nextLine();
						}
						
						no = 3;
					}
				}
			}
			System.out.println("Time passes and it's time to go home. It was a little awkward at some points, but you had a good time over all.");
			sc.nextLine();
			
			if(dp < 0)
				ap--;
			else if(dp > 3)
				ap++;
			
			dated++;
			return true;
		}
	}
	
	//checks to see if the player is eligible for dating this character for a second time, then reacts accordingly
	//if all prerequisites are met, the player will go on their second and final date with this character
	public boolean date2(){
		if(ap < 15){
			System.out.println("Aera: Sorry, I'm kind of busy.");
			sc.nextLine();
			return false;
		}
		else{
			
			set.single = false;
			return true;
		}
	}
	
	//checks to see you player has the character's phone number
	//if player has the number, character greets player and then the dialogue is chosen using speak()
	public boolean call(){
		if(!phone){
			System.out.println("You do not have her phone number.");
			sc.nextLine();
			return false;
		}
		else{
			speak();
			return true;
		}
	}
}
