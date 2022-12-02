import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * my elephant game, with score now
 * @author Ezra
 * @version Dec1, 2
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //Makes elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        //Label created
        scoreLabel = new Label(0, 50);
        addObject(scoreLabel, 20, 20);
        
        createApple();
    }
    
    /**
     * Ends the game says "gameOver"
     */
    public void gameOver()
    {
        Label gameOver = new Label("Game Over", 100);
        addObject(gameOver, 300, 200);
    }
    
    /**
     * increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
