import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{

    /**
     * Constructor for objects of class GameOverScreen.
     * @Nick Jones
     */
    public GameOverScreen(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        showText("final score   "+score, 90, 30);
    }
    /**
     * resets the game if the mouse is clicked on the game over screen
     * @SarahStephens
     * edited by @Nick Jones
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("space"))
        {
            GameWorld g = new GameWorld();
            Greenfoot.setWorld(g);
        }
    }
}
