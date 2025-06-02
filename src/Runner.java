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
    
    PlayButton playbutton = new PlayButton(130, 190);
    
    EasyButton easybutton = new EasyButton(50, 50);
    MediumButton mediumbutton = new MediumButton(250, 50);
    HardButton hardbutton = new HardButton(450, 50);
    
    Smile smile = new Smile();
    Smile smile1 = new Smile();
    
    Head head = new Head();
    Head head1 = new Head();
   
    Body body = new Body();
    Body body1 = new Body();
    
    LeftArm leftarm = new LeftArm();
    LeftArm leftarm1 = new LeftArm();
    
    RightArm rightarm = new RightArm();
    RightArm rightarm1 = new RightArm();
    
    LeftLeg leftleg = new LeftLeg();
    LeftLeg leftleg1 = new LeftLeg();
    
    RightLeg rightleg = new RightLeg();
    RightLeg rightleg1 = new RightLeg();
    
    Hair hair = new Hair();
    Hair hair1 = new Hair();
    
    LeftEye lefteye = new LeftEye();
    LeftEye lefteye1 = new LeftEye();
    
    RightEye righteye = new RightEye();
    RightEye righteye1 = new RightEye();
    
  
    
  
 
    
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
	
		
		if(Dictionary.getDifficulty() == 1) {
			
			String string = dict.getRandomEasyWord();
			Word playerWord = new Word(string);
			
			String NPCstring = dict.getRandomEasyWord();
			Word NPCword = new Word(NPCstring);
			
			GameLogic.createPlayer(playerWord);
			
			GameLogic.createNPC(NPCword);
			
		}
		
		if(Dictionary.getDifficulty() == 2) {
			
			String string = dict.getRandomMediumWord();
			Word playerWord = new Word(string);
			
			String NPCstring = dict.getRandomMediumWord();
			Word NPCword = new Word(NPCstring);
			
			GameLogic.createPlayer(playerWord);
			
			GameLogic.createNPC(NPCword);
			
		}
		
		if(Dictionary.getDifficulty() == 3) {
			
			String string = dict.getRandomHardWord();
			Word playerWord = new Word(string);
	
			
			String NPCstring = dict.getRandomHardWord();
			Word NPCword = new Word(NPCstring);
			
			GameLogic.createPlayer(playerWord);
			
			GameLogic.createNPC(NPCword);
			
		}
		
		
		if(Player.getName() != null ) {
			System.out.println("testing... player word: " + Player.getCurrentWord());
			System.out.println("testing... NPC word: " + NPCplayer.getCurrentWord());
		}
		
		
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
        easybutton.paint(g); 
        mediumbutton.paint(g);
        hardbutton.paint(g);
        
        playbutton.paint(g);

        g.setFont(myFont);
        g.setColor(Color.BLACK);

        if(Player.getName() != null) {
            g.drawString("Lives: " + Player.getHealth(), 60, 210);
            g.drawString(Player.getName(), 60, 180);
        }

        if(NPCplayer.getNPCName() != null) {
            g.drawString("Lives: " + NPCplayer.getHealth(), 410, 210);
            g.drawString(NPCplayer.getNPCName(), 410, 180);
        }
        
        if(Dictionary.getDifficulty() == 1) {
        	g.drawString("EASY", 100, 200);
        }
        
        if(Dictionary.getDifficulty() == 2) {
        	g.drawString("MEDIUM", 100, 200);
        }
        
        if(Dictionary.getDifficulty() == 3) {
        	g.drawString("HARD", 100, 200);
        }
    }

    

    
    
    // Stub methods for the interfaces
    @Override public void actionPerformed(ActionEvent e) { repaint(); }
    @Override public void mouseClicked(MouseEvent e) {}
    
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (easybutton.isClicked(mouseX, mouseY)) {
            System.out.println("Easy button clicked!");
            Dictionary.setDifficulty(1);  
            
        }
        
        if (mediumbutton.isClicked(mouseX, mouseY)) {
            System.out.println("medium button clicked!");
            Dictionary.setDifficulty(2);  
           
        }
        
        if (hardbutton.isClicked(mouseX, mouseY)) {
            System.out.println("hard button clicked!");
            Dictionary.setDifficulty(3);
          
        }
        
        if (playbutton.isClicked(mouseX, mouseY)) {
            System.out.println("play button clicked!");
           
          
        }
        
    }
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}

