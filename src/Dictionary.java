import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary {

	private static int difficulty;
	
	/*
	 * since there are three rounds per match, 
	 * we will use arraylists to make sure the words dontget repeated
	 * 
	 */
	
	private ArrayList<String> easyWords;
	
	private ArrayList<String> mediumWords;
	
	private ArrayList<String> hardWords;
	
	
	public Dictionary() {
		
		easyWords = new ArrayList<>(Arrays.asList(
				"apple", "brave", "chair", "dream", "eagle", "flame", 
				"grape", "house", "ivory", "jelly", "knife", "lemon", 
				"mango", "noble", "ocean", "piano", "queen", "river", "stone", 
				"table"
			));
		
		mediumWords = new ArrayList<>(Arrays.asList(
				"balance", "cabinet", "diamond", "elastic", "freedom", "gateway", 
				"harvest", "imagine", "journey", "kingdom", "library", "musical", 
				"natural", "octagon", "passion", "quality", "reality", "silence", 
				"traffic", "upgrade"

			));
		
		hardWords = new ArrayList<>(Arrays.asList(
				"basketball", "cooperation", "development", "friendships", 
				"greenhouse", "headquarters", "imagination", "journalists", 
				"kindergarten", "leadership", "motivation", "negotiation", 
				"opposition", "partnership", "questioning", "relationship", 
				"speculation", "technology", "understood", "volunteers"

			));
		
		difficulty = 0;
		
	}
	
	
	
	//fix this
	public  String getRandomEasyWord() {
        if (easyWords.isEmpty()) {
            return null; // or throw exception
        }
		
        int random = (int)(Math.random() * easyWords.size());
        String word = easyWords.get(random);
        easyWords.remove(random);
        
        return word;
       
    }

    public String getRandomMediumWord() {
    	
        if (mediumWords.isEmpty()) {
            return null;
        }
        
        int random = (int)(Math.random() * mediumWords.size());

        String word = mediumWords.get(random);
        mediumWords.remove(random);
        
        return word;
    }

    public String getRandomHardWord() {
        if (hardWords.isEmpty()) {
            return null;
        }
       
        int random = (int)(Math.random() * hardWords.size());

        String word = hardWords.get(random);
        hardWords.remove(random);
        
        return word;
    }
	
    
    public static  void setDifficulty(int val) {
    	difficulty = val;
    }
    
    public static int getDifficulty() {
    	return difficulty;
    }
	
}
