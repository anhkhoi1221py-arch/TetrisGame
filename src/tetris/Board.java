package tetris;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Board extends JPanel {
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 20;
    private static final int BLOCK_SIZE = 30;
    private Timer looper;
    private Color[][] board = new Color[BOARD_HEIGHT][BOARD_WIDTH];

    private Color[][] shape = {
        {Color.RED, Color.RED, Color.RED},
        {null , Color.RED, null}
    };

    public Board(){
        looper = new Timer(500, new ActionListener() {
            int n = 0;
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(n++);

            }
            
        }); 
        looper.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor ( Color.BLACK );
        g.fillRect (0, 0, getWidth(), getHeight()); 

        // Draw the shape
        for (int row=0; row<shape.length; row++){
            for (int col=0; col<shape[0].length; col++){
                if (shape[row][col] != null){
                    g.setColor(shape[row][col]);
                    g.fillRect(col*BLOCK_SIZE, row*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
        // Draw the board  
 
        g.setColor(Color.WHITE);
        for(int row = 0; row < BOARD_HEIGHT; row++){
            g.drawLine(0,row * BLOCK_SIZE,BLOCK_SIZE * BOARD_WIDTH,row * BLOCK_SIZE);
        }
        for(int col = 0; col < BOARD_WIDTH+1; col++){
            g.drawLine(col * BLOCK_SIZE, 0, col * BLOCK_SIZE, BLOCK_SIZE * BOARD_HEIGHT);
        }
    }
}