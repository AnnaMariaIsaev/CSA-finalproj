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
		
		String name = NPCplayer.setNPCName();
		
		NPCplayer NPC = new NPCplayer(word);
		
		//for testng
		System.out.println("you are playing against: " + NPC.getNPCName());
		
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
		
		
		String word = Player.getCurrentWord();
		int len = word.length();
		
		if(word.contains(letter) == false) {
			
			Player.addIncorrectLetters(letter);

			Player.setHealth(Player.getHealth() - 1);
			
			//add code to display the list of incorrect letters on the screen
			
		}
		
		
		for(int i = 0; i < len-1; i++) {
			
			if(word.substring(i, i+1).equals(letter)) {
				
				//put code here to reveal the letters in the -- placeholder
				
			}
			
		}
		
		//TO DO:
		/*
		 * 1) find a way to check if the guessed letter is in the word /// DONE
		 * 2) if it isn't, add to incorrect guesses which will display
		 * 		on the screen //// DONE
		 * 3) correctly guessed letters should show in the word which 
		 * 		is initially hidden by ----- 
		 * 
		 * **guessed letters is a second list to ensure there are no 
		 * 		repeats, do not allow player to repeat the letters
		 * 		in the user input
		 */
		
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
