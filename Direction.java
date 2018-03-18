/**
 * @author Sjaak Smetsers
 * @version 1.2
 * @date 28-02-2015
 * 
 * An enumeration type for the 4 points of the compass 
 * Each constant has 2 (final) int attributes indicating
 * the displacement of each direction on a 2-dimensional grid 
 * of which the origin is located in the upper left corner
 */
public enum Direction
{
    NORTH (0,-1), EAST (1,0), SOUTH(0,1), WEST(-1,0);
    
    private final int dx, dy;
    private Direction (int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
    
    public int GetDX () {
        return dx;
    }

    public int GetDY () {
        return dy;
    }
}

