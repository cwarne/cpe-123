import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SolidGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platforms extends Actor
{
    /**
     * Act - do whatever the SolidGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    
    /**
     * Used to move all of the platforms pieces across the screen at the same speed
     * @Sarah Stephens
     */
    public void move()
    {
        if(GameWorld.gamePaused == false)
        {
            move(-5);
        }
    }
}
