package tetris;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class Title extends JPanel implements KeyListener{

    private WindowGame window ;

    public Title(WindowGame window){
        this.window = window;

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        String title = "TETRIS GAME";
        int titleWidth = g.getFontMetrics().stringWidth(title);
        int titleX = (getWidth() - titleWidth) / 2;
        g.drawString(title, titleX, 80);

        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("ROTATE " , 160, 140);

        g.setFont(new Font("Arial", Font.BOLD, 42));
        g.drawString("↑", 205, 195);
        g.drawString("←", 120, 270);
        g.drawString("↓", 205, 270);
        g.drawString("→", 290, 270);

        g.setFont(new Font("Arial", Font.BOLD, 18));

        g.drawString("MOVE", 55 , 325);
        g.drawString("LEFT",65,350);

        g.drawString("SPEED", 180 , 325);
        g.drawString("UP",215,350);

        g.drawString("MOVE", 305 , 325);
        g.drawString("RIGHT",295,350);

        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString("Press ENTER to start", 145, 450);
        g.drawString("Press SPACE to pause in game", 115, 475);

        //show option to choose game mode
        g.setColor(Board.USE_IMAGE_MODE ? Color.WHITE : Color.GREEN);
        g.drawString("Press 1: Classic Mode " + (Board.USE_IMAGE_MODE ? "" : "[X]"), 100, 380);
        g.setColor(Board.USE_IMAGE_MODE ? Color.GREEN : Color.WHITE);
        g.drawString("Press 2: Image Mode " + (Board.USE_IMAGE_MODE ? "[X]" : ""), 100, 410);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_1) Board.USE_IMAGE_MODE = false;
        if (e.getKeyCode() == KeyEvent.VK_2) Board.USE_IMAGE_MODE = true;
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            window.startGame();
        }
        repaint();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        
    }
}
