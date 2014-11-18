import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackerGS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackerGS extends GameStore
{
    /**
     * Act - do whatever the BackerGS wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /** Game Store Code ~ Michael Tornatta **/
    
    public static boolean storeVisible = false;
    
    public void act() 
    {
        visibility();
        if(GameWorld.gamePaused == false)
        {
            storeVisible = false;
        }
    }  
    public void visibility()
    {
        if(storeVisible == false)
        {
            getImage().setTransparency(0);
        }
        if(storeVisible == true)
        {
            getImage().setTransparency(255);
        }
    }
}
