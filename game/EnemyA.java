import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Placeholder for an obstacle in the game, most likely a stump.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyA extends Obstacles
{
    /**
     * Act - do whatever the EnemyA wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        collide(); //check for collision with professor and go to game over screen
    }
    /**
     * Moves the obstacle across the game screen. If the enemy is on the ground then
     * it will run forward slightly faster than the ground is moving. It would be great
     * if it had an animation but it doesn't 
     * @SarahStephens
     */
    public void move()
    {
        if (getY() > 500) 
        {
            setLocation(getX() - 6, getY());
        }
        else 
        {
            setLocation(getX() - 5, getY());
        }
    }
    
    /**
     * check for collision with the professor and set to game over screen 
     * same code in enemyB
     * @SarahStephens
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
