import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player is the character the user will control and interact with.
 * 
 * @Stephen Liu 
 * @December 19, 2022
 */
public class Player extends Actor
{
    //Create a list to store the character's animation and attack
    GreenfootImage[] idleRight=new GreenfootImage[4];
    GreenfootImage[] idleLeft=new GreenfootImage[4];
    GreenfootImage[] attackRight=new GreenfootImage[3];
    GreenfootImage[] attackLeft=new GreenfootImage[3];
    
    /*
     * Sets the index for animation and attack images, the direction the 
     * player is facing, the state of moving or attacking
     * and the timer to control animation and attack speeds.
     */ 
    int imageIndex=0;
    int attackIndex=0;
    String facing="right";
    String state="move";
    SimpleTimer animationTimer=new SimpleTimer();
    SimpleTimer attackTimer=new SimpleTimer();
    
    /**
     * Constructor for Player class
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
        
        //The attack list now contains the different movements
        for(int i=0; i<attackRight.length; i++)
        {
            attackRight[i]=new GreenfootImage("images/Attack"+i+".png");
            attackRight[i].scale(67, 100);
        }
        
        for(int i=0; i<attackLeft.length; i++)
        {
            attackLeft[i]=new GreenfootImage("images/Attack"+i+".png");
            attackLeft[i].mirrorHorizontally();
            attackLeft[i].scale(67, 100);
        }
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
     * This method displays different images to create an attack.
     */
    public void attack()
    {
        if(attackTimer.millisElapsed()<400)
        {
            return;
        }
        
        //If the last attack image is displayed, the state changes to move and index resets
        if(attackIndex==3)
        {
            attackIndex=0;
            state="move";
            return;
        }

        //If 400 milliseconds have passed, the attack timer resets
        attackTimer.mark();
        
        //Attack animation depends on the direction the player is facing
        if(facing.equals("right"))
        {
            setImage(attackRight[attackIndex]);
            attackIndex++;
        }
        else
        {
            setImage(attackLeft[attackIndex]);
            attackIndex++;
        }
    } 
    
    /**
     * The actions that the player does or could do based on conditions.
     */
    public void act()
    {
        if(state.equals("move"))
        {
            animate();
        }
        else
        {
            attack();
        }
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
        
        //The player fires if the user pressed q key
        if(Greenfoot.isKeyDown("q"))
        {
            state="attack";
            attackTimer.mark();
        }
    }
}
