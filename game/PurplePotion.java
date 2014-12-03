import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PurplePotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PurplePotion extends ItemPanel
{
    /**
     * Act - do whatever the PurplePotion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        /** Menu Code By Michael Tornatta **/
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
