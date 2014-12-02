import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenPotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenPotion extends ItemPanel
{
    /**
     * Act - do whatever the GreenPotion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setVisibility();
        checkIfClicked();
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
    public void checkIfClicked()
    {
        if(Greenfoot.mouseClicked(this) && CurrencyCounter.currencyCollected > 150)
        {
            PurchaseWindow.pwVisible = true;
        }
    }
}
