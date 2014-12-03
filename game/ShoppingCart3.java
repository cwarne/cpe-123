import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShoppingCart3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShoppingCart3 extends PurplePotion
{
    /**
     * Act - do whatever the ShoppingCart3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setVisibility();
        checkPurchase();
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
    public void checkPurchase()
    {
        if(CurrencyCounter.currencyCollected <= 350)
        {
            if(Greenfoot.mouseClicked(this))
            {
                NotEnoughMoney.fade = 200;
            }   
        }
    }
}
