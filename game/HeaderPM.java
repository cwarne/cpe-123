import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeaderPM here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeaderPM extends PauseMenu
{
    /**
     * Act - do whatever the HeaderPM wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /** Menu Code ~ Michael Tornatta **/
    
    public void act() 
    {
        checkVisibility();
    }    
    public void checkVisibility()
    {
        if(BackerPM.backerPMVisible == false)
        {
            getImage().setTransparency(0);
        }
        if(BackerPM.backerPMVisible == true)
        {
            getImage().setTransparency(255);
        }
    }
}
