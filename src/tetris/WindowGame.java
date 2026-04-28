package tetris;
import javax.swing.JFrame;
public class WindowGame {
    public static final int WIDTH = 400 , HEIGHT = 600 ;
    private Board board ;
    private JFrame window ;
    public WindowGame() {
        window = new JFrame("Tetris ");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        
        board = new Board();
        window.add(board);
        window.setVisible(true);
    }
    public static void main(String[] args) {
        new WindowGame();
    }
}