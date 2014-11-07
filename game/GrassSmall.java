import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GrassSmall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrassSmall extends Ground
{
    /**
     * Act - do whatever the GrassSmall wants to do. This method is called whenever
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
     * Destroy grass after it moves off the screen
     * @ChandlerWarne
     */
    private void destroy()
    {
        if(getX() < -100)
        {
            GameWorld w = (GameWorld)getWorld();
            w.removeObject(this);
        }
    }    
}
