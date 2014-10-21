import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private int count = 0; //Holds values for
    private int spawnTimer = 0; //Holds value of time since last obstacle spawned
    public GreenfootSound music;

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 640, 1, false); 

        prepare();
        
        music = new GreenfootSound("ElectroRock.mp3"); //start music
        //music credit: ElectroRock by Deceseased Superior Technician (feel free to change the music)
        music.playLoop();
    }

    public void act()
    {
        count++; //Increase counter for global synchronization
        spawnObstacles();//adds obstacles
        changeTimer();//counts down timer for spawning obstacles
        spawnCurrency();//adds the currency
    }

    /**
     * Returns world synchronization count for actors to refer too.
     */
    public int getCount()
    {
        return count;
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        LightGroundOne lightgroundone = new LightGroundOne();
        addObject(lightgroundone, 126, 583);
        LightGroundTwo lightgroundtwo = new LightGroundTwo();
        addObject(lightgroundtwo, 363, 590);
        lightgroundtwo.setLocation(355, 583);
        LightGroundOne lightgroundone2 = new LightGroundOne();
        addObject(lightgroundone2, 559, 591);
        lightgroundone2.setLocation(559, 584);
        LightGroundTwo lightgroundtwo2 = new LightGroundTwo();
        addObject(lightgroundtwo2, 787, 588);
        lightgroundtwo2.setLocation(738, 584);

        Ground g = new Ground();
        addObject(g, 900, 0);
        g.setLocation(900, 0);

        GrassSmall grasssmall = new GrassSmall();
        addObject(grasssmall, 213, 620);
        GrassLarge grasslarge = new GrassLarge();
        addObject(grasslarge, 672, 566);
        GrassLarge grasslarge2 = new GrassLarge();
        addObject(grasslarge2, 32, 603);
        GrassSmall grasssmall2 = new GrassSmall();
        addObject(grasssmall2, 770, 615);
        GrassLarge grasslarge3 = new GrassLarge();
        addObject(grasslarge3, 415, 597);
        GrassLarge grasslarge4 = new GrassLarge();
        addObject(grasslarge4, 830, 597);
        GrassSmall grasssmall3 = new GrassSmall();
        addObject(grasssmall3, 900, 568);
        GrassSmall grasssmall4 = new GrassSmall();
        addObject(grasssmall4, 1000, 615);

        Sky s = new Sky();
        addObject(s, 900, 0);
        s.setLocation(900, 0);

        Platforms p = new Platforms();
        addObject(p, 0, 590);

        Professor prof = new Professor();
        addObject(prof, 268, 480);

        setPaintOrder(GrassLarge.class, GrassSmall.class, Professor.class, EnemyA.class, EnemyB.class, LightGroundOne.class, LightGroundTwo.class);

        Cloud cloud = new Cloud();
        addObject(cloud, 121, 130);
        Cloud cloud2 = new Cloud();
        addObject(cloud2, 327, 60);
        Cloud cloud3 = new Cloud();
        addObject(cloud3, 592, 190);
        Cloud cloud4 = new Cloud();
        addObject(cloud4, 649, 71);
        removeObject(cloud3);
        Cloud cloud5 = new Cloud();
        addObject(cloud5, 478, 136);
        cloud2.setLocation(684, 176);
        cloud5.setLocation(266, 97);
        cloud2.setLocation(508, 125);
    }
    /**
     * Spawns random obstacles (stump placeholder and static dinosaur placeholders?) 
     * Sets timer to ensure that spawned objects won't overlap
     * @SarahStephens
     */
    public void spawnObstacles()
    {
        if ((Greenfoot.getRandomNumber(2000) < 5) && (spawnTimer == 0))
        {
            EnemyA enemyA = new EnemyA();
            addObject(enemyA, getWidth(), getHeight()-70);
            spawnTimer = 50;
        }        
        else if ((Greenfoot.getRandomNumber(2000) < 3) && (spawnTimer == 0))
        {
            EnemyB enemyB = new EnemyB();
            addObject(enemyB, getWidth(), getHeight()-70);
            spawnTimer = 50;
        }    
    }
        
    /**
     * Counts down the enemy spawn timer one time. Is used to 
     * set a cooldown for the spawn of obstacles so that they 
     * will not overlap on the game screen.
     * @SarahStephens
     */
    public void changeTimer()
    {
        if (spawnTimer > 0)
        {
            spawnTimer = spawnTimer - 1;
        }
    }
     /**
    * Using the timer that Sarah made, the currency appears every ten out of 2000 and the timer is there so the objects do not overlap
    * The elephants appear more than the Hedgehogs. This can be used if the point system for the currency wants to have different
    * values depending on what kind of currency is picked up (rare vs not rare).
    * -Stephanie Lascola
    */
    public void spawnCurrency()
    {
        if ((Greenfoot.getRandomNumber (2000) < 7) && (spawnTimer == 0))
        {
            Currency1 c1 = new Currency1();
            addObject(c1, getWidth(), getHeight()-100);
            spawnTimer = 60;
        }
        else if ((Greenfoot.getRandomNumber (2000) < 5) && (spawnTimer == 0))
        {
            Currency2 c2 = new Currency2();
            addObject(c2, getWidth(), getHeight()-100);
            spawnTimer = 60;
        }
    }
}
