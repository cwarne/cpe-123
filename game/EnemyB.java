import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyB extends Obstacles
{
    int currentImage = 3;
    /**
     * Act - do whatever the EnemyB wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(GameWorld.gamePaused == false)
        {
            move();
            changeImage();
            super.act();
        }
    }    
    /**
     * Moves the obstacle across the game screen. 
     * @Sarah Stephens
     */
    public void move()
    {
        setLocation(getX() - 5, getY());
    }
    /**
     * animates the dinosour
     * @Chandler Warne
     */
    public void changeImage()
    {
        GameWorld world = (GameWorld) getWorld();
        if(world.getCount() % 6 == 0)
        {
            if(currentImage == 3)
            {
                setImage("dino2a.png");
                currentImage = 1;
            } 
            else if(currentImage == 1)
            {
                setImage("dino2b.png");
                currentImage = 2;
            }
            else
            {
                setImage("dino2c.png");
                currentImage = 3;
            }
        }
    }
   
}
