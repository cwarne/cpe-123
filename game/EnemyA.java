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
     * Moves the obstacle across the game screen. It would most likely 
     * be beneficial to use a variable such as gameSpeed instead of saying current
     * location minus 5 in case we want to be able to change the speed at which the
     * ground and obstacles move. This would make it easy for the game to progessively
     * become harder as the score increases. This variable would also be used in the 
     * movement of the ground and grass to keep everything moving at the right speed.
     * @SarahStephens
     */
    public void move()
    {
        setLocation(getX() - 5, getY());
    }
    
   
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
