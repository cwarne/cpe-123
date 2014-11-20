import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUps1 here.
 * 
 * @Stephanie Lascola
 * @Chandler Warne
 * @version (a version number or a date)
 */
public class PowerUps3 extends PowerUps
{
    private int powerUp3 = 5;
    private boolean key3 = false;
    /**
     * Act - do whatever the PowerUps1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        usePotion3();
        cheat();
    }    
    public void cheat()
    {
        if(Greenfoot.isKeyDown("i"))
        {
            powerUp3 = powerUp3 + 1;
        }
    }
    /**
     * This is made so when the key is pressed it stops running after released. This way all the potions aren't 
     * used up at once. When potion 1 is used, all obstacles disappear off screen.
     */
     public void usePotion3()
    {
        if(Greenfoot.isKeyDown("3"))
        {
            key3 = true;
        }
        
        if((Greenfoot.isKeyDown("3") == false)&& powerUp3 > 0 && key3) //Chandler Warne
        {
            powerUp3--;
            
            updateImage();
            
            key3 = false;
        }
    }

    /*
     * Takes potion update from game store
     * @Chandler Warne
     */
    public void updateAmount(int x)
    {
        powerUp3 = x;
        updateImage();
    }
    
    /**
     * Updates image on screen to reflect how much powerup is available.
     * @Chandler Warne
     */
    private void updateImage()
    {
        if(powerUp3 == 0)
            {
                 setImage("vialEmpty_small.png");
            }
            else if(powerUp3 == 1)
            {
                 setImage("vialOrange1_small.png");
            }
            else if(powerUp3 == 2)
            {
                 setImage("vialOrange2_small.png");
            }
            else
            {
                setImage("vialOrange3_small.png");
            }
    }
    public int getP3Amount()
    {
        return powerUp3;
    }
    public void usePowerup()
    {
        powerUp3 = powerUp3 - 1;
    }
}
