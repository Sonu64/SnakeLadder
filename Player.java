/*
 All the attributes and method for each player is here 
*/
package snake.ladder;
public class Player{
    private String name;
    private int currentPosition;
    
    //constructor
    public Player(String name, int currentPosition)
    {
        if(name!="")
            this.name = name;
        else
            this.name = "Guest";
        if(currentPosition==0.0 && currentPosition<=100.0)
            this.currentPosition = currentPosition;
        else
            this.currentPosition = 0;
    }
    
    public int getCurrentPosition()
    {
        return currentPosition;
    }
    public String getPlayerName()
    {
        return name;
    }
    public int getDiceResult()
    {
        int result = (int)(Math.random()*6) + 1;
        return result;
    }
    public void move(int currentPosition)
    {
        double diceResult = getDiceResult();
        System.out.println("Dice Result for " + name + " = " + diceResult);
        currentPosition = (int)(currentPosition + diceResult);
        this.currentPosition = currentPosition;
    }
    public void climbLadder(int currentPosition, int increaseAmount)
    {
        
        
        currentPosition = currentPosition + increaseAmount;
        this.currentPosition = currentPosition;
    }
    public void downViaSnake(int currentPosition, int decreaseAmount)
    {
        
        currentPosition = currentPosition - decreaseAmount;
        this.currentPosition = currentPosition;       
    }
}
