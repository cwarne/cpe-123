import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Currency2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Currency2 extends Currency
{
    /**
     * Act - do whatever the Currency2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        disappear();
    }    
     /**
     * This will move the currency across the screen for pickup. As of right now, there are placeholders being used 
     * but eventually it will be things like horns and scales that can be collected and put in the store.
     * -Stephanie Lascola
     */
    public void move()
    {
        setLocation(getX() - 5, getY());
    }
    /**
     * This allows the object to disappear once it is out of the frame on the screen. 
     * -Stephanie Lascola
     */
    public void disappear()
    {
        if (getX() == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
