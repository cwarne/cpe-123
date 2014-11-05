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
    private int airTimer = 0; //Time since last obstacles in the air
    private int lazerTimer = 0;
    private Professor prof;
    public GreenfootSound music;
    private int platform1Timer = 0; //prevents platforms from spawning on top of each other
    private int platform2Timer = 0;
    private int platformNumber;
    private int aSpawnRate = 60; //spawn rate for enemyA (currently a % out of 100)
    private int bSpawnRate = 40; //spawn rate for enemyB
    private int cSpawnRate = 30; //spawn rate for enemyC
    private ScoreBoard scoreboard;
    
    private int ammoCount = 0; 
    public static boolean gamePaused = false; //Flag that keeps track of whether the game is paused or not
    private int pauseTimer = 0; //Keeps the game from pausing then unpausing rapidly

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 800x640 cells with a cell size of 1x1 pixels.
        super(800, 640, 1, false); 

        prepare();
        
        music = new GreenfootSound("ElectroRock.mp3"); //start music
        //music credit: ElectroRock by Deceseased Superior Technician (feel free to change the music)
        music.playLoop();
    }

    public void act()
    {
        if(gamePaused == false)
        {
            count++; //Increase counter for global synchronization
            spawnObstacles();//adds obstacles
            spawnObstacles3();//spawns pterodactyls
            changeTimers();//counts down timer for spawning obstacles & platforms
            spawnCurrency();//adds the currency
            createPlatform1();//creates random platforms at the first height
            createPlatform2();//creates random platforms at the second height
            scoreboard.addScore(1);
            shootLazer();
        }
        checkForPause();
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
        
        Platforms p2 = new Platforms();
        addObject(p2, 400, 590);

        prof = new Professor();
        addObject(prof, 268, 480);

        setPaintOrder(GrassLarge.class, GrassSmall.class, Professor.class, EnemyA.class, EnemyB.class, LightGroundOne.class, LightGroundTwo.class, EnemyC.class);

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
        
        scoreboard = new ScoreBoard();
        addObject(scoreboard, 80, 20);
        
        PowerUps powerups = new PowerUps();
        addObject(powerups, 1, 640);
        PowerUps1 powerups1 = new PowerUps1();
        addObject(powerups1, 1, 640);
        PowerUps2 powerups2 = new PowerUps2();
        addObject(powerups2, 1, 640);
        PowerUps3 powerups3 = new PowerUps3();
        addObject(powerups3, 1, 640);
    }
    /**
     * Spawns random obstacles
     * Sets timer to ensure that spawned objects won't overlap
     * @SarahStephens
     */
    public void spawnObstacles()
    {
        if ((Greenfoot.getRandomNumber(2000) < 10) && (spawnTimer == 0))
        {
            EnemyA enemyA = new EnemyA();
            addObject(enemyA, getWidth(), getHeight()-95);
            spawnTimer = 50;
        }        
        else if ((Greenfoot.getRandomNumber(2000) < 6) && (spawnTimer == 0))
        {
            EnemyB enemyB = new EnemyB();
            addObject(enemyB, getWidth(), getHeight()-85);
            spawnTimer = 70;
        }    
    }
    /**
     * spawn random enemies on the first platform level
     * @SarahStephens
     */
    public void spawnObstacles1()
    {
         if ((Greenfoot.getRandomNumber(100) < aSpawnRate) && (spawnTimer == 0))
        {
            EnemyA enemyA = new EnemyA();
            addObject(enemyA, getWidth() + Greenfoot.getRandomNumber(60), 430);
            spawnTimer = 30;
        }        
        else if (spawnTimer == 0)
        {
            EnemyB enemyB = new EnemyB();
            addObject(enemyB, getWidth() + Greenfoot.getRandomNumber(60), 415);  
            spawnTimer = 40;
        }    
    }
     /**
     * spawn random enemies on the second platform level
     * @SarahStephens
     */
    public void spawnObstacles2()
    {
         if (Greenfoot.getRandomNumber(100) < aSpawnRate) 
        {
            EnemyA enemyA = new EnemyA();
            addObject(enemyA, getWidth() + Greenfoot.getRandomNumber(60) , 230);
            spawnTimer = 50;
        }        
        else 
        {
            EnemyB enemyB = new EnemyB();
            addObject(enemyB, getWidth() + Greenfoot.getRandomNumber(60), 215); 
            spawnTimer = 70;
        }    
    }
    /**
     * spawns pterodactyls in the sky
     * @AlexCarpenter
     */
    public void spawnObstacles3()
    {
        if ((Greenfoot.getRandomNumber(1000) < 20) && (spawnTimer == 0) && (airTimer == 0))
        {
            EnemyC enemyC = new EnemyC();
            addObject(enemyC, getWidth() + Greenfoot.getRandomNumber(60), 40);
            spawnTimer = 20;
            airTimer = 30;
        }
    }
    /**
     * Counts down the enemy & platform spawn timers once. Is used to 
     * set a cooldown for the spawn of obstacles and platforms so
     * that they will not overlap on the game screen.
     * @SarahStephens
     */
    public void changeTimers()
    {
        if (spawnTimer > 0)//for enemy & powerup spawning
        {
            spawnTimer = spawnTimer - 1;
        }
        if (platform1Timer > 0)//for spawning level 1 platforms
        {
            platform1Timer = platform1Timer - 1;
        }
        if (platform2Timer > 0)//for spawning level 2 platforms
        {
            platform2Timer = platform2Timer - 1;
        }        
        if (airTimer > 0) //for spawning pterodactyls
        {
            airTimer = airTimer - 1;
        }        
        if (lazerTimer > 0) //for shooting lazers
        {
            lazerTimer = lazerTimer -1;
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
    
    /**
     * Spawn random platforms at the first height level of different lengths. Also calls the method to spawn random obstacles at that height
     * @SarahStephens
     */
    public void createPlatform1()
    {
        if(platform1Timer == 0) //prevents platforms from spawning on top of each other
        {
            platformNumber = Greenfoot.getRandomNumber(6);
            
            if (platformNumber == 0)
            {
               P10 p = new P10();
               addObject(p, getWidth() + 150 , 450); // X is world width + some to make sure the whole platform starts off screen
               platform1Timer = 150; // platform timer = P# * 15
               if (Greenfoot.getRandomNumber(2)== 1)
               {
                   spawnObstacles1();
               }
            }
            else if (platformNumber == 1)
            {
                P2 p = new P2();
                addObject(p, getWidth() + 20, 450);
                platform1Timer = 60;
                if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles1();
                }
            }
            else if (platformNumber == 2)
            {
                P3 p = new P3();
                addObject(p, getWidth() + 40, 450);
                platform1Timer = 45;
                if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles1();
                }
            }
            else if (platformNumber == 3)
            {
                P4 p = new P4();
                addObject(p, getWidth() + 50, 450);
                platform1Timer = 60;
                if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles1();
                }
            }
            else if (platformNumber == 4)
            {
                P8 p = new P8();
                addObject(p, getWidth() + 100, 450);
                platform1Timer = 120;
                if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles1();
                }
            }
            else if (platformNumber == 5)
            {
                P12 p = new P12();
                addObject(p, getWidth() + 170, 450);
                platform1Timer = 180;
                if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles1();
                }
            }
        }        
    }
    /**
     * Spawn random platforms at the second height level of different lengths
     * @SarahStephens
     */
    public void createPlatform2()
    {
        if(platform2Timer == 0)
        {
            platformNumber = Greenfoot.getRandomNumber(6);
            
            if (platformNumber == 0)
            {
               P10 p = new P10();
               addObject(p, getWidth() + 150, 250);
               platform2Timer = 150;
               if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles2();
                }
            }
            else if (platformNumber == 1)
            {
                P2 p = new P2();
                addObject(p, getWidth() + 20, 250);
                platform2Timer = 60;
                if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles2();
                }
            }
            else if (platformNumber == 2)
            {
                P3 p = new P3();
                addObject(p, getWidth() + 40, 250);
                platform2Timer = 45;
                if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles2();
                }
            }
            else if (platformNumber == 3)
            {
                P8 p = new P8();
                addObject(p, getWidth() + 100, 250);
                platform2Timer = 120;        
                if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles2();
                }
            }
            else if (platformNumber == 4)
            {
                P4 p = new P4();
                addObject(p, getWidth() + 50, 250);
                platform2Timer = 60;
                if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles2();
                }
            }
            else if (platformNumber == 5)
            {
                P12 p = new P12();
                addObject(p, getWidth() + 170, 250);
                platform2Timer = 150;
                if (Greenfoot.getRandomNumber(2)== 1)
                {
                    spawnObstacles2();
                }
            }
        }
    }
    /** Check for a user requested pause in the game 
       All pause related code added ~ Michael Tornatta **/
    public void checkForPause()
    {
        if((Greenfoot.isKeyDown("p")) && (gamePaused == false) && (pauseTimer == 0))
        {
            pauseTheGame();
            pauseTimer++;
        }
        if((Greenfoot.isKeyDown("p")) && (gamePaused == true) && (pauseTimer == 0))
        {
            unpauseTheGame();
            pauseTimer++;
        }
        if((pauseTimer > 0) && (pauseTimer <= 10))
        {
            pauseTimer++;
        }
        if(pauseTimer >= 10)
        {
            pauseTimer = 0;
        }
    }
    public void pauseTheGame()
    {
        gamePaused = true;
        //System.out.println("Paused");
    }
    public void unpauseTheGame()
    {
        gamePaused = false;
        //System.out.println("UnPaused");
    }
    public int getTimer()
    {
        return platform1Timer;
    }
     /**
     * @Nick Jones
     * method for the end of the game
     */
    public void endGame()
    {
        GameOverScreen go = new GameOverScreen(getScore());
        Greenfoot.setWorld(go);
        music.stop();
    }
        public int getScore()
    {
         return scoreboard.getScore();
    }
    
   /**
    * @Sarah Stephens
    * @Stephanie Lascola
    */
    public Professor getProfessor()
    {
        return prof;
    }
   /**
    * Shoots lazers with ammo, currently there is no way to get ammo, but will be fixed soon! :)
    * @Sarah Stephens
    * @Stephanie Lascola
    */
    public void shootLazer()
    {
        if ((Greenfoot.isKeyDown("f")) && lazerTimer == 0 && ammoCount > 0)
        {
            Lazer l = new Lazer();
            addObject(l, 100, 230);
            lazerTimer = 30;
            ammoCount = ammoCount - 1;
        }
    }
}

    

   
