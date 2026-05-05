package tetris;
import javax.swing.JFrame;
public class WindowGame {
    public static final int WIDTH = 445 , HEIGHT = 637 ;
    private Board board ;
    private JFrame window ;
    private Title title;
    public WindowGame() {
        window = new JFrame("Tetris ");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        title = new Title(this);
        window.add(title);
        window.addKeyListener(title);

        window.setVisible(true);
    }
    public static void main(String[] args) {
        new WindowGame();
    }

    public void startGame(){
        window.remove(title);
        window.removeKeyListener(title);

        board = new Board();
        window.add(board);

        window.revalidate();
        window.repaint();
        board.setFocusable(true);
        board.requestFocusInWindow();
    }
}