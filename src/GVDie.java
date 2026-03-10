/*
Program 1 Rolling for pair die
Gives random number between 1 and 6.
CS160-03
2/4/2026
@author Asher Plotsky
*/
import java.util.Random;
public class GVDie {
    private int value;
    private Random rand;
    public GVDie(){
        rand = new Random();
        value = 0;
    }
    public void rollDie(){

        value = rand.nextInt(6) + 1;
    }
    public int getValue(){
        return value;
    }
    public void setSeed(int seed){
        rand = new Random(seed);
    }
}
