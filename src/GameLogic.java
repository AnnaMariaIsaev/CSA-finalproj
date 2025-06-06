public class GameLogic {
    
	
	//create player
    public static void createPlayer(String name, Word word) {
    	
        Player player = new Player(name, word);
    }
    
    //create NPC
    public static void createNPC(Word word) {
    	
        NPCplayer NPC = new NPCplayer(word);
        String name = NPCplayer.setNPCName();
        
    }
    
    public static void guessLetterP(String letter) {
    	
    	//if the guessed letter is in possible letters, remove
        if(Player.getPossibleLetters().contains(letter)) {
            Player.removeGuessedLetter(letter);
            
            String word = Player.getCurrentWord();
            int len = word.length();
            
            //check if the letter is in the word
            if(!word.contains(letter)) {
            	
            	//if not add to the incorrect letter list
                Player.addIncorrectLetters(letter);
                Player.setHealth(Player.getHealth() - 1);
                
            } else {
            	
            	//loop through word, if in word reveal letter
                for (int i = 0; i < len; i++) {
                	
                    if (word.substring(i, i + 1).equals(letter)) {
                        Player.getWordClass().setHiddenWord(i, letter.charAt(0));
                    }
                    
                }
            }
        }
    }
    
    public static void guessLetterNPC() {
    	
    	//if there are letters left to guess, 
    	//pick a random letter from the list
        if (NPCplayer.getPossibleLetters().size() > 0) {
        	
            String letter = NPCplayer.guessLet((int) (Math.random() * NPCplayer.getPossibleLetters().size()));
            String word = NPCplayer.getCurrentWord();
            int len = word.length();
            
            if(!word.contains(letter)) {
            	
            	//if letter not in word at to incorrect list
                NPCplayer.addIncorrectLetters(letter);
                NPCplayer.setHealth(NPCplayer.getHealth() - 1);
                
            } else {
            	
            	//if in word reveal
                for (int i = 0; i < len; i++) {
                	
                    if (word.substring(i, i + 1).equals(letter)) {
                        NPCplayer.getWordClass().setHiddenWord(i, letter.charAt(0));
                    }
                    
                }
            }
        }
    }
}