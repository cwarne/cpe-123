import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PurchaseWindow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PurchaseWindow extends ItemPanel
{
    /**
     * Act - do whatever the PurchaseWindow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static boolean pwVisible = false;
    
    public void act() 
    {
        makeVisible();
    }   
    private void makeVisible()
    {
        if((pwVisible == false) || (BackerGS.storeVisible == false))
        {
            getImage().setTransparency(0);
            pwVisible = false;
        }
        if((pwVisible == true) && (BackerGS.storeVisible == true))
        {
            getImage().setTransparency(255);
        }
    }
}
