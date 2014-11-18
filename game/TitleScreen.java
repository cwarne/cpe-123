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

        prepare();
    }

    public void act()
    {
        jumpToNextFrame();
        CurrencyCounter.currencyCollected = 0;
    }

    public void jumpToNextFrame()
    {
        if((Greenfoot.mouseClicked(this)) || (Greenfoot.isKeyDown("space")))
        {
            GameWorld gameworld = new GameWorld();
            Greenfoot.setWorld(gameworld);
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
    }
}
