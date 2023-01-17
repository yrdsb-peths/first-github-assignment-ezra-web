import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    
    public int score2 = 0;
    Label score2Label;
    
    public int point = 0;
    
    GreenfootSound celebration = new GreenfootSound("tada-fanfare-a-6313.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        
        Dino player1 = new Dino();
        addObject(player1, 50, 350);
        
        Player2 player2 = new Player2();
        addObject(player2, 750, 50);
        
        //Egg1 egg1 = new Egg1();
        //addObject(egg1, 770, 200);
        spawnEgg1();
        
        //Egg2 egg2 = new Egg2();
        //addObject(egg2, 30, 200);
        spawnEgg2();
        
        scoreLabel = new Label(0, 50);
        addObject(scoreLabel, 20, 20);
        
        score2Label = new Label(0, 50);
        addObject(score2Label, 750, 20);
        
        powerUp();
    }
    
    
    public void spawnEgg1()
    {
        Egg1 egg1 = new Egg1();
        addObject(egg1, 770, 200);
    }
    
    
    public void spawnEgg2()
    {
        Egg2 egg2 = new Egg2();
        addObject(egg2, 30, 200);
    }
    
    
    public void powerUp()
    {
        PowerUp shoe = new PowerUp();
        int x = Greenfoot.getRandomNumber(800);
        int y = Greenfoot.getRandomNumber(400);
        addObject(shoe, x, y);
    }
    
    public void gameOver()
    {
        if(score == 3)
        {
            Label gameOver = new Label("Player 1 Wins", 100);
            addObject(gameOver, 400, 200);
            celebration.play();
        }
    }
    
    
    public void gameOverPlayer2()
    {
        if(score2 == 3)
        {
            Label gameOverPlayer2 = new Label("Player 2 Wins", 100);
            addObject(gameOverPlayer2, 400, 200);
            celebration.play();
        }
    }
    
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        spawnEgg1();
    }
    
    public void increaseScore2()
    {
        score2++;
        score2Label.setValue(score2);
        spawnEgg2();
    }
}
