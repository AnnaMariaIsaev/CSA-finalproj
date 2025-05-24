import java.util.ArrayList;
import java.util.Arrays;

public class NPCplayer {

	//TO DO;
	/*
	 * 1) create method that assigns the NPC a random name
	 * 2)
	 * 
	 */
	
	private Word currentWord;
	private static int health;
	private static String currWord;
	private String name;

	private static ArrayList<String> possibleLetters;
	
	private static String[] names = {"Kerry Carpenter", "Tisha Andersen", 
			"Gerardo Vaughn", "Palmer Riggs", "Connie Moyer", "Javier Mcneil", 
			"Manual Allen", "Anderson Watkins"};
	
	public NPCplayer(Word currentWord) {
		// TODO Auto-generated constructor stub
		
		this.currentWord = currentWord;
		
		health = 10;
		
		possibleLetters = new ArrayList<>(Arrays.asList(
			    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
			));

		
		currWord = currentWord.getActualWord();	
		this.name = "";
		
		
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

	public void setNPCHealth(int val) {
		health = val;
	}

	public static String getNPCCurrWord() {
		return currWord;
	}
	
	public String getNPCName() {
		return name;
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
