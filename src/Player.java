import java.util.ArrayList;
import java.util.Arrays;

public class Player {

	private String name;
	private static int health;
	private static Word currentWord;
	
	private static ArrayList<String> possibleLetters;
	private static ArrayList<String> incorrectLetters;
	
	public Player(String name, String currentWord) {
		
		this.name = name;
		//Player.currentWord = currentWord;
	
		health = 10;
		
		incorrectLetters = new ArrayList<>();
		possibleLetters = new ArrayList<>(Arrays.asList(
			    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
			));

	
		
	}

	
	//auto generated getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getHealth() {
		return health;
	}

	public static void setHealth(int num) {
		health = num;
	}

	public static String getCurrentWord() {
		return currentWord.getActualWord();
	}

	public static void setCurrentWord(Word currentWord) {
		Player.currentWord = currentWord;
	}

	
	public static void removeGuessedLetter(String letter) {
		int val = possibleLetters.indexOf(letter);
		possibleLetters.remove(val);
	}

	/*
	public static void addGuessedLetters(String letter) {
		guessedLetters.add(letter);
	}
	*/
	
	public static void addIncorrectLetters(String letter) {
		incorrectLetters.add(letter);
	}
	
	
	public static ArrayList<String> getPossibleLetters() {
		return possibleLetters;
	}


	
	
	
	
}
