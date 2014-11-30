import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reference here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reference extends Actor
{
    public boolean isPlatform = false;
    /**
     * Act - do whatever the Reference wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        intersect();
    }    
    
    /**
     * Checks if a platform is currently at the edge of the world
     * @Sarah Stephens
     */
    public void intersect() 
    {
        Actor p;
        p = getOneIntersectingObject(Platforms.class);
        if (p != null)
        {
            isPlatform = true;
        }
        else
        {
            isPlatform = false;
        }
    }
    /**
     * returns if there is a platform currently at the edge of the world
     * is used for spawning enemies in the game world
     * @Sarah Stephens
     */
    public boolean isPlatform() 
    {
        return isPlatform;
    }
}
