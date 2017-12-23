public class Main {
	
	// TODO: change user response to switch case instead of if else in Character classes
	
	public static void main(String[] args) {
		
		// prompts the user to create a Player, and creates a Setting object
		Player p = new Player();
		Setting1 s = new Setting1(p);
		
		// creates the characters, represented by the first two letters of their name
		Aera aE = new Aera(s);
/*		Antimony aN = new Antimony(s);
		Arnold aR = new Arnold(s);
		Bart bA = new Bart(s);
		Chrysanthemum cH = new Chrysanthemum(s);
		Crystal cR = new Crystal(s);
		Deni dE = new Deni(s);
		Heartless hE = new Heartless(s);
		Izzy iZ = new Izzy(s);
		Kat kA = new Kat(s);
		Maggie mA = new Maggie(s);
		Sammie sA = new Sammie(s);
*/		
		// gives Setting class access to the characters
		s.getAE(aE);
/*		s.getAN(aN);
		s.getAR(aR);
		s.getBA(bA);
		s.getCH(cH);
		s.getCR(cR);
		s.getDE(dE);
		s.getHE(hE);
		s.getIZ(iZ);
		s.getKA(kA);
		s.getMA(mA);
		s.getSA(sA);
*/		
		// begins the game
		s.timeAndDay();
		
		// prints a message when the game is over
		System.out.println("Thanks for playing!");
		
	}
}
