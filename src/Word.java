import java.util.Arrays;

public class Word {

/*
 * getWord()

getCurrentState() (returns the word with blanks for unguessed letters)

checkGuess(char letter)

 * 
 * 	
 */
	
	    private String actualWord;
	    private char[] hiddenWord;

	    public Word(String word) {
	        actualWord = word;
	        hiddenWord = new char[word.length()];
	        Arrays.fill(hiddenWord, '-');
	    }

	    public boolean guessLetter(char letter) {
			return false;
	        // update hiddenWord accordingly
	    }

	    public String getHiddenWord() {
	        return new String(hiddenWord);
	    }

	    public void isComplete() {
	        // check if fully guessed
	    }

	
	
}
