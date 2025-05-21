import java.util.ArrayList;

public class Player {

	private String name;
	private int health;
	private static String currentWord;
	private static ArrayList<String> guessedLetters;
	private static ArrayList<String> incorrectLetters;
	
	public Player(String name, String currentWord) {
		
		this.name = name;
		Player.currentWord = currentWord;
		health = 10;
		
	}

	
	//auto generated getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public static String getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(String currentWord) {
		this.currentWord = currentWord;
	}

	public static ArrayList<String> getGuessedLetters() {
		return guessedLetters;
	}

	public static void addGuessedLetters(String letter) {
		guessedLetters.add(letter);
	}
	
	public static void addIncorrectLetters(String letter) {
		incorrectLetters.add(letter);
	}



	
	
	
	
}
