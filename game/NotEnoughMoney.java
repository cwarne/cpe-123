import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NotEnoughMoney here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NotEnoughMoney extends GameStore
{
    /**
     * Act - do whatever the NotEnoughMoney wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /** Menu Code by Michael Tornatta **/
    
    static int fade = 0;
    
    public void act() 
    {
        visible();
        fade();
    } 
    public void visible()
    {
        getImage().setTransparency(fade);
    }
    public void fade()
    {
        if(fade > 0)
        {
            fade = fade - 2;
        }
    }
}
