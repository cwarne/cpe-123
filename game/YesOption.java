import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YesOption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YesOption extends PurchaseWindow
{
    /**
     * Act - do whatever the YesOption wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /** Menu Code ~ Michael Tornatta **/
    
    GreenfootImage isSelected = new GreenfootImage("YesSelected.png");
    GreenfootImage notSelected = new GreenfootImage("YesNotSelected.png");
    
    //Keeps track of whether this is selected or not
    public static boolean yesSelected = false;
    
    public void act() 
    {
        isVisible();
        isSelected();
        mousedOver();
        clicked();
    }    
    public void isSelected()
    {
        if(yesSelected == true)
        {
            setImage(isSelected);
        }
        if(yesSelected == false)
        {
            setImage(notSelected);
        }
    }
    public void mousedOver()
    {
        if(Greenfoot.mouseMoved(this))
        {
           NoOption.noSelected = false;
           yesSelected = true;
        }
    }
    public void clicked()
    {
        if((yesSelected == true) && (Greenfoot.mouseClicked(this)))
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
