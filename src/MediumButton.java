import java.awt.*;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class MediumButton {
    private Image image;
    private AffineTransform tx;

    // Position and scaling
    private int x, y;
    private int width = 100;   // You can adjust this to match your image's real dimensions
    private int height = 100;
    private double scaleWidth = 1.5;
    private double scaleHeight = 1.5;

    // Difficulty value (optional, for gameplay logic)
    private int difficulty = 1;

    public MediumButton(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = getImage("mediumbutton.png"); // Ensure the image is in your /resources folder
        this.tx = AffineTransform.getTranslateInstance(x, y);
        this.tx.scale(scaleWidth, scaleHeight);
    }

    /** Draw the button on the screen manually */
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        tx.setToTranslation(x, y);
        tx.scale(scaleWidth, scaleHeight);
        g2.drawImage(image, tx, null);
        
        
    }

    /** Check if mouse click was inside the button */
    public boolean isClicked(int mouseX, int mouseY) {
        int btnWidth = (int)(width * scaleWidth);
        int btnHeight = (int)(height * scaleHeight);

        return mouseX >= x && mouseX <= x + btnWidth &&
               mouseY >= y && mouseY <= y + btnHeight;
    }

    /** Get image from resource folder */
    private Image getImage(String path) {
        Image tempImage = null;
        try {
            URL imageURL = getClass().getResource("/" + path);
            if (imageURL != null) {
                tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
            } else {
                System.err.println("Could not load image: " + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempImage;
    }

    // Optional: getter/setter for difficulty
    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    // Optional: get X/Y if needed externally
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
