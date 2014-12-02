import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteor extends Obstacles
{
    /**
     * Act - do whatever the meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @NickJones
     */
    public void act() 
    {
        if(GameWorld.gamePaused == false)
        {
            remove();
            movement();
            collide();
            setRotation(130);            
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
        }
    }

}