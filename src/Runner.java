import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Runner extends JPanel implements ActionListener, MouseListener, KeyListener {
    private boolean gameStarted = false;
    private boolean difficultySet = false;
    private boolean nameEntered = false;
    private boolean waitingForPlayerInput = false;
    private boolean gameOver = false;
    private String playerName = "";
    
    Font myFont = new Font("Courier", Font.BOLD, 20);
    Font smallFont = new Font("Courier", Font.BOLD, 16);
    
    Background background = new Background();
    PlayButton playbutton = new PlayButton(130, 190);
    EasyButton easybutton = new EasyButton(50, 50);
    MediumButton mediumbutton = new MediumButton(250, 50);
    HardButton hardbutton = new HardButton(450, 50);
    
    int width = 600;
    int height = 600;
    
    // Game state variables
    private String currentInput = "";
    private String message = "";
    
    public Runner() {
        JFrame f = new JFrame("Hangman");
        f.setSize(new Dimension(width, height));
        f.setBackground(Color.white);
        f.add(this);
        f.setResizable(false);
        f.addMouseListener(this);
        f.addKeyListener(this);
        f.setFocusable(true);
        f.requestFocus();
        
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
        difficultySet = true;
        nameEntered = false;
        message = "Enter your name: ";
        currentInput = "";
        repaint();
    }
    
    private void initializeGameLogic() {
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
            
            GameLogic.createPlayer(playerName, playerWord);
            GameLogic.createNPC(npcWord);
            
            System.out.println("Player word: " + Player.getCurrentWord());
            System.out.println("NPC word: " + NPCplayer.getCurrentWord());
            
            waitingForPlayerInput = true;
            message = "Guess a letter: ";
            currentInput = "";
        } else {
            message = "Word generation failed";
        }
    }
    
    private void processPlayerGuess(String letter) {
        if (letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
            letter = letter.toLowerCase();
            
            if (Player.getPossibleLetters().contains(letter)) {
                GameLogic.guessLetterP(letter);
                
                // Check if player won or lost
                if (!Player.getWordClass().getHiddenWord().contains("-")) {
                    message = "You won! You guessed: " + Player.getCurrentWord();
                    gameOver = true;
                    waitingForPlayerInput = false;
                } else if (Player.getHealth() <= 0) {
                    message = "You lost! Word was: " + Player.getCurrentWord();
                    gameOver = true;
                    waitingForPlayerInput = false;
                } else {
                    // Continue with NPC turn and check game state
                    checkGameStateAndContinue();
                }
            } else {
                message = "Letter already guessed! Try again: ";
            }
            currentInput = "";
        } else {
            message = "Invalid input! Enter a single letter: ";
            currentInput = "";
        }
    }
    
    private void checkGameStateAndContinue() {
        // NPC takes one turn
        GameLogic.guessLetterNPC();
        
        // Check if NPC won by completing their word
        if (!NPCplayer.getWordClass().getHiddenWord().contains("-")) {
            message = "NPC won! NPC guessed: " + NPCplayer.getCurrentWord();
            gameOver = true;
            waitingForPlayerInput = false;
        }
        // Check if NPC lost by running out of lives
        else if (NPCplayer.getNPCHealth() <= 0) {
            message = "You won! NPC ran out of lives!";
            gameOver = true;
            waitingForPlayerInput = false;
        }
        // Game continues - back to player's turn
        else {
            message = "Guess a letter: ";
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.paint(g);
        
        // Only show menu buttons if game hasn't started
        if (!gameStarted) {
            easybutton.paint(g);
            mediumbutton.paint(g);
            hardbutton.paint(g);
            playbutton.paint(g);
            
            g.setFont(myFont);
            g.setColor(Color.BLACK);
            
            if (Dictionary.getDifficulty() == 1) {
                g.drawString("EASY", 100, 200);
            } else if (Dictionary.getDifficulty() == 2) {
                g.drawString("MEDIUM", 100, 200);
            } else if (Dictionary.getDifficulty() == 3) {
                g.drawString("HARD", 100, 200);
            }
        } else {
            // Game UI
            g.setFont(myFont);
            g.setColor(Color.BLACK);
            
            if (!nameEntered) {
                g.drawString(message, 50, 250);
                g.drawString(currentInput + "_", 50, 280);
            } else {
                // Player info
                g.drawString("Player: " + Player.getName(), 50, 100);
                g.drawString("Lives: " + Player.getHealth(), 50, 130);
                g.drawString("Word: " + Player.getWordClass().getHiddenWord(), 50, 160);
                
                // NPC info
                g.drawString("NPC: " + NPCplayer.getNPCName(), 350, 100);
                g.drawString("Lives: " + NPCplayer.getNPCHealth(), 350, 130);
                g.drawString("Word: " + NPCplayer.getWordClass().getHiddenWord(), 350, 160);
                
                // Available letters
                g.setFont(smallFont);
                g.drawString("Available: " + Player.getPossibleLetters(), 50, 200);
                
                // Incorrect letters
                if (!Player.getIncorrect().isEmpty()) {
                    g.drawString("Wrong: " + Player.getIncorrect(), 50, 220);
                }
                
                g.setFont(myFont);
                if (!gameOver) {
                    g.drawString(message, 50, 350);
                    g.drawString(currentInput + "_", 50, 380);
                } else {
                    g.drawString(message, 50, 350);
                    g.drawString("Press R to restart", 50, 380);
                }
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}
    
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        if (!gameStarted) {
            if (easybutton.isClicked(mouseX, mouseY)) {
                Dictionary.setDifficulty(1);
            }
            
            if (mediumbutton.isClicked(mouseX, mouseY)) {
                Dictionary.setDifficulty(2);
            }
            
            if (hardbutton.isClicked(mouseX, mouseY)) {
                Dictionary.setDifficulty(3);
            }
            
            if (playbutton.isClicked(mouseX, mouseY) && Dictionary.getDifficulty() != 0) {
                startGame();
            }
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        int keyCode = e.getKeyCode();
        
        if (gameStarted && !nameEntered) {
            // Name input
            if (keyCode == KeyEvent.VK_BACK_SPACE && currentInput.length() > 0) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
            } else if (keyCode == KeyEvent.VK_ENTER && !currentInput.trim().isEmpty()) {
                playerName = currentInput.trim();
                nameEntered = true;
                initializeGameLogic();
            } else if (Character.isLetter(key) && currentInput.length() < 15) {
                currentInput += key;
            }
        } else if (gameStarted && nameEntered && waitingForPlayerInput && !gameOver) {
            // Letter guessing
            if (keyCode == KeyEvent.VK_BACK_SPACE && currentInput.length() > 0) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
            } else if (keyCode == KeyEvent.VK_ENTER && !currentInput.trim().isEmpty()) {
                processPlayerGuess(currentInput.trim());
            } else if (Character.isLetter(key) && currentInput.length() < 1) {
                currentInput = String.valueOf(key);
            }
        } else if (gameOver && (key == 'r' || key == 'R')) {
            // Restart game
            gameStarted = false;
            difficultySet = false;
            nameEntered = false;
            waitingForPlayerInput = false;
            gameOver = false;
            playerName = "";
            currentInput = "";
            message = "";
            Dictionary.setDifficulty(0);
        }
        
        repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}
}