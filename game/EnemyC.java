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
        move();
        collide();
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
    
    /**
     * checks for collision with player and changes to game over screen
     * @AlexCarpenter
     */
    public void collide()
    {
        Actor professor;
        professor = getOneIntersectingObject(Professor.class);
        if (professor != null)
        {
            GameOverScreen go = new GameOverScreen();
            Greenfoot.setWorld(go);
        }
    }
}
