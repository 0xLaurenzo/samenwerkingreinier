import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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

    /**
     * A constructor that initializes the board with the specified array
     *
     * @param start: a one dimensional array containing the initial board. The
     * elements of start are stored row-wise.
     */
    public SlidingGame(int[] start) {
        board = new int[N][N];

        assert start.length == N * N : "Length of specified board incorrect";

        for (int p = 0; p < start.length; p++) {
            board[p % N][p / N] = start[p];
            if (start[p] == HOLE) {
                holeX = p % N;
                holeY = p / N;
            }
        }
    }
    
    public SlidingGame swap(int holeX, int holeY, int newX, int newY){
        int buf = board[holeX][holeY];
        board[holeX][holeY] = board[newX][newY];
        board[newX][newY] = buf;
        ArrayList<Integer> retList = new ArrayList<Integer>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                retList.add(board[i][j]);
            }
        }
        int[] result = new int[retList.size()];
        int index = 0;
        for(int val:retList){
            result[index++] = val;
        }
        return new SlidingGame(result);
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
        throw new UnsupportedOperationException("equals : not supported yet.");
    }

    @Override
    public boolean isSolution() {
        int counter = 1;
        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] != counter){
                    return false;
                }
                counter++;
            }
        }
        return true;
    }

    @Override
    public Collection<Configuration> successors() {
       ArrayList retList = new ArrayList();  
       for (Direction dir : Direction.values()){
            retList.add(this.swap(holeX, holeY, dir.GetDX(), dir.GetDY()));
        }
        return retList;
    }

    @Override
    public int compareTo(Configuration g) {
        throw new UnsupportedOperationException("compareTo : not supported yet.");
    }

    @Override
    public Configuration parent() {
        throw new UnsupportedOperationException("parent : not supported yet.");
    }

}
