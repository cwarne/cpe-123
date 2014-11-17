import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{

    /**
     * Constructor for objects of class GameOverScreen.
     * @Nick Jones
     */
    
    /** Little timer that keeps the player for immediately leaving the game over screen upon entering
     * ~ Michael Tornatta
     */
    //Changed Game Over Screen @Stephanie Lascola
    public int coolDownTimer = 1;
    public int coolDownLimit = 50;
    
    public GameOverScreen(int score)
    {    
  
        super(800, 640, 1);
        prepare();
        showText("final score   "+score, 90, 30);
        
    }
    /**
     * resets the game if the mouse is clicked on the game over screen
     * @SarahStephens
     * edited by @Nick Jones
     */
    public void act()
    {
        if(coolDownTimer == 0)
        {
            if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("space"))
            {
                GameWorld g = new GameWorld();
                Greenfoot.setWorld(g);
                CurrencyCounter.currencyCollected = 0;
            }
        }
        if((coolDownTimer < coolDownLimit) && (coolDownTimer >0))
        {
            coolDownTimer++;
        }
        if(coolDownTimer >= coolDownLimit)
        {
            coolDownTimer = 0;
        }
        /** Resets end game request and game paused flags ~ Michael Tornatta **/
        GameWorld.gameAskedToEnd = false;
        GameWorld.gamePaused = false;
    }
    private void prepare()
    {
        GameOverTitle gameovertitle = new GameOverTitle();
        addObject(gameovertitle, 400, 0);
    }
   
 
    
            
}
