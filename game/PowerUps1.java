import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUps1 here.
 * 
 * @Stephanie Lascola
 * @version (a version number or a date)
 */
public class PowerUps1 extends PowerUps
{
    static int powerUp1 = 0;
    private boolean key1 = false;
    /**
     * Act - do whatever the PowerUps1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        usePotion1();
        visibility();
    }    
    /**
     * This is made so when the key is pressed it stops running after released. This way all the potions aren't 
     * used up at once. When potion 1 is used, all obstacles disappear off screen.
     */
     public void usePotion1()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            key1 = true;
        }
        
        if((Greenfoot.isKeyDown("1") == false)&& powerUp1 > 0 && key1) //Chandler Warne
        {
            World world;
            world = getWorld();
            getWorld().removeObjects(getWorld().getObjects(Obstacles.class));
            powerUp1--;
            
            updateImage();
            
            key1 = false;
        }
        
    }
    
    /*
     * Takes potion update from game store
     * @Chandler Warne
     */
    public void updateAmount(int x)
    {
        powerUp1 = x;
        updateImage();
    }
    
    /**
     * Updates image on screen to reflect how much powerup is available.
     * @Chandler Warne
     */
    private void updateImage()
    {
        if(powerUp1 == 0)
            {
                 setImage("vialEmpty_small.png");
            }
            else if(powerUp1 == 1)
            {
                 setImage("vialPurple1_small.png");
            }
            else if(powerUp1 == 2)
            {
                 setImage("vialPurple2_small.png");
            }
            else
            {
                setImage("vialPurple3_small.png");
            }
    }
    //Visibility Michael Tornatta
    public void visibility()
    {
        if(powerUp1 == 0)
        {
            getImage().setTransparency(0);
        }
    }
}
