package assignment15;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The train brings a number of passengers to a station in the simulation.
 * 
 * @author Reinier Sanders s4335422
 * @author Laurens Kubat s4626249
 */
public class Train implements Runnable {

    private int nrOfPassengers;
    private final Station station;
    private int doneTrips = 0;
    private final int totalTrips;
    public static final int MIN_TRAVELLERS = 60;
    public static final int MAX_TRAVELLERS = 90;

    public Train(Station station, int totalTrips) {
        this.station = station;
        this.nrOfPassengers = 0;
        this.totalTrips = totalTrips;
    }

    /**
     * Populate this train with number nrOfPassengers
     *
     * @param number the number of passengers of this train
     */
    public void loadPassengers(int number) {
        nrOfPassengers = number;
    }

    /**
     * empties this train and augment the number of Passengers at the station
     * with this nrOfPassenegers
     */
    public void unloadPassengers() {
        doneTrips += 1;
        station.enterStation(nrOfPassengers);
    }

    public void closeStation() {
        station.close();
    }

    public int getNrOfTrips() {
        return doneTrips;
    }

    @Override
    public void run() {
        while (doneTrips < totalTrips) {
            try {
                Thread.sleep(1000);
                loadPassengers(Util.getRandomNumber(MIN_TRAVELLERS, MAX_TRAVELLERS));
                System.out.println();
                System.out.println("Train trip #" + (doneTrips + 1) + ":");
                System.out.println("Train loads " + this.nrOfPassengers + " passengers.");
                unloadPassengers();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        station.close();
    }
}