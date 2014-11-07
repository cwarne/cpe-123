import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SolidGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platforms extends Actor
{
    private int speed = -5;
    /**
     * Act - do whatever the SolidGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //
    }    
    /**
     * This moves all of the platforms across the screen at a given rate. This is called in all 
     * platforms act methods.
     * Sarah Stephens 
     */
    public void move() 
    {
        move(speed);
    }
}
