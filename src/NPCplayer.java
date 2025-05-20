import java.util.ArrayList;

public class NPCplayer extends Player {

	//TO DO;
	/*
	 * 1) create method that assigns the NPC a random name
	 * 2)
	 * 
	 */
	
	private int health;
	private String currWord;

	private ArrayList<String> guessedLetters;
	private static String[] names = {"Kerry Carpenter", "Tisha Andersen", 
			"Gerardo Vaughn", "Palmer Riggs", "Connie Moyer", "Javier Mcneil", 
			"Manual Allen", "Anderson Watkins"};
	
	public NPCplayer(String name, String currentWord) {
		// TODO Auto-generated constructor stub
		super(name, currentWord);
		health = 10;
	
		
	}

	public static String setNPCName() {
		
		String name = "";
		
		int random = (int)(Math.random() * 8);
		
		name = names[random];
		
		return name;
	}
	
	
	
	//auto generated getters and setters
	
	public int getNPCHealth() {
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

	public ArrayList<String> getNPCGuessedLetters() {
		return guessedLetters;
	}

	public void setNPCGuessedLetters(ArrayList<String> guessedLetters) {
		this.guessedLetters = guessedLetters;
	}
	
	

}
