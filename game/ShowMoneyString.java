import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShowMoneyString here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShowMoneyString extends GameStore
{
    /**
     * Act - do whatever the ShowMoneyString wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setVisibility();
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
            GreenfootImage text = new GreenfootImage(100,30);
            text.drawString("Money: " + CurrencyCounter.currencyCollected, 2, 20);
            setImage(text);
        }
    }
}
