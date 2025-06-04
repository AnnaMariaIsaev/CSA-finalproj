public class GameLogic {
    
    public static void createPlayer(String name, Word word) {
        Player player = new Player(name, word);
    }
    
    public static void createNPC(Word word) {
        NPCplayer NPC = new NPCplayer(word);
        String name = NPCplayer.setNPCName();
    }
    
    public static void guessLetterP(String letter) {
        if(Player.getPossibleLetters().contains(letter)) {
            Player.removeGuessedLetter(letter);
            
            String word = Player.getCurrentWord();
            int len = word.length();
            
            if(!word.contains(letter)) {
                Player.addIncorrectLetters(letter);
                Player.setHealth(Player.getHealth() - 1);
            } else {
                for (int i = 0; i < len; i++) {
                    if (word.substring(i, i + 1).equals(letter)) {
                        Player.getWordClass().setHiddenWord(i, letter.charAt(0));
                    }
                }
            }
        }
    }
    
    public static void guessLetterNPC() {
        if (NPCplayer.getPossibleLetters().size() > 0) {
            String letter = NPCplayer.guessLet((int) (Math.random() * NPCplayer.getPossibleLetters().size()));
            String word = NPCplayer.getCurrentWord();
            int len = word.length();
            
            if(!word.contains(letter)) {
                NPCplayer.addIncorrectLetters(letter);
                NPCplayer.setHealth(NPCplayer.getHealth() - 1);
            } else {
                for (int i = 0; i < len; i++) {
                    if (word.substring(i, i + 1).equals(letter)) {
                        NPCplayer.getWordClass().setHiddenWord(i, letter.charAt(0));
                    }
                }
            }
        }
    }
}