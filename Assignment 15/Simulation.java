package assignment15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simulations of a train bringing passengers to a station.
 * The passengers leave the station by one of the taxis.
 * 
 * @author Reinier Sanders s4335422
 * @author Laurens Kubat s4626249
 */
public class Simulation {

    /**
     * Constants for the size of the simulation
     */
    public static final int TRAIN_TRIPS = 10;
    public static final int MIN_TRAVELLERS = 60;
    public static final int MAX_TRAVELLERS = 90;
    public static final int CAPACITY_SMALL = 4;
    public static final int CAPACITY_LARGE = 7;
    public static final int TIME_SMALL = 2;
    public static final int TIME_LARGE = 3;
    public static final int NR_OF_TAXIS = 4;
    public static final int NR_OF_SMALL_TAXIS = 2;

    /**
     * main elements of the simulation
     */
    private final Taxi[] taxis;
    private final Train train;
    private final Station station;

    /**
     * hasEnded: is the simulation finished? nextTaxi: number of the taxi to be
     * use in next step
     */
    private final boolean hasEnded = false;
    private final int nextTaxi = 0;

    /**
     * Constructor: create station and small and large taxis
     */
    public Simulation() {
        taxis = new Taxi[NR_OF_TAXIS];
        station = new Station(taxis, this);
        for (int i = 0; i < NR_OF_TAXIS; i++) {
            taxis[i] = i < NR_OF_SMALL_TAXIS
                    ? new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station)
                    : new Taxi(i + 1, CAPACITY_LARGE, TIME_LARGE, station);
        }
        train = new Train(station, TRAIN_TRIPS);

    }

    /**
     * simulation step: if there are passengers load them in a taxi, otherwise
     * let a train bring new passengers, or indicate that simulation stops
     */
    public void step() {
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(train);
        for (Taxi i : taxis) {
            ex.execute(i);
        }
        try {
            Thread.sleep(30000);
            showStatistics();
        } catch (InterruptedException ex1) {
            Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex1);
        }
        ex.shutdown();
    }

    public boolean ended() {
        return hasEnded;
    }

    public void showStatistics() {
        System.out.println();
        System.out.println("All people have been transported.");
        System.out.println("Total transport time in this simulation: " + getTotalTime(taxis));
        System.out.println("Total number of train travelers: " + station.getTotalNrOfPassengers());
        System.out.println("Total number of people transported in this simulation: " + getTotalNrOfPassengers(taxis));
    }

    /**
     * Calculates the total time of the simulation by looping over all taxis
     *
     * @param taxis
     * @return total time
     */
    private static int getTotalTime(Taxi[] taxis) {
        int time = 0;
        for (Taxi taxi : taxis) {
            time += taxi.getTotalTransportationTime();
        }
        return time;
    }

    /**
     * Calculates the total number of passengers that has been transported by
     * looping over all taxis
     *
     * @param taxis
     * @return total number of passengers
     */
    private static int getTotalNrOfPassengers(Taxi[] taxis) {
        int total = 0;
        for (Taxi taxi : taxis) {
            total += taxi.getTotalNrOfPassengers();
        }
        return total;
    }
}
