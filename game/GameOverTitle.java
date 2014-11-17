import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverTitle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverTitle extends Actor
{
    /**
     * Act - do whatever the GameOverTitle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       moveDown(); // Add your action code here.
    }    
    public void moveDown()
    {
        setLocation (getX(), getY() + 3);
    }
}
