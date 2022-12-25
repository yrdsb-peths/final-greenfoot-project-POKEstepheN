import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bomb inflicts damage to the character
 * 
 * @Stephen Liu 
 * @December 19, 2022
 */
public class Bomb extends Actor{
    //Creates a list to store the bomb's rotation animation
    GreenfootImage[] rotationBomb=new GreenfootImage[4];
    
    //Creates a bomb sound effect
    GreenfootSound explosion=new GreenfootSound("Bomb Sound.wav");
    
    //Sets the index and speed
    int rotationBombIndex=0;
    SimpleTimer rotationBombTimer=new SimpleTimer();
    
    /**
     * Contructor for Bomb class
     */
    public Bomb(){
        //The different rotation positions are created
        for(int i=0; i<rotationBomb.length; i++){
            rotationBomb[i]=new GreenfootImage("images/Bomb.png");
            rotationBomb[i].rotate(-90*i);
            rotationBomb[i].scale(77, 75);
        }
        
        rotationBombTimer.mark();
        setImage(rotationBomb[0]);
    }
    
    /**
     * This method displays different rotation images
     */
    public void bombAnimate(){
        if(rotationBombTimer.millisElapsed()<100){
            return;
        }
        
        //If 100 milliseconds have passed, the timer resets
        rotationBombTimer.mark();
        
        //A new image is shown
        setImage(rotationBomb[rotationBombIndex]);
        rotationBombIndex=(rotationBombIndex+1)%rotationBomb.length;
    }
    
    /**
     * The bomb will perform actions will rotate, move and respawn
     */
    public void act(){
        //If the bomb is in the main game world, it will animate.
        if(getWorld().getClass()==MyWorld.class){
            MyWorld world=(MyWorld) getWorld();
            bombAnimate();
            setLocation(getX()-world.level, getY());
            
            //Occurs when the bomb reaches the screen's left end
            if(getX()<0){
                world.removeObject(this);
                world.spawnBomb();
            }
            //Occurs when the bomb hits the player
            else if(isTouching(Player.class)){
                //An explosion sound is generated
                explosion.play();
                
                //Remove the bomb
                world.removeObject(this);
                
                //The health will go down and a new bomb reappears
                world.changeHealth(-4);
                world.spawnBomb();
            }
        }
    }
}
