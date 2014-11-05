import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUps2 here.
 * 
 * @ Stephanie Lascola
 * @ Sarah Stephens
 * @version (a version number or a date)
 */
public class PowerUps2 extends PowerUps
{
    private int powerUp2 = 1;
    private boolean key2 = false;
    /**
     * Act - do whatever the PowerUps2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        usePotion2();
    } 
    public void usePotion2()
    {
        Professor professor;
        GameWorld world = (GameWorld) getWorld();
        professor = world.getProfessor();
        
        if(Greenfoot.isKeyDown("2"))
        {
            key2 = true;
            professor.activateShield();
        }
        
    }
   
        
        
}
