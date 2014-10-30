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
    private int jumpingStrength = 35;
    private int acceleration = 3;
    private int frame = 1;
    private int animationCounter = 0;
    private int jumpTimer = 0;
    //Picture changed 
    //Stephanie Lascola
    private GreenfootImage profframe1 = new GreenfootImage("Professor.png");
    private GreenfootImage profframe2 = new GreenfootImage("Professor2.png");
    
    /**
     * Act - do whatever the Professor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space")) && isJumping == false && jumpTimer == 0)
        {
            jump();
        }
        checkIfFalling();
        animation();
        remove();
        changeJumpTimer();
    }    
    public void jump()
    {
        vSpeed = vSpeed - jumpingStrength;
        isJumping = true;
        fall();
        jumpTimer = 28;
    }
    /**
     * counts down the jump timer to prevent double jumps. Can only jump if timer is at zero
     * @SarahStephens
     */
    public void changeJumpTimer()
    {
        if (jumpTimer > 0)
        {
            jumpTimer = jumpTimer - 1;
        }
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
        //Changed so that last frame change when frame > 2. Fixed a glitch where the frame
        //would not progress to the next one (Michael Tornatta)
        else if(frame > 2)
        {
            setImage(profframe2);
            frame = 1;
            return;
        }
        frame ++;
    }
     /**
     * This is being used so when the professor touches the currency, he collects it.
     * In other words, it is being removed from the screen as if he is actually collecting it.
     * -Stephanie Lascola
     */
    public void remove()
    {
        Actor Currency;
        Currency = getOneObjectAtOffset (0, 0, Currency.class);
        if (Currency!=null)
        {
            World world;
            world = getWorld();
            world.removeObject(Currency);
      
        }  
    }

}
