import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUps1 here.
 * 
 * @Stephanie Lascola
 * @version (a version number or a date)
 */
public class PowerUps1 extends PowerUps
{
    private int powerUp1 = 1;
    private boolean key1 = false;
    /**
     * Act - do whatever the PowerUps1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        usePotion1();
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
            key1 = false;
        }
}
}
