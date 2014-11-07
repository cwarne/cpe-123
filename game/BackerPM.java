import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackerPM here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackerPM extends PauseMenu
{
    /**
     * Act - do whatever the BackerPM wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /** Menu Code ~ Michael Tornatta **/
    
    //Public flag that keeps track of whether this is visible or not
    public static boolean backerPMVisible = false;
    
    private int selectionCoolDown = 0;
    private int coolDownPeriod = 10;
    
    public void act() 
    {
        visibilityOptions();
        changeSelection();
        makeChoice();
    }    
    public void visibilityOptions()
    {
        if(BackerGS.storeVisible == false)
        {
            setVisibility();
        }
        if(BackerGS.storeVisible == true)
        {
            getImage().setTransparency(0);
            Selection1.sel1Selected = true;
            Selection2.sel2Selected = false;
            backerPMVisible = false;
        }
    }
    public void changeSelection()
    {
        if(backerPMVisible)
        {
            if((Greenfoot.isKeyDown("up")) && (selectionCoolDown == 0))
            {
                Selection1.sel1Selected = !Selection1.sel1Selected;
                Selection2.sel2Selected = !Selection2.sel2Selected;
                coolDownPeriod();
            }
            if((Greenfoot.isKeyDown("down")) && (selectionCoolDown == 0))
            {
                Selection1.sel1Selected = !Selection1.sel1Selected;
                Selection2.sel2Selected = !Selection2.sel2Selected;
                coolDownPeriod();
            }
            if(selectionCoolDown > 0)
            {
                coolDownPeriod();
            }
        }
    }
    public void coolDownPeriod()
    {
        if(selectionCoolDown < coolDownPeriod)
        {
            selectionCoolDown++;
        }
        if(selectionCoolDown >= coolDownPeriod)
        {
            selectionCoolDown = 0;
        }
    }
    public void setVisibility()
    {
        //Checks if the game is paused or not and becomes visible/invisible based on that
        if(GameWorld.gamePaused == false)
        {
            getImage().setTransparency(0);
            Selection1.sel1Selected = true;
            Selection2.sel2Selected = false;
            backerPMVisible = false;
        }
        if(GameWorld.gamePaused == true)
        {
            getImage().setTransparency(255);
            backerPMVisible = true;
        }
    }
    public void makeChoice()
    {
        if((Selection1.sel1Selected == true) && (Greenfoot.isKeyDown("enter")))
        {
            BackerGS.storeVisible = true;
        }
        if((Selection2.sel2Selected == true) && (Greenfoot.isKeyDown("enter")))
        {
            GameWorld.gameAskedToEnd = true;
        }
    }
}
