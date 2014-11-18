import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ItemPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemPanel extends GameStore
{
    /**
     * Act - do whatever the ItemPanel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /** Game Store Code ~ Michael Tornatta **/
    
    public void act() 
    {
        setVisibility();
    }    
    public void setVisibility()
    {
        if(BackerGS.storeVisible == false)
        {
            getImage().setTransparency(0);
        }
        if(BackerGS.storeVisible == true)
        {
            getImage().setTransparency(255);
        }
    }
}
