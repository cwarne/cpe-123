import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cloud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cloud extends Sky
{
    private int speed;
    public Cloud() //sets random cloud picture when created
    {
        int random = Greenfoot.getRandomNumber(4);
        speed = Greenfoot.getRandomNumber(3)+3;
        if(random == 0)
        {
            setImage("CloudOne.png");
        }
        else if(random == 1)
        {
            setImage("CloudTwo.png");
        }
        else if(random == 2)
        {
            setImage("CloudThree.png");
        }
        else //random == 3
        {
            setImage("CloudFour.png");
        }
        
    }
    /**
     * Act - do whatever the Cloud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(GameWorld.gamePaused == false)
        {
            moveCloud(); //moves clouds across screen
        }
    }   
    
    private void moveCloud()
    {
        GameWorld gw = (GameWorld) getWorld();
        if(gw.getCount() % speed == 0) //For every 4 movements
        {
            move(-1);
        }
    }
}
