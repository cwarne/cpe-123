import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    private GreenfootImage board;
    private GreenfootImage sb;
    private int score = 0;
    private String label = "Score: ";
    
     public ScoreBoard()
    {
        super();
        
        int boardWidth = 150;
        int boardHeight = 30;
        int boardTransparency = 125;
        
        // translucent background
        board = new GreenfootImage(boardWidth, boardHeight);
        board.setColor(Color.gray);
        board.setTransparency(boardTransparency);
        board.fillRect(0, 0, boardWidth, boardHeight);
        this.setImage(board);
        
        // Draw scoreboard
        update();
    }
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public int getScore()
    {
        return score;
    }
    public void addScore(int pts)
    {
        if(GameWorld.gamePaused == false)
        {
            score += pts;
            update();
        }
    }
    
    private void update()
    {
        sb = new GreenfootImage(board);
        sb.drawImage(new GreenfootImage(label + score, 18, Color.WHITE, new Color(0,0,0,0)),25,5);
        this.setImage(sb);
    }
}
