import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyC extends Obstacles
{
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
        }
    }    
    /**
     * Mves the enemy acorss the top of the screen and swoops it down.
     * @AlexCarpenter
     */
    public void move()
    {
        if (getY() < 400)
        {
            setLocation(getX() - 7, getY() + (Greenfoot.getRandomNumber(10) - 2));
        }
        else
        {
            setLocation(getX() - 7, getY() + 2);
        }
    }
}
