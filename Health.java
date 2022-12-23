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
     * The constructor for Health.
     */
    public Health(){
        GreenfootImage healthImage=getImage();  
        healthImage.scale(20, 40);
        setImage(healthImage);
    }

    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Add your action code here.
    }
}
