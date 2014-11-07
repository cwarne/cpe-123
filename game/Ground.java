import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    private int lightGroundCounter; //Counts every act to know when to spawn next light ground @ChandlerWarne
    private int darkGroundCounter; //Counts every act to know when to spawn next dark ground @ChandlerWarne
    private int spawnHeight; //Stores value at which the grass will be spawned at @ChandlerWarne
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        lightGroundCounter++;
        darkGroundCounter++;
        spawnLightGround();
        spawnGrass();
    }  
    
    /**
     * Will Spawn light ground randomly
     * @ChandlerWarne
     */
    public void spawnLightGround()
    {
        if(lightGroundCounter >= (Greenfoot.getRandomNumber(70)+20)) //check counter to see if appropriate time to spawn ground
        {
            lightGroundCounter = 0; //reset counter
            
            spawnHeight = Greenfoot.getRandomNumber(10)+575; //get random height between 580-595
            
            if(Greenfoot.getRandomNumber(2) == 0) //Spawn LightGroundOne
            {
                LightGroundOne lightground = new LightGroundOne();
                getWorld().addObject(lightground, 1200, spawnHeight); //spawn of screen at slightly varying height
            }
            else //Spawn LightGroundTwo
            {
                LightGroundTwo lightgroundtwo = new LightGroundTwo();
                getWorld().addObject(lightgroundtwo, 1200, spawnHeight); //spawn of screen at slightly varying height
            }
        }
    }
    
    /**
     * Randomly spawn grass blades
     * @ChandlerWarne
     */
    public void spawnGrass()
    {
        spawnHeight = Greenfoot.getRandomNumber(47)+565;
        
        if(Greenfoot.getRandomNumber(100) < 1) //Spawn grass in intervals
        {
            if(Greenfoot.getRandomNumber(3) == 0) //spawn small gras
            {
                GrassSmall gs = new GrassSmall();
                getWorld().addObject(gs, 1200, spawnHeight);
            }
            else //spawn large grass
            {
                GrassLarge gl = new GrassLarge();
                getWorld().addObject(gl, 1200, spawnHeight);
            }
        }
    }
}
