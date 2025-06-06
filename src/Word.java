import java.util.Arrays;

public class Word {

	    private String actualWord;
	    private char[] hiddenWord;

	    public Word(String word) {
	    	
	    	//set string version of word to input from dictionary
	        setActualWord(word);
	        hiddenWord = new char[word.length()];
	        
	        //create hidden word that replaces chars for -
	        Arrays.fill(hiddenWord, '-');
	    }

	 
	    //standard getters and setterse
	    public String getHiddenWord() {
	        return new String(hiddenWord);
	    }

		public String getActualWord() {
			return actualWord;
		}

		public void setActualWord(String actualWord) {
			this.actualWord = actualWord;
		}
		
		public void setHiddenWord(int index, char letter) {
			hiddenWord[index] = letter;
		}

	
	
}
