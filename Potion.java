import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The potion heals the character if touched
 * 
 * @Stephen Liu
 * @December 19, 2022
 */
public class Potion extends Actor{
    //Creates a healing sound effect
    GreenfootSound healing=new GreenfootSound("Heal Sound.wav");
    
    /**
     * Constructor for Potion class
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
            
            MyWorld world=(MyWorld) getWorld();
            //Occurs when the potion touches the left end of the screen
            if(getX()<0){
                world.removeObject(this);
                world.spawnPotion();
            }
            //Occurs when the potion comes in contact with the player
            else if(isTouching(Player.class)){
                //A sound effect is played
                healing.play();
                
                //Remove the potion
                world.removeObject(this);
                
                //The health increases and a potion will respawn
                world.changeHealth(3);
                world.spawnPotion();
            }
        }
    }
}
