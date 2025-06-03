import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Runner extends JPanel implements ActionListener, MouseListener, KeyListener {

	private boolean gameStarted = false;

	Font myFont = new Font("Courier", Font.BOLD, 20);
	Background background = new Background();

	PlayButton playbutton = new PlayButton(130, 190);
	EasyButton easybutton = new EasyButton(50, 50);
	MediumButton mediumbutton = new MediumButton(250, 50);
	HardButton hardbutton = new HardButton(450, 50);

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

	public static void main(String[] arg) {
		new Runner();
	}

	private void startGame() {
		gameStarted = true;
		Dictionary dict = new Dictionary();

		String playerWordString = "";
		String npcWordString = "";

		if (Dictionary.getDifficulty() == 1) {
			
			playerWordString = dict.getRandomEasyWord();
			npcWordString = dict.getRandomEasyWord();
			
		} else if (Dictionary.getDifficulty() == 2) {
			
			playerWordString = dict.getRandomMediumWord();
			npcWordString = dict.getRandomMediumWord();
			
		} else if (Dictionary.getDifficulty() == 3) {
			
			playerWordString = dict.getRandomHardWord();
			npcWordString = dict.getRandomHardWord();
		}

		if (!playerWordString.isEmpty() && !npcWordString.isEmpty()) {
			Word playerWord = new Word(playerWordString);
			Word npcWord = new Word(npcWordString);

			GameLogic.createPlayer(playerWord);
			GameLogic.createNPC(npcWord);

			System.out.println("Player word: " + Player.getCurrentWord());
			System.out.println("NPC word: " + NPCplayer.getCurrentWord());
			
			
			//change this so that loop ends once player guesses all of the letters
			while(Player.getHealth() > 0 && NPCplayer.getNPCHealth() >0) {
				GameLogic.guessLetterP();
				GameLogic.guessLetterNPC();
			}
			
			repaint();
		}
		else {
			System.out.println("Word generation failed. Check Dictionary methods.");
		}
	}

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

		if (gameStarted && Player.getName() != null) {
			g.drawString("Lives: " + Player.getHealth(), 60, 210);
			g.drawString(Player.getName(), 60, 180);
		}

		if (gameStarted && NPCplayer.getNPCName() != null) {
			g.drawString("Lives: " + NPCplayer.getHealth(), 410, 210);
			g.drawString(NPCplayer.getNPCName(), 410, 180);
		}

		if (Dictionary.getDifficulty() == 1) {
			g.drawString("EASY", 100, 200);
		} else if (Dictionary.getDifficulty() == 2) {
			g.drawString("MEDIUM", 100, 200);
		} else if (Dictionary.getDifficulty() == 3) {
			g.drawString("HARD", 100, 200);
		}
	}

	@Override public void actionPerformed(ActionEvent e) { repaint(); }
	@Override public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();

		if (easybutton.isClicked(mouseX, mouseY)) {
			System.out.println("Easy button clicked!");
			Dictionary.setDifficulty(1);
			System.out.println("difficulty now: " + Dictionary.getDifficulty());
		}

		if (mediumbutton.isClicked(mouseX, mouseY)) {
			System.out.println("Medium button clicked!");
			Dictionary.setDifficulty(2);
			System.out.println("difficulty now: " + Dictionary.getDifficulty());
		}

		if (hardbutton.isClicked(mouseX, mouseY)) {
			System.out.println("Hard button clicked!");
			Dictionary.setDifficulty(3);
			System.out.println("difficulty now: " + Dictionary.getDifficulty());
		}

		if (playbutton.isClicked(mouseX, mouseY) && Dictionary.getDifficulty() != 0 && !gameStarted) {
			System.out.println("Play button clicked!");
			startGame();
		}
	}

	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyPressed(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {}
}