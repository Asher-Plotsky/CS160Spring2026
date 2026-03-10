/*
Program 1 Racer
Rolls dice until desired roll is achieved.
CS160-03
2/4/2026
@author Asher Plotsky
*/
import java.awt.*;
import java.util.Random;
public class Racer {
    Random rand = new Random();
    final int DEFAULT_X_POS = 50;
    final int DEFAULT_Y_POS = 50;
    String ID;
    int x;
    int y;
    int speed;
    Color color;
    public Racer() {
        ID = "";
        x = DEFAULT_X_POS;
        y = DEFAULT_Y_POS;
        setRandSpeed(160L);
        color = Color.red;
    }
    public Racer(String rID, int rX, int rY) {
        ID = rID;
        x = rX;
        y = rY;
        setRandSpeed(160L);
        color = Color.red;
    }
    public String getID() {
        return ID;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Color getColor() {
        return color;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setRandSpeed(long seed){
        rand = new Random(seed);
        speed = rand.nextInt(10)+90;
    }
    public String toString() {
        return ID + ", " + x + ", " + y + ", " + speed + ", " + color;
    }

}
