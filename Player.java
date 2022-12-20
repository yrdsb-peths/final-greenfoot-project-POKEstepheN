import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player is the character the user will control and interact with.
 * 
 * @Stephen Liu 
 * @December 19, 2022
 */
public class Player extends Actor
{
    //Create a list to store the character's animation
    GreenfootImage[] idleRight=new GreenfootImage[4];
    GreenfootImage[] idleLeft=new GreenfootImage[4];
    
    /*
     * Sets the index for animation images, the direction the player is facing
     * and the timer to control animation speeds.
     */ 
    int imageIndex=0;
    String facing="right";
    SimpleTimer animationTimer=new SimpleTimer();
    
    /**
     * Constructor for player class
     */
    public Player()
    {
        //The idle animation list now contains the different movements
        for(int i=0; i<idleRight.length; i++)
        {
            idleRight[i]=new GreenfootImage("images/Running"+i+".png");
            idleRight[i].scale(164, 100);
        }
        
        for(int i=0; i<idleLeft.length; i++)
        {
            idleLeft[i]=new GreenfootImage("images/Running"+i+".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(164, 100);
        }
        
        animationTimer.mark();

        setImage(idleRight[0]);
    }
    
    /**
     * This method displays different images to create an animation.
     */
    public void animate()
    {
        if(animationTimer.millisElapsed()<100)
        {
            return;
        }
        
        //If 100 milliseconds have passed, the animation timer resets
        animationTimer.mark();
        
        //Animation depends on the direction the player is facing
        if(facing.equals("right"))
        {
            imageIndex=(imageIndex+1)%idleRight.length;
            setImage(idleRight[imageIndex]);
        }
        else
        {
            imageIndex=(imageIndex+1)%idleLeft.length;
            setImage(idleLeft[imageIndex]);
        }
    }    
    
    /**
     * The actions that the player does or could do based on conditions.
     */
    public void act()
    {
        animate();
        //The player moves in a direction based on the arrow keys
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-5);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+5, getY());
            facing="right";
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+5);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-5, getY());
            facing="left";
        }
    }
}
