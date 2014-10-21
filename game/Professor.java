import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Professor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Professor extends Characters
{
    // Professor Controls
    //Code contributed by Michael Tornatta
    private boolean isJumping;
    private int vSpeed = 0;
    private int jumpingStrength = 20;
    private int acceleration = 1;
    private int frame = 1;
    private int animationCounter = 0;
    
    private GreenfootImage profframe1 = new GreenfootImage("Professor Pos1.png");
    private GreenfootImage profframe2 = new GreenfootImage("Professor Pos2.png");
    
    /**
     * Act - do whatever the Professor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space")) && isJumping == false)
        {
            jump();
        }
        checkIfFalling();
        animation();
    }    
    public void jump()
    {
        vSpeed = vSpeed - jumpingStrength;
        isJumping = true;
        fall();
    }
    public void checkIfFalling()
    {
        if(onGround())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        if(vSpeed <=9)
        {
            vSpeed = vSpeed + acceleration;
        }
        isJumping = true;
    }
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Platforms.class);
        if(ground == null)
        {
            isJumping = true;
            return false;
        }
        else
        {
            moveToGround(ground);
            return true;
        }
    }
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
        isJumping = false;
    }
    public void animation()
    {
        if(frame == 1)
        {
            setImage(profframe1);
        }
        else if(frame == 2)
        {
            setImage(profframe2);
            frame = 1;
            return;
        }
        frame ++;
    }
}
