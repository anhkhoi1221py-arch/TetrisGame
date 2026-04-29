package tetris;
import static tetris.Board.BOARD_HEIGHT;
import static tetris.Board.BLOCK_SIZE;
import java.awt.Graphics;
import java.awt.Color;

public class Shape {
     private int x = 4 , y = 0 ;
    private int normal = 600;
    private int fast = 50;
    private int delayTimeForMovement = normal ; 
    private long beginTime;

    private int deltaX =0;
    private boolean collision = false;

    private int[][] coords;

    public Shape(int[][] coords, Board board, Color color){
        this.coords = coords;
    }

    public void update(){
         if (collision){
                    return;
                }
                    
                // check moving horizontal
                if (!(x + deltaX + coords[0].length > 10) && !(x + deltaX < 0)) {
                    x += deltaX;
                }
                deltaX = 0;

                if (System.currentTimeMillis() - beginTime > delayTimeForMovement){
                    if(!(y +1 + coords.length > BOARD_HEIGHT)){
                        y++;
                    }else{
                        collision = true;
                    }
                    beginTime = System.currentTimeMillis();
                }
    }
    public void render(Graphics g){
        for (int row=0; row<coords.length; row++){
            for (int col=0; col<coords[0].length; col++){
                if (coords[row][col] != 0){
                    g.setColor(Color.RED); // Replace with actual color if needed
                    g.fillRect(col*BLOCK_SIZE + x*BLOCK_SIZE, row*BLOCK_SIZE + y*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }

    public void speedUp(){
        delayTimeForMovement = fast;
    } 
    public void speedDown(){
        delayTimeForMovement = normal;
    }
    public void moveLeft(){
        deltaX = -1;
    }
    public void moveRight(){
        deltaX = 1;
    }
}