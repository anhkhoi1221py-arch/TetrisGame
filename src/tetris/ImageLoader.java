package tetris;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage loadImage(String path) {
        try {
            //load image from game
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (Exception e) {
            return null; //return null if image not found and start classic mode
        }
    }
}
