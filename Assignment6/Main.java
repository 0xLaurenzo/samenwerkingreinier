import java.util.List;

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
        int [] game = {2,1,4, 8,3,6, 9,5,7};

        SlidingGame s = new SlidingGame (game);
        System.out.println(s);
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}