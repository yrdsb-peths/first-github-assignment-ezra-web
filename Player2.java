import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int hasEgg = 0;
    int count = 0;
    
    int speed = 2;
    GreenfootSound touchDown = new GreenfootSound("dinosaur-2-86565.mp3");
    
    GreenfootImage[] walk = new GreenfootImage[6];
    
    public void act() 
    {
        move(- + speed);
        if(Greenfoot.isKeyDown("right"))
        {
            turn(3);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-3);
        }
        animateMuchkin();
        stealEgg();
        tagged();
        if(count == 3)
        {
            MyWorld world = (MyWorld) getWorld();
            world.gameOverPlayer2();
        }
        
    }    
    
    int imageIndex = 0;
    private SimpleTimer timer = new SimpleTimer();
    public void animateMuchkin()
    {
        if(timer.millisElapsed() > 140)
        {
            setImage(walk[imageIndex]);
            imageIndex = (imageIndex + 1) % walk.length;
            timer.mark();
        }
    }
    
    public Player2()
    {
        for(int i = 0; i < walk.length; i++)
        {
            walk[i] = new GreenfootImage("images/player walking/Muchkin" + i + ".png");
            walk[i].mirrorHorizontally();
            walk[i].scale(54,54);
            // 55, 55 past
        }
    }
    
    
    public void stealEgg()
    {
        Actor gotEgg2 = getOneIntersectingObject(Egg2.class);
        if(isTouching(Egg2.class))
        {
            getWorld().removeObject(gotEgg2);
            hasEgg += 1;
        }
        
        if(getX() >= 400 && hasEgg == 1)
        {
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore2();
            hasEgg --;
            count ++;
            touchDown.play();
        }
    }

    public void tagged()
    {
        Actor gotCaught = getOneIntersectingObject(Dino.class);
        if(isTouching(Dino.class) && getX() <= 400)
        {
            int x = 750;
            int y = 300;
            setLocation(x,y);
            hasEgg = 0;
            MyWorld world = (MyWorld) getWorld();
            world.spawnEgg2();
        }
    }
}
