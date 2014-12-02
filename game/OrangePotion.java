import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OrangePotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrangePotion extends ItemPanel
{
    /**
     * Act - do whatever the OrangePotion wants to do. This method is called whenever
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
        if(Greenfoot.mouseClicked(this) && CurrencyCounter.currencyCollected > 100)
        {
            PurchaseWindow.pwVisible = true;
        }
    }
}
