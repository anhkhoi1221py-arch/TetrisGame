package tetris;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
        String title = "TETRIS";
        int titleWidth = g.getFontMetrics().stringWidth(title);
        int titleX = (getWidth() - titleWidth) / 2;
        g.drawString(title, titleX, 80);

        g.setFont(new Font("Arial", Font.BOLD, 24));
        
        drawKey(g, 180, 140, "↑");
        drawKey(g, 95, 225, "←");
        drawKey(g, 180, 225, "↓");
        drawKey(g, 265, 225, "→");

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));

        g.drawString("ROTATE", 180, 130);

        g.drawString("MOVE", 102 , 325);
        g.drawString("LEFT",106,350);

        g.drawString("SPEED", 185, 325);
        g.drawString("UP", 205, 350);

        g.drawString("MOVE", 272 , 325);
        g.drawString("RIGHT",270,350);

        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString("Press ENTER to start", 145, 525);
        g.drawString("Press SPACE to pause in game", 115, 550);

        //show option to choose game mode
        g.setColor(Board.USE_IMAGE_MODE ? Color.WHITE : Color.GREEN);
        g.drawString("Press 1: Classic Mode " + (Board.USE_IMAGE_MODE ? "" : "[X]"), 100, 420);
        g.setColor(Board.USE_IMAGE_MODE ? Color.GREEN : Color.WHITE);
        g.drawString("Press 2: Image Mode " + (Board.USE_IMAGE_MODE ? "[X]" : ""), 100, 450);
    }
    private void drawKey(Graphics g, int x, int y, String arrow) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = 70;

        // shadow
        g2.setColor(new Color(80, 80, 80));
        g2.fillRoundRect(x + 4, y + 4, size, size, 8, 8);

        // key body
        g2.setColor(new Color(210, 210, 210));
        g2.fillRoundRect(x, y, size, size, 8, 8);

        // key border
        g2.setColor(Color.WHITE);
        g2.drawRoundRect(x, y, size, size, 8, 8);

        // arrow
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 42));

        int arrowWidth = g2.getFontMetrics().stringWidth(arrow);
        int arrowHeight = g2.getFontMetrics().getAscent();

        int arrowX = x + (size - arrowWidth) / 2;
        int arrowY = y + (size + arrowHeight) / 2 - 8;

        g2.drawString(arrow, arrowX, arrowY);
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
