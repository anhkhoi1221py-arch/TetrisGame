package tetris;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements KeyListener{
     
    private static int FPS = 60 ;
    private static int delay = 1000 / FPS ;


    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;
    public static final int BLOCK_SIZE = 30;
    private Timer looper;
    private Color[][] board = new Color[BOARD_HEIGHT][BOARD_WIDTH];

    private int[][] shapel = {
        {1,1,1},
        {0,1,0}
    };

    private Shape shape = new Shape(shapel);

   

    public Board(){
        looper = new Timer( delay, new ActionListener() {
            int n = 0;
            @Override
            public void actionPerformed(ActionEvent e){
                update();
                repaint();
            }
            
        }); 
        looper.start();
    }

    private void update (){
        shape.update();
       
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor ( Color.BLACK );
        g.fillRect (0, 0, getWidth(), getHeight()); 

        shape.render(g);

        // Draw the board  
 
        g.setColor(Color.WHITE);
        for(int row = 0; row < BOARD_HEIGHT; row++){
            g.drawLine(0,row * BLOCK_SIZE,BLOCK_SIZE * BOARD_WIDTH,row * BLOCK_SIZE);
        }
        for(int col = 0; col < BOARD_WIDTH+1; col++){
            g.drawLine(col * BLOCK_SIZE, 0, col * BLOCK_SIZE, BLOCK_SIZE * BOARD_HEIGHT);
        }
    }

    @Override
    public void keyTyped( KeyEvent e){
        
    }
    @Override
    public void keyPressed( KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            shape.speedUp();
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            shape.moveLeft();
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            shape.moveRight();
        }
        
    }
    @Override
    public void keyReleased( KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            shape.speedDown();
        }       
    } 
}