import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacles extends Actor
{
    private boolean isShieldUp = false;
    private boolean ifStillAlive = true;
    /**
     * Act - do whatever the Obstacles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        collide();
        if( ifStillAlive) collideLazer();
    }
       /**
     * check for collision with the professor and set to game over screen 
     * same code in enemyB
     * @Sarah Stephens
     * edited by @NickJones
     *@Stephanie Lascola 
     *
     */
    public void collide()
    {
        Professor professor;
        professor = (Professor) getOneIntersectingObject(Professor.class);
        GameWorld world = (GameWorld) getWorld();
        getShieldStatus();
        if (professor != null)
        {
            if (isShieldUp == true)
            {
                professor.deactivateShield();
                getWorld().removeObject(this);
                ifStillAlive = false;
            }
            else if (isShieldUp == false)
            {
               //world.endGame();
            }
        }
       
    }
    /**
     * @Sarah Stephens
     * @Stephanie Lascola
     */
    public void getShieldStatus()
    {
        Professor professor;
        GameWorld world = (GameWorld) getWorld();
        professor = world.getProfessor();
        isShieldUp = professor.getShieldStatus();
    }
    /**
     * @Sarah Stephens
     * @Stephanie Lascola
     */
    public void collideLazer()
    {
        Actor lazer = getOneIntersectingObject(Lazer.class);
        if (lazer !=null) 
        {
            getWorld().removeObject(lazer);
            getWorld().removeObject(this);
        }
    }
}
