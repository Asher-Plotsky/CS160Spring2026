/*
Program 1 Rolling for pair roller
Rolls dice until desired roll is achieved.
CS160-03
2/4/2026
@author Asher Plotsky
*/
import java.util.Scanner;
public class RollPair {

    public static int rollingForPair(GVDie a, GVDie b, int x){
        int rolls = 0;

        while (a.getValue() != x || b.getValue() != x){
            rolls++;
            a.rollDie();
            b.rollDie();
        }
        return rolls;
    }
    public static void main(String[] args){
        GVDie die1 = new GVDie();
        GVDie die2 = new GVDie();
        Scanner input = new Scanner(System.in);
        int  x = input.nextInt();
        int total = rollingForPair(die1, die2, x);
        System.out.println("It took " + total + " rolls to get a pair of " + x + "'s.");
    }

}
