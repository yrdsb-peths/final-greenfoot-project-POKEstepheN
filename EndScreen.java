import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The end screen is the display when the health of the player reaches 0
 * 
 * @Stephen Liu 
 * @December 23, 2022
 */
public class EndScreen extends World
{
    /**
     * Constructor for class EndScreen
     */
    public EndScreen(){    
        // Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1);

        //Create and display the Game Over message
        Label endLabel=new Label("Game Over", 90);
        addObject(endLabel, getWidth()/2, 150);

        //Create and display instructions to restart
        Label restart=new Label("Press <space> to try again", 50);
        addObject(restart, getWidth()/2, 400);
    }
    
    /**
     * The program checks if the user pressed space to restart game
     */
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld world=new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
}
