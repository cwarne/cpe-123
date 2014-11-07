import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 640, 1); 
    }
    public void act()
    {
        jumpToNextFrame();
    }
    public void jumpToNextFrame()
    {
        if((Greenfoot.mouseClicked(this)) || (Greenfoot.isKeyDown("space")))
        {
            GameWorld gameworld = new GameWorld();
            Greenfoot.setWorld(gameworld);
        }
    }
}
