package tetris;
import javax.swing.JFrame;
public class WindowGame {
    public static final int WIDTH = 400 , HEIGHT = 600 ;
    private JFrame window ;
    public WindowGame() {
        window = new JFrame("Tetris ");
        window.setSize(WIDTH, HEIGHT);

    }
    public static void main(String[] args) {
        new WindowGame();
    }
}