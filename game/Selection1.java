import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selection1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selection1 extends PauseMenu
{
    /**
     * Act - do whatever the Selection1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /** Menu Code ~ Michael Tornatta **/
        
    GreenfootImage isSelected = new GreenfootImage("GameStoreSelected.png");
    GreenfootImage notSelected = new GreenfootImage("GameStore.png");
    
    //Checks if this is selected or not
    public static boolean sel1Selected = true;
    
    public void act() 
    {
        isVisible();
        isSelected();
        mousedOver();
        clicked();
    }    
    public void isSelected()
    {
        if(sel1Selected == true)
        {
            setImage(isSelected);
        }
        if(sel1Selected == false)
        {
            setImage(notSelected);
        }
    }
    public void mousedOver()
    {
        if(Greenfoot.mouseMoved(this))
        {
            sel1Selected = true;
            Selection2.sel2Selected = false;
        }
    }
    public void clicked()
    {
        if((sel1Selected == true) && (Greenfoot.mouseClicked(this)))
        {
            BackerGS.storeVisible = true;
        }
    }
    public void isVisible()
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
