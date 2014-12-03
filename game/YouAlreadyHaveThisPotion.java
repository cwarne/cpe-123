import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouAlreadyHaveThisPotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouAlreadyHaveThisPotion extends GameStore
{
    /**
     * Act - do whatever the YouAlreadyHaveThisPotion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /** Menu Code by Michael Tornatta **/
    
    static int yfade = 0;
    
    public void act() 
    {
        visible();
        visibility();
        fade();
    } 
    public void visible()
    {
        getImage().setTransparency(yfade);
    }
    public void fade()
    {
        if(yfade > 0)
        {
            yfade = yfade - 2;
        }
    }
    public void visibility()
    {
        if(BackerGS.storeVisible == false)
        {
            getImage().setTransparency(0);
            yfade = 0;
        }
    }  
}
