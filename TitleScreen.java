import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen displays the name and instructions for the game.
 * 
 * @Stephen Liu 
 * @December 18, 2022
 */
public class TitleScreen extends World
{
    /**
     * Constructor of class TitleScreen.
     */
    public TitleScreen()
    {    
        // Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1);
        
        //Create and display a title
        Label title=new Label("Pokemon Targetry", 90);
        addObject(title, getWidth()/2, 100);
        
        //Create and display instructions
    }
    
    /**
     * Checks if the space bar is pressed and goes to the game if pressed.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world=new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
}
