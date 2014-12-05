import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

  /**
  * Write a description of class Instructions here.
  * 
  * @author (your name) 
  * @version (a version number or a date)
   */
  
public class Instructions extends World
{
    /**
     * Constructor for objects of class Instructions.
     * timer for instructions
     * @Nick Jones
     */
     public int coolDownTimer = 1;
     public int coolDownLimit = 40;
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 640, 1); 
    }
    public void act()
    {
        enterGameWorld();
    }
    /**
     * Change screen to Game mode
     * @StephanieLascola
     * @NickJones
     */
    public void enterGameWorld()
    {
        if(coolDownTimer == 0)
        {
            if((Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("space")))
            {
                GameWorld gameworld = new GameWorld();
                Greenfoot.setWorld(gameworld);
            }
        
    }
    if((coolDownTimer < coolDownLimit) && (coolDownTimer >0))
    {
        coolDownTimer++;
    }
    if( coolDownLimit <= coolDownTimer)
    {
        coolDownTimer = 0;
    }
    }
}
