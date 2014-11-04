import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Placeholder for an obstacle in the game, most likely a stump.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyA extends Obstacles
{
    private int currentImage = 1;
    /**
     * Act - do whatever the EnemyA wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(GameWorld.gamePaused == false)
        {
            move();
            collide(); //check for collision with professor and go to game over screen
            changeImage();
        }
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
     * edited by @NickJones
     */
    public void collide()
    {
        Actor professor;
        professor = getOneIntersectingObject(Professor.class);
        if (professor != null)
        {
            GameWorld world = (GameWorld) getWorld();
            world.endGame();
        }
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
                setImage("Dino1.png");
                currentImage = 1;
            } 
            else if(currentImage == 1)
            {
                setImage("Dino2.png");
                currentImage = 2;
            }
            else
            {
                setImage("Dino3.png");
                currentImage = 3;
            }
        }
    }
}
