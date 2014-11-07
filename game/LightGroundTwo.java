import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightGroundTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightGroundTwo extends Ground
{
    /**
     * Act - do whatever the LightGroundTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public void act() 
    {
        if(GameWorld.gamePaused == false)
        {
            move(-5);
            destroy();
        }
    }    
    
    /**
     * Destroy ground after it moves off the screen
     * @ChandlerWarne
     */
    private void destroy()
    {
        if(getX() < -150)
        {
            GameWorld w = (GameWorld)getWorld();
            w.removeObject(this);
        }
    }  
}
