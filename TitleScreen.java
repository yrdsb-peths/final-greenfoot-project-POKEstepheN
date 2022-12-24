import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen displays the name and instructions for the game.
 * 
 * @Stephen Liu 
 * @December 18, 2022
 */
public class TitleScreen extends World{
    /**
     * Constructor of class TitleScreen
     */
    public TitleScreen(){    
        // Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1);

        //Create and display a title
        Label title=new Label("Pokemon Targetry", 90);
        addObject(title, getWidth()/2, 100);

        //Create and display instructions
        Label continueGame=new Label("Press <space> to continue", 50);
        addObject(continueGame, getWidth()/2, getHeight()/2);

        Label directions=new Label("Press the arrow keys to move character", 30);
        addObject(directions, getWidth()/2, 380);

        Label objective1=new Label("Press <q> to shoot at ", 30);
        addObject(objective1, getWidth()/2, 415);

        Target titleTarget=new Target();
        GreenfootImage targetImage=titleTarget.getImage();  
        targetImage.scale(34, 30);
        titleTarget.setImage(targetImage);
        addObject(titleTarget, 540, 415);

        Label objective2=new Label("Dodge the ", 30);
        addObject(objective2, getWidth()/2, 450);
        
        Bomb titleBomb=new Bomb();
        GreenfootImage bombImage=titleBomb.getImage();  
        bombImage.scale(30, 30);
        titleBomb.setImage(bombImage);
        addObject(titleBomb, 478, 450);
        
        Label objective3=new Label("Heal by touching ", 30);
        addObject(objective3, getWidth()/2, 485);
        
        Potion titlePotion=new Potion();
        GreenfootImage potionImage=titlePotion.getImage();  
        potionImage.scale(19, 30);
        titlePotion.setImage(potionImage);
        addObject(titlePotion, 515, 485);
    }

    /**
     * Checks if the space bar is pressed and goes to the game if pressed.
     */
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld world=new MyWorld(0);
            Greenfoot.setWorld(world);
        }
    }
}
