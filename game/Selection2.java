import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selection2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selection2 extends PauseMenu
{
    /**
     * Act - do whatever the Selection2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /** Menu Code ~ Michael Tornatta **/
    
    GreenfootImage isSelected = new GreenfootImage("QuitGameSelected.png");
    GreenfootImage notSelected = new GreenfootImage("QuitGame.png");
    
    //Keeps track of whether this is selected or not
    public static boolean sel2Selected = false;
    
    public void act() 
    {
        isVisible();
        isSelected();
        mousedOver();
        clicked();
    }    
    public void isSelected()
    {
        if(sel2Selected == true)
        {
            setImage(isSelected);
        }
        if(sel2Selected == false)
        {
            setImage(notSelected);
        }
    }
    public void mousedOver()
    {
        if(Greenfoot.mouseMoved(this))
        {
            Selection1.sel1Selected = false;
            sel2Selected = true;
        }
    }
    public void clicked()
    {
        if((sel2Selected == true) && (Greenfoot.mouseClicked(this)))
        {
            GameWorld.gameAskedToEnd = true;
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
