import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The class Health contains the player's lives
 * 
 * @Stephen Liu 
 * @December 23, 2022
 */
public class Health extends Actor
{        
    /**
     * Constructor for Health class
     */
    public Health(){
        GreenfootImage healthImage=getImage();  
        healthImage.scale(20, 40);
        setImage(healthImage);
    }
    
    /**
     * The health box will turn grey to signify a decrease in health
     */
    public void turnGrey(){
        GreenfootImage greyImage=new GreenfootImage("images/Health1.png");  
        greyImage.scale(20, 40);
        setImage(greyImage);
    }
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Add your action code here.
    }
}
