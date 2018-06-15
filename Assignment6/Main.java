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
        int [] game = {1,2,3, 4,5,8, 7,9,6};

        SlidingGame s = new SlidingGame (game);
        System.out.println(s);
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}