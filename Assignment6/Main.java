package assignment6;

/*
Reinier Sanders     s4335422
Laurens Kubat       s4626249
*/

/**
 *
 * @author Sjaak Smetsers
 */
public class Main
{
    public static void main(String[] args) {
        int [] game = {2,1,4, 8,3,6, 9,7,5};

        SlidingGame s = new SlidingGame (game);
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
