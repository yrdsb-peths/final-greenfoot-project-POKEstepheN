import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The object that the player is trying to shoot (Worth triple the amount of
 * points as a regular target)
 * 
 * @Stephen Liu
 * @January 10, 2023
 */
public class ShinyTarget extends Target
{
    /**
     * Constructor for ShinyTarget class
     */
    public ShinyTarget(){
        //The rotation animation list now contains the different rotations
        for(int i=0; i<rotationTarget.length; i++){
            rotationTarget[i]=new GreenfootImage("images/ShinyTarget.png");
            rotationTarget[i].rotate(-90*i);
            rotationTarget[i].scale(87, 75);
        }
        
        rotationTargetTimer.mark();
        setImage(rotationTarget[0]);
    }
}
