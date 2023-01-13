import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The class Health contains the player's lives
 * 
 * @Stephen Liu 
 * @December 23, 2022
 */
public class Health extends Actor{        
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
     * The health box will turn red to signify low health
     */
    public void turnRed(){
        GreenfootImage redImage=new GreenfootImage("images/Health2.png");  
        redImage.scale(20, 40);
        setImage(redImage);
    }
}
