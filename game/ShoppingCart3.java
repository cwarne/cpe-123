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
        /** Menu Code By Michael Tornatta **/
    public  GreenfootSound chaChing = new GreenfootSound("Cash register sound effect.wav");
    public  GreenfootSound boop = new GreenfootSound("Boop.wav");
    
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
        if(BackerGS.storeVisible)
        {
            if(CurrencyCounter.currencyCollected < 350)
            {
                if(Greenfoot.mouseClicked(this))
                {
                    NotEnoughMoney.fade = 200;
                    boop.play();
                }   
            }
        }
        if(CurrencyCounter.currencyCollected >= 350)
        {
            if(PowerUps1.powerUp1 != 0)
            {
                if(Greenfoot.mouseClicked(this))
                {
                    YouAlreadyHaveThisPotion.yfade = 200;
                    boop.play();
                }
            }
            if(PowerUps1.powerUp1 == 0)
            {
                if(Greenfoot.mouseClicked(this))
                {
                    chaChing.play();
                    CurrencyCounter.currencyCollected = CurrencyCounter.currencyCollected - 350;
                    PowerUps1.powerUp1 = 3;
                }
            }
        }
    }
}
