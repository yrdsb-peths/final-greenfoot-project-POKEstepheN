import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The target is what the player is trying to shoot at.
 * 
 * @Stephen Liu 
 * @December 19, 2022
 */
public class Target extends Actor{
    //Creates a list to store the target's rotation animation
    GreenfootImage[] rotationTarget=new GreenfootImage[4];
    
    //Sets the index and speed for rotation animation 
    int rotationTargetIndex=0;
    SimpleTimer rotationTargetTimer=new SimpleTimer();
    
    /**
     * Contructor for Target class
     */
    public Target(){
        //The rotation animation list now contains the different rotations
        for(int i=0; i<rotationTarget.length; i++){
            rotationTarget[i]=new GreenfootImage("images/Target.png");
            rotationTarget[i].rotate(-90*i);
            rotationTarget[i].scale(87, 75);
        }
        
        rotationTargetTimer.mark();
        setImage(rotationTarget[0]);
    }
    
    /**
     * This method displays different rotation images.
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
     * The actions that the target will perform such as rotating.
     */
    public void act(){
        //If the target is in the game world, the animation will be displayed
        if(getWorld().getClass()==MyWorld.class){
            targetAnimate();
        }
    }
}
