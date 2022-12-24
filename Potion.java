import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The potion heals the character.
 * 
 * @Stephen Liu
 * @December 19, 2022
 */
public class Potion extends Actor{
    /**
     * Constructor for potion class
     */
    public Potion(){
        GreenfootImage potionImage=getImage();  
        potionImage.scale(48, 75);
        setImage(potionImage);
    }
    
    /**
     * The potion moves across the screen and heals the player if touched
     */
    public void act(){
        //If the potion exists in the main game, then it will move
        if(getWorld().getClass()==MyWorld.class){
            setLocation(getX()-5, getY());
        }
    }
}
