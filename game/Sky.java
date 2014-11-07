import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sky extends Actor
{
    /**
     * Act - do whatever the Sky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       spawnClouds();
    }    
    
    /**
     * Randomly place clouds in the sky
     */
    public void spawnClouds()
    {
        if(Greenfoot.getRandomNumber(900) < 2)
        {
            Cloud cloud = new Cloud();
            getWorld().addObject(cloud, 1200, Greenfoot.getRandomNumber(140)+20);
        }
    }
}
