import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.3
 * @date 07-03-2016
 * A template implementation of a sliding game 
 * implementing the Graph interface
 */
public class SlidingGame implements Configuration {

    public static final int N = 3, SIZE = N * N, HOLE = SIZE;
    /**
     * The board is represented by a 2-dimensional array; the position of the
     * hole is kept in 2 variables holeX and holeY
     */
    private int[][] board;
    private int holeX, holeY;
    private SlidingGame parent;
    

    /**
     * A constructor that initializes the board with the specified array
     *
     * @param start: a one dimensional array containing the initial board. The
     * elements of start are stored row-wise.
     */
    public SlidingGame(int[] start) {
        board = new int[N][N];

        assert start.length == N * N : "Length of specified board incorrect";
        this.parent = null;
        for (int p = 0; p < start.length; p++) {
            board[p % N][p / N] = start[p];
            if (start[p] == HOLE) {
                holeX = p % N;
                holeY = p / N;
            }
        }
    }
    
    public SlidingGame(SlidingGame parent) {
        this.parent = parent;
        this.board = new int[N][N];
        this.holeX = parent.holeX;
        this.holeY = parent.holeY;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.board[i][j] = parent.board[i][j];
            }
        }
    }
    
    public int getCord(int xCord, int yCord){
        return board[xCord][yCord];
    }

    /**
     * Converts a board into a printable representation. The hole is displayed
     * as a space
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int puzzel = board[col][row];
                buf.append(puzzel == HOLE ? "  " : puzzel + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof SlidingGame)) {
            throw new RuntimeException("Object type mismatch.");
        } else {
            SlidingGame other = (SlidingGame) o;
            for(int row = 0; row < N; row++) {
                for(int col = 0; col < N; col++) {
                    if(this.board[col][row] != other.board[col][row])
                        return false;
                }
            }
            return true;
        }
    }

    
    @Override
    public boolean isSolution() {
        for(int i = 0; i < SIZE; ++i) {
            int x = i % N;
            int y = i / N;
            if(board[x][y] != i + 1) {
                return false;
            }
        }
        return true;
    }
    
    public SlidingGame swap(int holeX, int holeY, int newX, int newY){
        SlidingGame buf = new SlidingGame(this);
        buf.board[holeX][holeY] = buf.board[newX][newY];
        buf.board[newX][newY] = HOLE;
        buf.holeX = newX;
        buf.holeY = newY;
        return buf;
    }

    @Override
    public Collection<Configuration> successors() {
       Collection<Configuration> successors = new ArrayList<>();
       // swap to left
       if (this.holeX > 0) {
           SlidingGame toAdd = this.swap(this.holeX , this.holeY, this.holeX - 1, this.holeY);
           successors.add(toAdd);
       }
       // swap to north/up
       if (holeY > 0) {
            SlidingGame toAdd = this.swap(this.holeX , this.holeY, this.holeX, this.holeY - 1);
           successors.add(toAdd);
       }
       //swap to right
       if (holeX < N - 1) {
           SlidingGame toAdd = this.swap(this.holeX , this.holeY, this.holeX + 1, this.holeY);
           successors.add(toAdd);
       }
       //swap to down/south
       if (holeY < N - 1) {
           SlidingGame toAdd = this.swap(this.holeX , this.holeY, this.holeX, this.holeY + 1);
           successors.add(toAdd);
       }
       return successors;
   }
    
    public int getPriority() {
        int priority = 0;
        int elementValue = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                priority += elementValue - this.board[j][i] ;
                elementValue++;
            }
        }
        return priority;
    }
    
    @Override
    public int compareTo(Configuration g) {
        int priority;
        if (!(g instanceof SlidingGame)) {
            throw new RuntimeException("Object Type mismatch");
        } else {
            priority = this.getPriority() - ((SlidingGame) g).getPriority();
            }
        return priority;
    }

    @Override
    public Configuration parent() {
        return this.parent;
    }

    @Override
    public List<Configuration> pathFromRoot() {
        List<Configuration> path = new ArrayList<>();
        path.add(this);
        SlidingGame aParent = this.parent;
        while ( aParent != null) {
            path.add(aParent);
            aParent = aParent.parent;
        }
        Collections.reverse(path);
        return path;
    }
    
    

}
