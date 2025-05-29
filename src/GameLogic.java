import java.util.Scanner;

public class GameLogic {

	
	static Scanner scanner = new Scanner(System.in);
	
	public static void createPlayer(Word word) {
		
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();
	        
	        Player player = new Player(name, word);
	        
	        //for testing
	        System.out.println(player.getName());
	}
	
	
	public static void createNPC(Word word) {
		
		
		
		NPCplayer NPC = new NPCplayer(word);
		
		String name = NPCplayer.setNPCName();
		
		//for testng
		System.out.println("you are playing against: " + NPCplayer.getNPCName());
		
	}
	
	public static void guessLetterP() {
		System.out.println("guess a letter");
		String letter = scanner.nextLine();
		
		if(Player.getPossibleLetters().contains(letter)) {
			
			System.out.println("letter selected: " + letter);
			Player.removeGuessedLetter(letter);
			
		} else {
			letter = "";
			System.out.println("Select a new letter");
			letter = scanner.nextLine();
		}
		
		System.out.println(Player.getPossibleLetters());
		
		
		String word = Player.getCurrentWord();
		int len = word.length();
		
		if(word.contains(letter) == false) {
			
			Player.addIncorrectLetters(letter);

			Player.setHealth(Player.getHealth() - 1);
			
			//add code to display the list of incorrect letters on the screen
			System.out.println(Player.getIncorrect());
		} 
		
		else {
			

			for (int i = 0; i < len; i++) {
				
				if (word.substring(i, i + 1).equals(letter)) {
					
			            Player.getWordClass().setHiddenWord(i, letter.charAt(0));
			    }
			}
		

		}
		
		System.out.println(Player.getWordClass().getHiddenWord());
		
	}
	
	
	public static void guessLetterNPC() {
		
		String letter = NPCplayer.guessLet((int) (Math.random() * NPCplayer.getPossibleLetters().size()));
		
		String word = NPCplayer.getCurrentWord();
		int len = word.length();
		
		if(word.contains(letter) == false) {
			
			NPCplayer.addIncorrectLetters(letter);

			NPCplayer.setHealth(NPCplayer.getHealth() - 1);
			
			//add code to display the list of incorrect letters on the screen
			System.out.println("NPC" + NPCplayer.getIncorrect());
		} 
		
		else {
			

			for (int i = 0; i < len; i++) {
				
				if (word.substring(i, i + 1).equals(letter)) {
					
			            NPCplayer.getWordClass().setHiddenWord(i, letter.charAt(0));
			    }
			}
			
			System.out.println("NPC WORD: " + NPCplayer.getWordClass().getHiddenWord());
		

		}
		
	}
	
	
	
	/*
	 * displayWord()

displayHangman()

getUserInput()

displayResult()
	 * 
	 * 
	 */
	
}
