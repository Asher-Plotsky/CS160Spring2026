package Program3; /** Cannon class
 * inherits from abstract Racer class
 */

import java.awt.*;

public class Cannon extends Racer
{
    private int startingX;
    private int startingY;
    /** Default Constructor: calls Racer default constructor
     */
    public Cannon( )
    {
        super( );
    }
    /** Constructor
     * @param rID racer Id, passed to Racer constructor
     * @param rX x position, passed to Racer constructor
     * @param rY y position, passed to Racer constructor
     */
    public Cannon( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
        startingX = rX;
        startingY = rY;
    }
    /** move: calculates the new x position for the racer
     * Cannonball move characteristics Cannonball jumps 3 pixels
     */
    public void move( )
    {
        setX( getX() + 3);
    }
    /** draw: draws the Cannonball at current (x, y) coordinate
     * @param g Graphics context
     */
    public void draw( Graphics g )
    {
        int startY = getY( );
        int startX = getX( );
//ball
        g.setColor( Color.GRAY );
        g.fillOval( startX - 30, startY, 30, 20 );
//shine
        g.setColor( Color.LIGHT_GRAY );
        g.fillOval( startX - 10, startY + 3, 5, 5 ) ;
//cannon
        g.setColor( Color.darkGray);
        g.fillRect( startingX - 40, startingY, 40, 30);
        if(this.isWinner){
            this.morph(g);
        }
    }

    @Override
    public void morph(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(this.getX() - 40, this.getY() - 15, 50, 50);
        g.setColor(Color.orange);
        g.fillOval(this.getX() - 30, this.getY() - 2, 30, 30);
    }
}
