import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is world where the game actions occur
 * 
 * @Stephen Liu
 * @December 17, 2022
 */
public class MyWorld extends World{
    /**
     * Constructor for class MyWorld.
     */
    public MyWorld(){    
        // Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1);
        
        //Create Player object
        Player player=new Player();
        addObject(player, 100, getHeight()/2);
    }
}
