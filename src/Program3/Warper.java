package Program3; /** Warper class
 * inherits from abstract Racer class
 */

import java.awt.*;
import java.util.Random;
public class Warper extends Racer
{
    private int speed;
    private Random rand;
    /** Default Constructor: calls Racer default constructor
     */
    public Warper( )
    {
        super( );
        setRandAndSpeed();
    }
    /** Constructor
     * @param rID racer Id, passed to Racer constructor
     * @param rX x position, passed to Racer constructor
     * @param rY y position, passed to Racer constructor
     */
    public Warper( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
        setRandAndSpeed();
    }
    /** move: calculates the new x position for the racer
     * Warper move characteristics: "low chance to teleport large distance"
     * rarely increment x by 75
     */
    public void move( )
    {
        int move = rand.nextInt( 100 ) + 1;
        if ( move < speed )
            setX( getX( ) + 75 );
    }
    /** draw: draws the Warper at current (x, y) coordinate
     * @param g Graphics context
     */
    public void draw( Graphics g )
    {
        int startX = getX( );
        int startY = getY( );
        g.setColor( new Color(0, 0, 0) ); // black
//body
        g.fillRect( startX - 30, startY, 30, 20 );

//details
        g.setColor( new Color(81, 32, 218) ); // brown
        g.fillRect( startX - 30, startY + 5, 10, 10 );
        g.fillRect( startX - 10, startY + 5, 10, 10 );
        g.fillRect( startX - 20, startY, 10, 5);
        g.fillRect( startX - 20, startY + 15, 10, 5);
        if (this.isWinner){
            this.morph(g);
        }
    }

    @Override
    public void morph(Graphics g) {
        rand = new Random();
        int randX = rand.nextInt(300);
        int randY = rand.nextInt(300);
        g.setColor( new Color(0, 0, 0) ); // black
//body
        g.fillRect( randX - 30, randY, 30, 20 );

//details
        g.setColor( new Color(81, 32, 218) ); // brown
        g.fillRect( randX - 30, randY + 5, 10, 10 );
        g.fillRect( randX - 10, randY + 5, 10, 10 );
        g.fillRect( randX - 20, randY, 10, 5);
        g.fillRect( randX - 20, randY + 15, 10, 5);
    }

    private void setRandAndSpeed( ) {
// percentage of time (between 1 - 5%) that this warper moves each turn
        rand = new Random( );
        speed = rand.nextInt( 5 ) + 1;
    }
}

