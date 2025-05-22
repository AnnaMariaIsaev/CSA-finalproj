import java.util.ArrayList;
import java.util.Arrays;

public class NPCplayer extends Player {

	//TO DO;
	/*
	 * 1) create method that assigns the NPC a random name
	 * 2)
	 * 
	 */
	
	private static int health;
	private String currWord;

	private static ArrayList<String> possibleLetters;
	
	private static String[] names = {"Kerry Carpenter", "Tisha Andersen", 
			"Gerardo Vaughn", "Palmer Riggs", "Connie Moyer", "Javier Mcneil", 
			"Manual Allen", "Anderson Watkins"};
	
	public NPCplayer(String name, String currentWord) {
		// TODO Auto-generated constructor stub
		super(name, currentWord);
		health = 10;
		
		possibleLetters = new ArrayList<>(Arrays.asList(
			    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
			));

	
		
	}

	public static String setNPCName() {
		
		String name = "";
		
		int random = (int)(Math.random() * 8);
		
		name = names[random];
		
		return name;
	}
	
	
	
	//auto generated getters and setters
	
	public static int getNPCHealth() {
		return health;
	}

	public void setNPCHealth(int health) {
		this.health = health;
	}

	public String getNPCCurrWord() {
		return currWord;
	}

	public void setNPCCurrWord(String currWord) {
		this.currWord = currWord;
	}

	/*
	public ArrayList<String> getNPCGuessedLetters() {
		return guessedLetters;
	}

	public void setNPCGuessedLetters(ArrayList<String> guessedLetters) {
		this.guessedLetters = guessedLetters;
	}
	
	*/
	
	public static ArrayList<String> getPossibleLetters() {
		return possibleLetters;
	}
	

}
