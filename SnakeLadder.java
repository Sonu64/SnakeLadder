/*
 * A Java class created by Sonu.
 * If you don't know JAVA, then please stay far from it.
 * If you love Computer Science and JAVA, then YOU ARE WELCOME friend !!
 * Thanks to "Java How to Program : Early Objects", by Deitel and Deitel <3
 */
package snake.ladder;

/**
 *
 * @author Sonu
 */
import java.util.Scanner;
public class SnakeLadder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        /* LADDERS in the order -> {<currentPosition>, <increaseAmount>}*/
        int ladders[][] = {
                            {5,43}, {9,21}, {20,19}, {25,33}, {36,59},
                            {41,38}, {69,25}, {64,35}
                          };
        /* SNAKES in the order -> {<currentPosition>, <decreaseAmount>}*/
        int snakes[][] = {
                        {32,24}, {42,26}, {52,41}, {61,58}, {68,64},
                        {82,60}, {89,39}, {93,75}, {97,85}           
                         };
        String p1CurrentSituation = "stillInHome";
        String p2CurrentSituation = "stillInHome";
        
        System.out.println("-----SNAKE-LADDER-GAME-----");
        
        //taking player names and setting them
        System.out.println("Enter Player 1 name : ");
        Player p1 = new Player(in.nextLine(), 1);
        System.out.println("Enter Player 2 name : ");
        Player p2 = new Player(in.nextLine(), 1);
        
        System.out.println("\n\n");
        
        //LOOP UNTIL ONE PLAYER GETS TO 100
        while(p1.getCurrentPosition()<100 && p2.getCurrentPosition()<100)       
        {
            //MOVING PLAYER1
            p1.move(p1.getCurrentPosition(), p1CurrentSituation);
            //IF PLAYER1 GETS OUT FROM HOME, CHANGE HIS/HER CURRENT SITUATION
            if(p1.getCurrentPosition()>1)
            {
                p1CurrentSituation = "outFromHome";
            }
            //CHECK FOR PLAYER1'S LADDERS, IF HE/SHE GETS ONE..CALL climbLadder()
            for(int i=0; i<ladders.length; i++)
            {
                if(p1.getCurrentPosition() == ladders[i][0])
                {
                    System.out.println(p1.getPlayerName() + " got LADDER ! +" + ladders[i][1]);
                    p1.climbLadder(p1.getCurrentPosition(), ladders[i][1]);
                }
            }
            //CHECK FOR PLAYER1'S SNAKES, IF HE/SHE GETS ONE..CALL downViaSnake()
            for(int i=0; i<snakes.length;  i++)
            {
                if(p1.getCurrentPosition() == snakes[i][0])
                {
                    System.out.println(p1.getPlayerName() + " got SNAKE ! -" + snakes[i][1]);
                    p1.downViaSnake(p1.getCurrentPosition(), snakes[i][1]);
                }
            }
            System.out.println("Current Position of p1 : "+p1.getCurrentPosition());       
            
            
            
            
            
            //MOVING PLAYER2
            p2.move(p2.getCurrentPosition(), p2CurrentSituation);
            //IF PLAYER2 GETS OUT FROM HOME, CHANGE HIS/HER CURRENT SITUATION
            if(p2.getCurrentPosition()>1)
            {
                p2CurrentSituation = "outFromHome";
            }
            //CHECKING PLAYER2'S LADDERS, IF HE/SHE GETS ONE..CALL climbLadder()
            for(int i=0; i<ladders.length; i++)
            {
                if(p2.getCurrentPosition() == ladders[i][0])
                {
                    System.out.println(p2.getPlayerName() + " got LADDER ! +" + ladders[i][1]);
                    p2.climbLadder(p2.getCurrentPosition(), ladders[i][1]);
                }
            }
            //CHECKING PLAYER2'S SNAKES, IF HE/SHE GETS ONE..CALL downViaSnake()
            for(int i=0; i<snakes.length;  i++)
            {
                if(p2.getCurrentPosition() == snakes[i][0])
                {
                    System.out.println(p2.getPlayerName() + " got SNAKE ! -" + snakes[i][1]);
                    p2.downViaSnake(p2.getCurrentPosition(), snakes[i][1]);
                }
            }
            System.out.println("Current Position of p2 : "+p2.getCurrentPosition()+"\n");
        }
        
    }
    
}
