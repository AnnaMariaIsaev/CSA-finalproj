import java.util.ArrayList;
import java.util.Arrays;

public class Player {

	//initialize variables
	private static String name;
	private static int health;
	private static Word currentWord;
	
	private static ArrayList<String> possibleLetters;
	private static ArrayList<String> incorrectLetters;
	
	public Player(String name, Word currentWord) {
		
		Player.name = name;
	
		health = 10;
		
		Player.currentWord = currentWord;
		
		incorrectLetters = new ArrayList<>();
		
		//create possible letters list to pick letters
		possibleLetters = new ArrayList<>(Arrays.asList(
			    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
			));
		
	}

	
	//auto generated getters and setters
	
	public static String getName() {
		return name;
	}

	public void setName(String name) {
		Player.name = name;
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
	
	public static void addIncorrectLetters(String letter) {
		incorrectLetters.add(letter);
	}
	
	
	public static ArrayList<String> getPossibleLetters() {
		return possibleLetters;
	}

	public static ArrayList<String> getIncorrect(){
		return Player.incorrectLetters;
	}
	
	
	//use to access methods of the player word in other classes
	public static Word getWordClass() {
		return Player.currentWord;
	}

	
	
}
