import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

public class PlayButton {
    private BufferedImage image;
    private AffineTransform tx;

    // Position and scaling
    private int x, y;
    private int width;   // Will be set based on image dimensions
    private int height;
    private double scaleWidth = 0.3;
    private double scaleHeight = 0.3;

    // Hitbox scale (smaller than visual image)
    private double hitboxScaleW = 0.3; // 60% of visual width
    private double hitboxScaleH = 0.4; // 60% of visual height

    public PlayButton(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = getImage("playbutton.png");
        if (image != null) {
            this.width = image.getWidth();
            this.height = image.getHeight();
        } else {
            this.width = 100;
            this.height = 100;
        }
        this.tx = AffineTransform.getTranslateInstance(x, y);
        this.tx.scale(scaleWidth, scaleHeight);
    }

    /** Draw the button and visible hitbox on screen */
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        tx.setToTranslation(x, y);
        tx.scale(scaleWidth, scaleHeight);
        g2.drawImage(image, tx, null);

     
    }

    /** Check if mouse click was inside the smaller hitbox */
    public boolean isClicked(int mouseX, int mouseY) {
        int visWidth = (int)(width * scaleWidth);
        int visHeight = (int)(height * scaleHeight - 80);
        int btnWidth = (int)(visWidth * hitboxScaleW);
        int btnHeight = (int)(visHeight * hitboxScaleH);
        int offsetX = (visWidth - btnWidth) / 2 - 20;
        int offsetY = (visHeight - btnHeight) / 2 + 90;

        return mouseX >= x + offsetX && mouseX <= x + offsetX + btnWidth &&
               mouseY >= y + offsetY && mouseY <= y + offsetY + btnHeight;
    }

    /** Get image from resource folder */
    private BufferedImage getImage(String path) {
        BufferedImage tempImage = null;
        try {
            URL imageURL = getClass().getResource("/" + path);
            if (imageURL != null) {
                tempImage = ImageIO.read(imageURL);
            } else {
                System.err.println("Could not load image: " + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempImage;
    }

    // Optional: get X/Y if needed externally
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
