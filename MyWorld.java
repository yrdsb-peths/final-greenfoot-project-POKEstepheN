import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is world where the game actions occur
 * 
 * @Stephen Liu
 * @December 17, 2022
 */
public class MyWorld extends World{
    public int score=0;
    public Label scoreLabel;
    public int level=1;
    
    //Stores the health and the health bar
    public int health=20;
    public Label healthLabel;
    Health[] healthbar=new Health[20];
    
    /**
     * Constructor for class MyWorld
     */
    public MyWorld(){    
        //Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1, false);
        
        //Create Player object
        Player player=new Player();
        addObject(player, 100, getHeight()/2);
        
        //Create score counter
        scoreLabel=new Label("Score: "+score, 80);
        addObject(scoreLabel, 650, 60);
        
        //Display health bar
        healthLabel=new Label("HP", 60);
        addObject(healthLabel, 40, 35);
        for(int i=0; i<healthbar.length; i++){
            healthbar[i]=new Health();
            addObject(healthbar[i], 20+24*i, 80);
        }
        
        //A target, bomb, and potion is spawned to the game world
        spawnTarget();
        spawnBomb();
        spawnPotion();
    }
    
    /**
     * A new target appears at the right side of the window
     */
    public void spawnTarget(){
        Target target=new Target();
        int x=800;
        int y=Greenfoot.getRandomNumber(getHeight());
        addObject(target, x, y);
    }
    
    /**
     * A new bomb appears at the screen's right side
     */
    public void spawnBomb(){
        Bomb bomb=new Bomb();
        int x=800;
        int y=Greenfoot.getRandomNumber(getHeight());
        addObject(bomb, x, y);
    }
    
    /**
     * A new potion appears at a random spot on the right of the screen
     */
    public void spawnPotion(){
        Potion potion=new Potion();
        int x=800;
        int y=Greenfoot.getRandomNumber(getHeight());
        addObject(potion, x, y);
    }
    
    /**
     * The score is increased if the target is hit
     */
    public void increaseScore(){
        score++;
        scoreLabel.setValue("Score: "+score);
        
        //After five successful hits, the speed increases
        if(score%5==0 && level<8)
        {
            level++;
        }
    }
    
    /**
     * The health is decreased if the bomb hits the player
     */
    public void decreaseHealth(){
        health-=4;
        
        //Switches to game over screen
        if(health<=0){
            EndScreen end=new EndScreen(score);
            Greenfoot.setWorld(end);
        }
        
        for(int i=0; i<healthbar.length; i++){
            healthbar[i]=new Health();
            if(i>=health){
                healthbar[i].turnGrey();
            }
            addObject(healthbar[i], 20+24*i, 80);
        }
    }
}
