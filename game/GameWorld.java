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
    private Reference ref;
    private Reference ref2;
    public GreenfootSound music;
    private int platform1Timer = 0; //prevents platforms from spawning on top of each other
    private int platform2Timer = 0;
    private int platformLength; 
    private int platformLength2;
    private int totalLength;
    private int totalLength2;
    private int stagger; //holds how far the platform piece is displaced in the x-direction
    private int stagger2;
    private int aSpawnRate = 60; //spawn rate for enemyA (currently a % out of 100)
    private int bSpawnRate = 40; //spawn rate for enemyB
    private int cSpawnRate = 30; //spawn rate for enemyC
    private boolean isPlatformThere;
    private ScoreBoard scoreboard;
    private int mSpawnRate = 2;//spawn rate for meteors
    private int x; //holds the professors x coord
    private int y;//holds the professors y coord
    //Static boolean that can by changed by other classes to signify that the game has been requested to end
    public static boolean gameAskedToEnd = false;
    
    private int ammoCount = 0; 
    public static boolean gamePaused = false; //Flag that keeps track of whether the game is paused or not
    private int pauseTimer = 0; //Keeps the game from pausing then unpausing rapidly
    public  GreenfootSound bgSound = new GreenfootSound("ElectroRock.mp3");//edited by StephanieLascola different way to add sound
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 800x640 cells with a cell size of 1x1 pixels.
        super(800, 640, 1, false); 

        prepare();
        titleScreen();
       // GreenfootSound bgSound = new GreenfootSound("ElectroRock.mp3");  //start music
        //music credit: ElectroRock by Deceseased Superior Technician (feel free to change the music)
        bgSound.play(); //edited by Stephanie Lascola
    }

    public void act()
    {
        if(gamePaused == false)
        {
            count++; //Increase counter for global synchronization
            spawnObstacles();//spawns ground dinos
            spawnObstacles3();//spawns pterodactyls
            changeTimers();//counts down timer for spawning obstacles & platforms
            spawnCurrency();//adds the currency
            createPlatform1();//creates random platforms at the first height
            createPlatform2();//creates random platforms at the second height
            scoreboard.addScore(1);
            shootLazer();
            spawnmeteors();//spawns meteors
            spawn(); //spawns dinosaurs on platforms
        }
        checkForPause();
        checkForGameEndRequest();
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
        
        ref = new Reference();
        addObject(ref, 800, 250);
        ref2 = new Reference();
        addObject(ref2, 800, 450);

        setPaintOrder(PauseMenu.class, YesOption.class, NoOption.class, PurchaseWindow.class, GameStore.class, PowerUps1.class, PowerUps2.class, PowerUps3.class, CurrencyIndicator.class, Meteor.class, GrassLarge.class, GrassSmall.class, Professor.class, EnemyA.class, EnemyB.class, LightGroundOne.class, LightGroundTwo.class, EnemyC.class);

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

        BackerPM backerpm = new BackerPM();
        addObject(backerpm, 418, 296);
        HeaderPM headerpm = new HeaderPM();
        addObject(headerpm, 418, 176);
        Selection1 selection1 = new Selection1();
        addObject(selection1, 418, 263);
        Selection2 selection2 = new Selection2();
        addObject(selection2, 417, 335);
        BackerGS backergs = new BackerGS();
        addObject(backergs, 399, 321);
        CurrencyIndicator currencyindicator = new CurrencyIndicator();
        addObject(currencyindicator, 619, 25);
        CurrencyCounter currencycounter = new CurrencyCounter();
        addObject(currencycounter, 714, 20);
        GreenPotion itempanel1 = new GreenPotion();
        addObject(itempanel1, 154, 378);
        OrangePotion itempanel2 = new OrangePotion();
        addObject(itempanel2, 401,378);
        PurplePotion itempanel3 = new PurplePotion();
        addObject(itempanel3, 650,379);
        ShowMoneyString showmoneystring = new ShowMoneyString();
        addObject(showmoneystring, 412,103);
        PurchaseWindow purchasewindow = new PurchaseWindow();
        addObject(purchasewindow, 419, 273);
        YesOption yesoption = new YesOption();
        addObject(yesoption, 356, 290);
        NoOption nooption = new NoOption();
        addObject(nooption, 478, 291);
     

        scoreboard = new ScoreBoard();
        addObject(scoreboard, 80, 20);

        PowerUps powerups = new PowerUps();

        PowerUps1 powerups1 = new PowerUps1();
        addObject(powerups1, 35, 608);

        PowerUps2 powerups2 = new PowerUps2();
        addObject(powerups2, 95, 608);
        PowerUps3 powerups3 = new PowerUps3();
        addObject(powerups3, 155, 608);
    }
    
    /**
     * Spawns enemies randomly on the ground level
     * @Sarah Stephens
     */    
    public void spawnObstacles()
    {
        if (Greenfoot.getRandomNumber(2000) < 100 && spawnTimer == 0)
        {
            EnemyA enemyA = new EnemyA();
            addObject(enemyA, getWidth(), getHeight()-95);
            spawnTimer = 50;
        }        
        else if ((Greenfoot.getRandomNumber(2000) < 60) && (spawnTimer == 0) && getScore() > 500)
        {
            EnemyB enemyB = new EnemyB();
            addObject(enemyB, getWidth(), getHeight()-85);
            spawnTimer = 60;
        }
        
    }
    /**
     * This is supposed to spawn enemies at both height levels but I don't think it is working correctly
     * will look at later @Sarah Stephens
     */
    public void spawn()
    {
        if (Greenfoot.getRandomNumber(2) == 1)
        {
            spawnPlatformEnemies(415);
        }
        else
        {
            spawnPlatformEnemies(215);
        }
    }
    
    /**
     * Spawns Enemy A & B on the platforms randomly
     * int height is the height at which the enemies will spawn (on level 1 or 2)
     * @Sarah Stephens
     */
    public void spawnPlatformEnemies(int height)
    {
        if (height < 300)
        {
            isPlatformThere = ref.isPlatform();
        }
        else
        {
            isPlatformThere = ref2.isPlatform();
        }
        
        if ((spawnTimer == 0) && isPlatformThere == true)
        {
            if (Greenfoot.getRandomNumber(100) < 50) //chance to spawn enemy
            {
                if(Greenfoot.getRandomNumber(100) < 60)
                {
                    EnemyA enemyA = new EnemyA();
                    addObject(enemyA, getWidth(), height);
                    spawnTimer = 70;
                }
                else
                {
                    EnemyB b = new EnemyB();
                    addObject(b, getWidth(), height);
                    spawnTimer = 70;
                }
            }
        }
    }
    
    /**
     * spawns pterodactyls in the sky
     * @AlexCarpenter
     * edited by @NickJones @Sarah Stephens
     */    
    public void spawnObstacles3()
    {
        if(getScore() > 1500)
        {
            if ((Greenfoot.getRandomNumber(1000) < 20) && (spawnTimer == 0) && (airTimer == 0))
            {
                EnemyC enemyC = new EnemyC();
                addObject(enemyC, getWidth() + 60, 40 + Greenfoot.getRandomNumber(110));
                spawnTimer = 20;
                airTimer = 30;
            }
        }
    }

    /**
     * spawns meteors
     * @NickJones
     * edited: @ChandlerWarne
     */
    public void spawnmeteors()
    {
        if(getScore() > 2500 && getScore() < 4000)
        {
            if (Greenfoot.getRandomNumber(1000) < mSpawnRate + 1)
            {
                Meteor meteor = new Meteor();
                addObject(meteor, getWidth() - Greenfoot.getRandomNumber(200), Greenfoot.getRandomNumber(4));

            }
        }
        else if(getScore() > 2500 && getScore() < 4000)
        {
           if (Greenfoot.getRandomNumber(1000) < mSpawnRate + 1)
            {
                Meteor meteor = new Meteor();
                addObject(meteor, getWidth() + Greenfoot.getRandomNumber(200), Greenfoot.getRandomNumber(4));

            } 
        }
        if(getScore() > 4000)
        {
            if (Greenfoot.getRandomNumber(1000) < mSpawnRate + 3)
            {
                Meteor meteor = new Meteor();
                addObject(meteor, getWidth() - Greenfoot.getRandomNumber(200), Greenfoot.getRandomNumber(4));

            }
        }
         else if(getScore() > 4000)
        {
           if (Greenfoot.getRandomNumber(1000) < mSpawnRate + 1)
            {
                Meteor meteor = new Meteor();
                addObject(meteor, getWidth() + Greenfoot.getRandomNumber(200), Greenfoot.getRandomNumber(4));

            } 
        }
    }

    /**
     * Counts down the enemy & platform spawn timers once. Is used to 
     * set a cooldown for the spawn of obstacles and platforms so
     * that they will not overlap on the game screen.
     * @Sarah Stephens
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
     * edited: NickJones
     */
    public void spawnCurrency()
    {
        if ((Greenfoot.getRandomNumber (2000) < 7) && (spawnTimer == 0) && getScore() < 3000)
        {
            Currency1 c1 = new Currency1();
            addObject(c1, getWidth(), getHeight()-100);
            spawnTimer = 60;
        }

        else if ((Greenfoot.getRandomNumber (2000) < 5) && (spawnTimer == 0) && getScore() < 3000)
        {
            Currency2 c2 = new Currency2();
            addObject(c2, getWidth(), getHeight()-100);
            spawnTimer = 60;
        }
        if ((Greenfoot.getRandomNumber (2000) < 13) && (spawnTimer == 0) && getScore() > 3000)
        {
            Currency1 c1 = new Currency1();
            addObject(c1, getWidth(), getHeight()-100);
            spawnTimer = 60;
        }
        else if ((Greenfoot.getRandomNumber (2000) < 10) && (spawnTimer == 0) && getScore() > 3000)
        {
            Currency2 c2 = new Currency2();
            addObject(c2, getWidth(), getHeight()-100);
            spawnTimer = 60;
        }
    }

    
    /**
     * Spawns different length platforms at the first height level. 
     * @Sarah Stephens
     */
    public void createPlatform1()
    {
        PlatformStart pS = new PlatformStart();
        PlatformMid pM = new PlatformMid();
        PlatformEnd pE = new PlatformEnd();
        stagger = 69; //(138/2) 
        if (platform1Timer == 0) //spawn a new platform when timer is at zero
        {
            totalLength = Greenfoot.getRandomNumber (2); //gets a random length for the platform
            platformLength = totalLength;
            addObject(pS, getWidth() + stagger, 450); //add platform start piece
            stagger = stagger + 69;
            while (platformLength > 0) 
            {   
                stagger = stagger + 111;            
                addObject(pM, getWidth() + stagger, 450); 
                platformLength = platformLength - 1;  
                stagger = stagger + 111;
            }
            stagger = stagger + 69;
            addObject(pE, getWidth() + stagger, 450);
            platform1Timer = 80 + totalLength*40;
        }
    }

    public void createPlatform2()
    {
        PlatformStart pS = new PlatformStart();
        PlatformMid pM = new PlatformMid();
        PlatformEnd pE = new PlatformEnd();
        stagger = 180; 
        if (platform2Timer == 0) //spawn a new platform when timer is at zero
        {
            totalLength = Greenfoot.getRandomNumber (4); //gets a random length for the platform
            platformLength = totalLength;
            addObject(pS, getWidth(), 250); //add platform start piece
            while (platformLength > 0)
            {
                addObject(pM, getWidth() + stagger, 250);                           
                platformLength = platformLength - 1;       
                if (totalLength == 3)
                {
                    stagger = stagger + 50;
                }
                else if (totalLength == 1)
                {
                    stagger = stagger + 50;
                }
                else if (totalLength == 4)
                {
                    stagger = stagger + 30;
                }
                else 
                {
                    stagger = stagger + 45;
                }
                platform2Timer = platform2Timer + 20;
            }
            if (totalLength == 0)
            {
                addObject(pE, getWidth() + 100, 250);
                platform2Timer = platform2Timer + 70;
            }
            else if (totalLength == 1)
            {
                addObject(pE, getWidth() + stagger + 30, 250);
                platform2Timer = platform2Timer + 85;
            }
            else if (totalLength == 2)
            {
                addObject(pE, getWidth() + stagger + 20, 250);
                platform2Timer = platform2Timer + 70;
            }
            else if (totalLength == 3)
            {
                addObject(pE, getWidth() + stagger + 20, 250);
                platform2Timer = platform2Timer + 70;
            }
            else if (totalLength == 4)
            {
                addObject(pE, getWidth() + stagger + 20, 250);
                platform2Timer = platform2Timer + 50;
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
            bgSound.pause(); //StephanieLascola
        }
        if((Greenfoot.isKeyDown("p")) && (gamePaused == true) && (pauseTimer == 0))
        {
            unpauseTheGame();
            pauseTimer++;
            bgSound.play(); //StephanieLascola
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

    /** Ends the game if requested from outside class ~ Michael Tornatta **/
    public void checkForGameEndRequest()
    {
        if(gameAskedToEnd == true)
        {
            endGame();
        }
        else
        {

        }
    }

    /**
     * @Nick Jones
     * method for the end of the game
     */
    public void endGame()
    {
        GameOverScreen go = new GameOverScreen(getScore());
        Greenfoot.setWorld(go);
        bgSound.stop();
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
     * @Sarah Stephens
     * @Stephanie Lascola
     */
    public void shootLazer()
    {
        PowerUps3 p = new PowerUps3();
        getAmmoCount();
        x = prof.findX(); //returns professors X and Y coords to determine where lazer should fire from
        y = prof.findY();
        if ((Greenfoot.isKeyDown("3")) && lazerTimer == 0 && ammoCount > 0)
        {
            Lazer l = new Lazer();
            addObject(l, x, y);
            lazerTimer = 30;
            p.usePowerup();
        }
    }
   /**
    * Ammo count for the power up 3 
    * @StephanieLascola
    */
    public void getAmmoCount()    
    {
        PowerUps3 p = new PowerUps3();
        ammoCount = p.getP3Amount();
    }
   /**
    * Fixed start at intro screen
    * @StephanieLascola
    */
    public void titleScreen()
    {
        TitleScreen go = new TitleScreen();
        Greenfoot.setWorld(go);
        bgSound.stop();
    }
}

