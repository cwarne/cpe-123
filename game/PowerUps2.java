import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUps2 here.
 * 
 * @ Stephanie Lascola
 * @ Sarah Stephens
 * @ edited by Chandler Warne
 * @version (a version number or a date)
 */
public class PowerUps2 extends PowerUps
{
    static int powerUp2 = 0;
    private boolean key2 = false;
    /**
     * Act - do whatever the PowerUps2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        usePotion2();
        updateImage();
        visibility();
    } 
   
    public void usePotion2()
    {
        Professor professor;
        GameWorld world = (GameWorld) getWorld();
        professor = world.getProfessor();
        if (Greenfoot.isKeyDown("2"))
        {
            key2 = true;
        }
        
        if ((Greenfoot.isKeyDown("2") ==false) && powerUp2 > 0 && key2)
        {
            professor.activateShield();
            powerUp2--;
            
            updateImage();
         
            key2 = false;
        }        
    }   
    
    /*
     * Takes potion update from game store
     * @Chandler Warne
     */
    public void updateAmount(int x)
    {
        powerUp2 = x;
        updateImage();
    }
    
    /**
     * Updates image on screen to reflect how much powerup is available.
     * @Chandler Warne
     */
    private void updateImage()
    {
        if(powerUp2 == 0)
            {
                 setImage("vialEmpty_small.png");
            }
            else if(powerUp2 == 1)
            {
                 setImage("vialGreen1_small.png");
            }
            else if(powerUp2 == 2)
            {
                 setImage("vialGreen2_small.png");
            }
            else
            {
                setImage("vialGreen3_small.png");
            }
    }
    //Visibility Michael Tornatta
    public void visibility()
    {
        if(powerUp2 == 0)
        {
            getImage().setTransparency(0);
        }
    }
}
