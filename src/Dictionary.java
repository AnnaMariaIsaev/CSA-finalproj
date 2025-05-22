import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary {

	/*
	 * since there are three rounds per match, 
	 * we will use arraylists to make sure the words dontget repeated
	 * 
	 */
	
	private ArrayList<String> easyWords = new ArrayList<>(Arrays.asList(
			"apple", "brave", "chair", "dream", "eagle", "flame", 
			"grape", "house", "ivory", "jelly", "knife", "lemon", 
			"mango", "noble", "ocean", "piano", "queen", "river", "stone", 
			"table"
		));
	
	private ArrayList<String> mediumWords = new ArrayList<>(Arrays.asList(
			"balance", "cabinet", "diamond", "elastic", "freedom", "gateway", 
			"harvest", "imagine", "journey", "kingdom", "library", "musical", 
			"natural", "octagon", "passion", "quality", "reality", "silence", 
			"traffic", "upgrade"

		));
	
	private ArrayList<String> hardWords = new ArrayList<>(Arrays.asList(
			"basketball", "cooperation", "development", "friendships", 
			"greenhouse", "headquarters", "imagination", "journalists", 
			"kindergarten", "leadership", "motivation", "negotiation", 
			"opposition", "partnership", "questioning", "relationship", 
			"speculation", "technology", "understood", "volunteers"

		));
	
	
	
	//fix this
	public String getRandomEasyWord() {
        if (easyWords.isEmpty()) {
            return null; // or throw exception
        }
		
        int random = (int)(Math.random() * 20);
        String word = easyWords.get(random);
        easyWords.remove(random);
        
        return word;
       
    }

    public String getRandomMediumWord() {
    	
        if (mediumWords.isEmpty()) {
            return null;
        }
        
        int random = (int)(Math.random() * 20);
        String word = mediumWords.get(random);
        mediumWords.remove(random);
        
        return word;
    }

    public String getRandomHardWord() {
        if (hardWords.isEmpty()) {
            return null;
        }
       
        int random = (int)(Math.random() * 20);
        String word = hardWords.get(random);
        hardWords.remove(random);
        
        return word;
    }
	

	
}
