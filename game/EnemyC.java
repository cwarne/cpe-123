import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyC extends Obstacles
{
    public boolean ran;
    /**
     * Act - do whatever the EnemyC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(GameWorld.gamePaused == false)
        {
            move();
            collide();
            collideLazer();
            angle();
            despawn();
        }
    }    
    /**
     * Moves the enemy acorss the top of the screen and swoops it down.
     * @AlexCarpenter
     */
    public void move()
    {
        move(9);
        if (getY() <= 40)
        {
            setRotation(160);
        }
        if (getY() >= 200)
        {
            setRotation(200);
        }
    }
    /**
     * Sets the enemies spawn rotation to 160
     */
    public void angle()
    {
        if (ran == false)
        {
            setRotation(160 + Greenfoot.getRandomNumber(40));
            ran = true;
        }
    }
    /**
     * Despawns the object when it gets to the left edge of the screen.
     */
    public void despawn()
    {
        if (getX() <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
