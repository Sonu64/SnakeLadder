/*
 All the attributes and methods for each player is here
 NOTE :- HOME refers to position 1.
*/
package snake.ladder;
public class Player{
    private String name; //FOR THE PLAYER NAME
    private int currentPosition; //FOR THE CURRENT POSITION OF THE PLAYER IN THE BOARD
    
    //constructor
    public Player(String name, int currentPosition)
    {
        //if name's not given, assign Guest to it
        if(!(name.equals("")))
            this.name = name;
        else
            this.name = "Guest";
        //if currentPosition is valid in a Snake-Ladder board
        if(currentPosition==1.0 && currentPosition<=100.0)
            this.currentPosition = currentPosition;
        else
            this.currentPosition = 0;
    }
    
    public int getCurrentPosition()
    {
        /*RETURNS THE CURRENT POSITION OF A PLAYER ON THE BOARD*/
        return currentPosition;
    }
    public String getPlayerName()
    {
        /*RETURNS THE NAME OF A PLAYER*/
        return name;
    }
    public int getDiceResult()
    {
        /*GETS A RANDOM VALUE AS THE DICE OUTCOME AND RETURNS IT*/
        int result = (int)(Math.random()*6) + 1;
        return result;
    }
    public void move(int currentPosition, String currentSituation)
    {
        /*MOVES A PLAYER CHECKING A NUMBER OF CONDITIONS*/
        double diceResult = getDiceResult();
        System.out.println("Dice Result for " + name + " = " + diceResult);
        
      if(100-currentPosition >= diceResult) //this.currentPosition would also work here
      /* 
        the above condition checks if the move is within reach.... 
        For Example : if diceResult is 6 and currentPosition is 98, the move is invalid !
      */
      {
            //IF THE PLAYER HAS GOT 1 AND IS AT HOME, GET HIM/HER OUT FROM HOME
            if(diceResult==1 && currentSituation.equals("stillInHome"))
            {
                currentPosition = (int)(currentPosition + 1.0);
                this.currentPosition = currentPosition;
            }
            //IF THE PLAYER IS OUT FROM HOME AND DICE HAS GOT SOMETHING IN BETWEEN 1-6
            else if(diceResult>=1 && currentSituation.equals("outFromHome"))
            {
                currentPosition = (int)(currentPosition + diceResult);
                this.currentPosition = currentPosition;           
            }
            /*IF THE PLAYER IS AT HOME AND DICE RESULTS SOMETHING OTHER THAN 1,
              THAT PLAYER WILL REMAIN AT HOME*/
            else if(diceResult>1 && currentSituation.equals("stillInHome"))
            {
                currentPosition = (int)(currentPosition + 0.0);
                this.currentPosition = currentPosition;            
            }
             //emergency condition, this condition is never true generally
            else
            {
                currentPosition = 0;
                this.currentPosition = currentPosition;
            }
    }
    
    //IF THE MOVE IS INVALID
    else
    {
            this.currentPosition += 0;
    }
        
    }
    public void climbLadder(int currentPosition, int increaseAmount)
    {        
        /*PLAYER CLIMBS VIA LADDER IN THIS FUNCTION*/
        currentPosition = currentPosition + increaseAmount;
        this.currentPosition = currentPosition;
    }
    public void downViaSnake(int currentPosition, int decreaseAmount)
    {       
        /*PLAYER COMES DOWN VIA SNAKE IN THIS FUNCTION*/
        currentPosition = currentPosition - decreaseAmount;
        this.currentPosition = currentPosition;       
    }
}
