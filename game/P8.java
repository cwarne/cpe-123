import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class P8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P8 extends Platforms
{
    /**
     * Act - do whatever the P8 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(GameWorld.gamePaused == false)
        {
            move(-5);
        }
    }    
}
