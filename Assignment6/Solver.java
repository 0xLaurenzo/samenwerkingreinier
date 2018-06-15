
import java.util.*;


/**
 * A class that implements a breadth-first search algorithm
 * for finding the Configurations for which the isSolution predicate holds
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.5
 * @date 25-02-2017
 */
public class Solver
{
   // A queue for maintaining graphs that are not visited yet.
    Queue<Configuration> toExamine;
    Collection<Configuration> seen;

    public Solver( Configuration g ) {
        this.toExamine = new PriorityQueue<>();
        this.seen = new HashSet<>();
        this.toExamine.add(g);
        this.seen.add(g);
        
    }

    /**
     * A skeleton implementation of the solver
     *
     * @return a string representation of the solution
     */
    public String solve() {
        while ( ! toExamine.isEmpty() ) {
            Configuration next = toExamine.remove();
            if ( next.isSolution() ) {
                List<Configuration> a = next.pathFromRoot();
                for (int i = 0; i < a.size(); i++) {
                    System.out.println(a.get(i).toString());
                }
                return "Success! \n" + next.toString();
            } else {
                for ( Configuration succ : next.successors() ) {
                    if (!seen.contains(succ)){
                        toExamine.add(succ);
                        seen.add(succ);
                    }
                }
            }                    

        }
        return "Failure!";
    }
    
}
