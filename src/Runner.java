import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Runner extends JPanel implements ActionListener, MouseListener, KeyListener {

    final int game = 0;
    final int kill = 0;
    final boolean win = false;
    final boolean dead = false;
    int current = game;

    int waveTimer = 5;
    long ellapseTime = 0;
    Font timeFont = new Font("Courier", Font.BOLD, 70);
    int lives = 5;
    int score = 0;

    Font myFont = new Font("Courier", Font.BOLD, 40);
    Background background = new Background();
    int width = 600;
    int height = 600;

    public Runner() {
        JFrame f = new JFrame("Duck Hunt");
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

    // THIS is the correct method to override
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.paint(g);
        String scores = Integer.toString(lives);
        g.setFont(myFont);
        g.setColor(Color.BLACK);
        g.drawString("Lives: " + scores, 10, 50);
    }

    public static void main(String[] arg) {
        new Runner();
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