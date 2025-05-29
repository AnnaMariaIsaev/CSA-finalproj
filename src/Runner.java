import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Runner extends JPanel implements ActionListener, MouseListener, KeyListener {


   // int waveTimer = 5;
   // long ellapseTime = 0;
    Font timeFont = new Font("Courier", Font.BOLD, 70);
    int lives = 5;
    //int score = 0;


    Font myFont = new Font("Courier", Font.BOLD, 20);
    Background background = new Background();
    int width = 600;
    int height = 600;

	        

    public Runner() {
        JFrame f = new JFrame("Hangman");
        f.setSize(new Dimension(width, height));
        f.setBackground(Color.white);
        f.add(this);
        f.setResizable(false);
        f.addMouseListener(this);
        f.addKeyListener(this);

        Timer t = new Timer(16, this);
        t.start();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
  //MAIN METHOD
    public static void main(String[] arg) {
        new Runner();
      
		System.out.println("testing");
		
		Dictionary dict = new Dictionary();
		
		
		int diff = 1;
		dict.setDifficulty(diff);
		
		if(dict.getDifficulty() == 1) {
			
			String string = dict.getRandomEasyWord();
			Word playerWord = new Word(string);
			
			String NPCstring = dict.getRandomEasyWord();
			Word NPCword = new Word(NPCstring);
			
			GameLogic.createPlayer(playerWord);
			
			GameLogic.createNPC(NPCword);
			
		}
		
		if(dict.getDifficulty() == 2) {
			
			String string = dict.getRandomMediumWord();
			Word playerWord = new Word(string);
			
			String NPCstring = dict.getRandomMediumWord();
			Word NPCword = new Word(NPCstring);
			
			GameLogic.createPlayer(playerWord);
			
			GameLogic.createNPC(NPCword);
			
		}
		
		if(dict.getDifficulty() == 3) {
			
			String string = dict.getRandomHardWord();
			Word playerWord = new Word(string);
	
			
			String NPCstring = dict.getRandomHardWord();
			Word NPCword = new Word(NPCstring);
			
			GameLogic.createPlayer(playerWord);
			
			GameLogic.createNPC(NPCword);
			
		}
		
		
		
		System.out.println("testing... player word: " + Player.getCurrentWord());
		System.out.println("testing... NPC word: " + NPCplayer.getCurrentWord());
		
		while(Player.getHealth() > 0 && NPCplayer.getNPCHealth() >0) {
			GameLogic.guessLetterP();
			GameLogic.guessLetterNPC();
		}
      
    }


    // THIS is the correct method to override
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.paint(g);
        String scores = Integer.toString(lives);
        g.setFont(myFont);
        g.setColor(Color.BLACK);
        
        
        
        if(Player.getName() != null) {
        	g.drawString("Lives: " + Integer.toString(Player.getHealth()), 60, 210);
        	g.drawString(Player.getName(), 60, 180);
        
        }
        
        if(NPCplayer.getNPCName() != null) {
        	g.drawString("Lives: " + Integer.toString(NPCplayer.getHealth()), 410, 210);
        	g.drawString(NPCplayer.getNPCName(), 410, 180);
        }
        //this part doesn't work because it starts before
        //the player is created
        
        //String pWord = Player.getCurrentWord();
  
       
       
      
    }

    
    
    // Stub methods for the interfaces
    @Override public void actionPerformed(ActionEvent e) { repaint(); }
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}

