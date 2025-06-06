import java.util.ArrayList;
import java.util.Arrays;
public class NPCplayer {

	//initialize variables
	private static Word currentWord;
	private static int health;
	private static String name;
	private static ArrayList<String> possibleLetters;
	private static ArrayList<String> incorrectLetters;
	
	//create name list to pick for NPC names
	private static String[] names = {"Kerry Carpenter", "Tisha Andersen",
			"Gerardo Vaughn", "Palmer Riggs", "Connie Moyer", "Javier Mcneil",
			"Manual Allen", "Anderson Watkins"};
	
	public NPCplayer(Word currentWord) {
		
		NPCplayer.setCurrentWord(currentWord);
		
		health = 10;
		
		//available letters to pick from
		possibleLetters = new ArrayList<>(Arrays.asList(
			    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
			));
		NPCplayer.name = "";
		
		incorrectLetters = new ArrayList<>();
		
		
	}
	
	//method to pick random name for NPC
	public static String setNPCName() {
		
		String name = "";
		
		int random = (int)(Math.random() * 8);
		
		name = names[random];
		
		NPCplayer.name = name;
		
		return name;
	}
	
	
	
	//auto generated getters and setters
	
	public static int getNPCHealth() {
		return health;
	}
	public void setNPCHealth(int val) {
		health = val;
	}
	
	public static String getNPCName() {
		return name;
	}
	
	public static ArrayList<String> getPossibleLetters() {
		return possibleLetters;
	}
	
	
	//helper method for NPC randomized letter
	public static String guessLet(int index) {
		
		String letter = NPCplayer.getPossibleLetters().get(index);
		NPCplayer.possibleLetters.remove(index);
		return letter;
	}
	
	//get string version of word
	public static String getCurrentWord() {
		return currentWord.getActualWord();
	}
	
	public static void setCurrentWord(Word currentWord) {
		NPCplayer.currentWord = currentWord;
	}
	
	//access methods of NPC word
	public static Word getWordClass() {
		
		return NPCplayer.currentWord;
	}
	
	
	public static int getHealth() {
		return health;
	}
	
	public static void setHealth(int num) {
		health = num;
	}
	
	public static void addIncorrectLetters(String letter) {
		incorrectLetters.add(letter);
	}
	
	public static ArrayList<String> getIncorrect(){
		return NPCplayer.incorrectLetters;
	}
	
}

