import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Professor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Professor extends Characters
{
    /** Professor Controls
       ~ Michael Tornatta **/
    
    /** Jumping technical values **/
    //Timer to keep track of how long the professor has been in the air
    private int jumpTimer = 0;
    //Checks if the professor is currently jumping
    private boolean isJumping = false;
    
    /** Adjustable Jumping Mechanics Values **/
    //Sets the amount of time the professor's jump lasts.
    private int jumpTime = 10; //Change this if you want the jump to last longer
    //Adjusts the force at which the professor falls
    private int fallStrength = 10; //Change this if you want the professor to fall faster/slower
    //Adjusts the force at wchich the professor jumps
    private int jumpStrength = 20; //Change this if you want the professor to jump faster/slower
    
    /** Animation variables **/
    private int frame = 1;
    private int animationCounter = 0;
    
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
        //Checks if the jump timer is running or not. Makes sure professor is in the correct state
        if(jumpTimer == 0)
        {
            //Checks if professor is on ground or not and chnages his state accordingly
            if((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space")) && (checkIfOnGround()))
            {
                jump();
            }
            if((!checkIfOnGround()) && (isJumping == false))
            {
                fall();
            }
        }
        else
        {
            jump();
        }
        animation();
        move();
        remove();
    }
    public void jump()
    {
        //Keeps professor in jump state for as long as jumpTimer value
        if(jumpTimer > jumpTime)
        {
            isJumping = false;
            jumpTimer = 0;
            return;
        }
        if(jumpTimer < jumpTime)
        {
            isJumping = true;
            setLocation(getX(), getY() - jumpStrength);
        }
        increaseJumpTimer();
    }
    public void increaseJumpTimer()
    {
        jumpTimer = jumpTimer + 1;
    }
    public boolean checkIfOnGround()
    {
        //Checks if the professor has collided with the top of the platform
        Actor collideWithGround = getOneObjectAtOffset(0, getImage().getHeight()/2, Platforms.class);
        if(collideWithGround != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void fall()
    {
        //Checks if the professor is on the ground or not and adjusts state accordingly.
        if(checkIfOnGround() == false)
        {
            setLocation(getX(), getY() + fallStrength);
        }
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
    /**
     * Allows the professor to move back and forth
     * @Nick Jones
     * Adjusted a bit ~ Michael Tornatta
     */
    public void move()
    {
        if (Greenfoot.isKeyDown("right") && getX() < 700)
        {
            move(4);
        }
        if (Greenfoot.isKeyDown("left") && getX() > 40)
        {
            move(-10);
        }
    }

}
