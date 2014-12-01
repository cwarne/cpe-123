import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NoOption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NoOption extends PurchaseWindow
{
    /**
     * Act - do whatever the NoOption wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /** Menu Code ~ Michael Tornatta **/
    
    GreenfootImage isSelected = new GreenfootImage("NoSelected.png");
    GreenfootImage notSelected = new GreenfootImage("NoNotSelected.png");
    
    //Keeps track of whether this is selected or not
    public static boolean noSelected = false;
    
    public void act() 
    {
        isVisible();
        isSelected();
        mousedOver();
        clicked();
    }    
    public void isSelected()
    {
        if(noSelected == true)
        {
            setImage(isSelected);
        }
        if(noSelected == false)
        {
            setImage(notSelected);
        }
    }
    public void mousedOver()
    {
        if(Greenfoot.mouseMoved(this))
        {
            YesOption.yesSelected = false;
            noSelected = true;
        }
    }
    public void clicked()
    {
        if((noSelected == true) && (Greenfoot.mouseClicked(this)))
        {
            GameWorld.gameAskedToEnd = true;
        }
    }
    public void isVisible()
    {
        if(PurchaseWindow.pwVisible == false)
        {
            getImage().setTransparency(0);
        }
        if(PurchaseWindow.pwVisible == true)
        {
            getImage().setTransparency(255);
        }
    } 
}
