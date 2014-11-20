import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
            //collide(); //check for collision with professor and go to game over screen
            changeImage();
            //collideLazer();
            super.act();
        }
    }
    
    /**
     * Moves the obstacle across the game screen. If the enemy is on the ground then
     * it will run forward slightly faster than the ground is moving. 
     * @Sarah Stephens
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
