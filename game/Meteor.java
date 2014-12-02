import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteor extends Obstacles
{
    private boolean go = true;
    /**
     * Act - do whatever the meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @NickJones
     */
    public void act() 
    {
        if(GameWorld.gamePaused == false)
        {                
            setRotation(130);  
            movement();
            remove();
            if (go == true)
            {
                super.act();
            }                      
        }        
    }    

    public void movement()
    {
        setLocation(getX() - 7, getY() + 8);             
    }

    public void remove()
    {
        if( getY() > 560)
        {
            getWorld().removeObject(this);
            go = false;
        }
    }

}