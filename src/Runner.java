

public class Runner {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hello world");
		System.out.println("testing");
		
		GameLogic.createPlayer();
		GameLogic.createNPC();
		
		while(Player.getHealth() > 0 && NPCplayer.getNPCHealth() >0) {
			GameLogic.guessLetterP();
		}
	        
	}


}
