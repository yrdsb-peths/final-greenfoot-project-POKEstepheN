import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The end screen is displayed when the health of the player reaches 0
 * 
 * @Stephen Liu 
 * @December 23, 2022
 */
public class EndScreen extends World{
    //Create a variable and a label to store and display the highest score 
    public int highScore;
    public Label highScoreLabel;
    
    /**
     * Constructor for EndScreen class 
     * 
     * @param score The number of points the user got throughout the game
     * @param high The high score from previous rounds
     */
    public EndScreen(int score, int high){    
        // Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1);

        //Create and display the Game Over message
        Label endLabel=new Label("Game Over", 90);
        addObject(endLabel, getWidth()/2, 150);
        
        //Create and display the score
        Label totalScore=new Label("Score: "+score, 60);
        addObject(totalScore, getWidth()/2, getHeight()/2);
        
        /*
         * If the score exceeds the original highest score, the new score
         * will replace the old highest score
         */
        highScore=high;
        if(score>highScore){
            highScore=score;
        }
        highScoreLabel=new Label("Highest score: "+highScore, 60);
        addObject(highScoreLabel, getWidth()/2, 300);
        
        //Create and display instructions to restart
        Label restart=new Label("Press <space> to try again", 50);
        addObject(restart, getWidth()/2, 400);
    }
    
    /**
     * The program checks if the user pressed space to restart game
     */
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld world=new MyWorld(highScore);
            Greenfoot.setWorld(world);
        }
    }
}
