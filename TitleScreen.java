import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen displays the name and instructions for the game
 * 
 * @Stephen Liu 
 * @December 18, 2022
 */
public class TitleScreen extends World{
    //Stores the background music for the game
    GreenfootSound background=new GreenfootSound("Background Music.wav");
    
    /**
     * Constructor of TitleScreen class 
     */
    public TitleScreen(){    
        // Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1);

        //Create and display a title
        Label title=new Label("Pokemon Targetry", 90);
        title.setFillColor(Color.RED);
        addObject(title, getWidth()/2, 100);

        //Create and display instructions
        Label continueGame=new Label("Press <space> to continue", 50);
        continueGame.setFillColor(Color.GREEN);
        addObject(continueGame, getWidth()/2, getHeight()/2);

        Label directions=new Label("Press the arrow keys to move character", 30);
        directions.setFillColor(Color.PINK);
        addObject(directions, getWidth()/2, 380);

        Label objective1=new Label("Press <q> to shoot at ", 30);
        objective1.setFillColor(Color.PINK);
        addObject(objective1, getWidth()/2-175, 415);

        Target titleTarget=new Target(true);
        GreenfootImage targetImage=titleTarget.getImage();  
        targetImage.scale(34, 30);
        titleTarget.setImage(targetImage);
        addObject(titleTarget, 360, 415);
        
        Label objective1Extra=new Label("(      is worth triple the score)", 30);
        objective1Extra.setFillColor(Color.PINK);
        addObject(objective1Extra, getWidth()/2+135, 415);
        
        Target titleTarget2=new Target(false);
        GreenfootImage targetImage2=titleTarget2.getImage();  
        targetImage2.scale(34, 30);
        titleTarget2.setImage(targetImage2);
        addObject(titleTarget2, 405, 415);
        
        Label objective2=new Label("Dodge the ", 30);
        objective2.setFillColor(Color.PINK);
        addObject(objective2, getWidth()/2-155, 450);
        
        Bomb titleBomb=new Bomb(true);
        GreenfootImage bombImage=titleBomb.getImage();  
        bombImage.scale(30, 30);
        titleBomb.setImage(bombImage);
        addObject(titleBomb, 315, 450);
        
        Label objective2Extra=new Label("(      costs twice the health)", 30);
        objective2Extra.setFillColor(Color.PINK);
        addObject(objective2Extra, getWidth()/2+80, 450);
        
        Bomb titleBomb2=new Bomb(false);
        GreenfootImage bombImage2=titleBomb2.getImage();  
        bombImage2.scale(30, 30);
        titleBomb2.setImage(bombImage2);
        addObject(titleBomb2, 355, 450);
        
        Label objective3=new Label("Heal by touching ", 30);
        objective3.setFillColor(Color.PINK);
        addObject(objective3, getWidth()/2, 485);
        
        Potion titlePotion=new Potion();
        GreenfootImage potionImage=titlePotion.getImage();  
        potionImage.scale(19, 30);
        titlePotion.setImage(potionImage);
        addObject(titlePotion, 515, 485);
    }
    
    /**
     * Plays the background music when game starts
     */
    public void started(){
        background.playLoop();
    }
    
    /**
     * Stops the background music when game ends
     */
    public void stopped(){
         background.pause();
    }
    
    /**
     * Checks if the space bar is pressed and goes to the game if pressed
     */
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld world=new MyWorld(0);
            Greenfoot.setWorld(world);
        }
    }
}
