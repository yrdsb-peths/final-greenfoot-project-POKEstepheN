import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The target is what the player is trying to shoot at
 * 
 * @Stephen Liu 
 * @December 19, 2022
 */
public class Target extends Actor{
    //Creates a list to store the target's rotation animation
    GreenfootImage[] rotationTarget=new GreenfootImage[4];
    
    //Create sound effect if the target is hit
    GreenfootSound hitSound=new GreenfootSound("Hit Target.wav");
    
    //Sets the index and timer for rotation animation 
    int rotationTargetIndex=0;
    SimpleTimer rotationTargetTimer=new SimpleTimer();
    
    //Stores the state of the target(default or shiny)
    boolean isDefault;
    
    /**
     * Contructor for Target class
     * 
     * @param isDefault The target state
     */
    public Target(boolean isDefault){
        //Sets the state
        this.isDefault=isDefault;
        
        //The rotation animation list now contains the different rotations
        if(isDefault){
            for(int i=0; i<rotationTarget.length; i++){
                rotationTarget[i]=new GreenfootImage("images/Target.png");
                rotationTarget[i].rotate(-90*i);
                rotationTarget[i].scale(87, 75);
            }
        }
        else{
            for(int i=0; i<rotationTarget.length; i++){
                rotationTarget[i]=new GreenfootImage("images/ShinyTarget.png");
                rotationTarget[i].rotate(-90*i);
                rotationTarget[i].scale(87, 75);
            }
        }
        
        rotationTargetTimer.mark();
        setImage(rotationTarget[0]);
    }
    
    /**
     * This method displays different rotation images
     */
    public void targetAnimate(){
        if(rotationTargetTimer.millisElapsed()<100){
            return;
        }
        
        //If 100 milliseconds have passed, the timer resets
        rotationTargetTimer.mark();
        
        //A new image is shown
        setImage(rotationTarget[rotationTargetIndex]);
        rotationTargetIndex=(rotationTargetIndex+1)%rotationTarget.length;
    }
    
    /**
     * The actions that the target will perform, includes rotating, moving, 
     * and respawning
     */
    public void act(){
        /*
         * If the target is in the game world, the animation will be 
         * displayed and the target will move from right to left
         */
        if(getWorld().getClass()==MyWorld.class){
            MyWorld world=(MyWorld) getWorld();
            targetAnimate();
            setLocation(getX()-world.level, getY());
            
            //Occurs when the target touches the left side of the screen
            if(getX()<0){
                world.removeObject(this);
                world.spawnTarget();
            }
            
            //Occurs when the target is hit
            else if(isTouching(AttackBolt.class) && getX()<770){
                //The hit sound effect is played
                hitSound.play();
                
                //Remove the target
                world.removeObject(this);
                
                //The score will increase and a new target appears
                if(isDefault){
                    world.increaseScore(1);
                }
                else{
                    world.increaseScore(3);
                }
                world.spawnTarget();
            }
        }
    }
}
