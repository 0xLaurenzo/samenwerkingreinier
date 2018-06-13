package assignment15;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that holds the number of persons arriving by train at the station and
 * is waiting for a taxi.
 * 
 * @author Reinier Sanders s4335422
 * @author Laurens Kubat s4626249
 */
public class Station {

    private int nrOfPassengersAtStation = 0;
    private int totalNrOfPassengers = 0;
    private boolean isClosed = false;
    private Taxi[] taxis;
    private Lock lock = new ReentrantLock();
    private Simulation sim;
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public Station(Taxi[] taxis, Simulation s) {
        this.taxis = taxis;
        this.sim = s;
    }

    /* This class fixes the locks and conditions between the taxis and the train.
    When a train enters the station, or a taxi leaves the station, myLock gets locked. 
    When the function ends, the lock will be opened again, so that another threat can use the function.
    The condition empty "works" for the train. When there are still people at the train, the train has to wait.
    Otherwise, it will be notified that it can get more people to the station.
    The full condition is for the taxis, it will be put to await when there are no people to carry from the station. 
     */
    public void enterStation(int nrOfPassengers) {
        lock.lock();
        try {
            if (nrOfPassengersAtStation != 0) {
                try {
                    empty.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Station.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            nrOfPassengersAtStation += nrOfPassengers;
            totalNrOfPassengers += nrOfPassengers;
            System.out.println(nrOfPassengers + " passengers arrived at station.");
            System.out.println();
            full.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Ask for nrOfPassengers Passengers to leave the station
     *
     * @param nrOfPassengers
     */
    public void leaveStation(int nrOfPassengers) {
        lock.lock();
        try {
            if (nrOfPassengersAtStation == 0) {
                full.await();
            }
            nrOfPassengersAtStation -= nrOfPassengers;
            if (nrOfPassengers == 0) {
                empty.signalAll();
            }
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(Station.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }

    public int getWaitingPassengers() {
        lock.lock();
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(Station.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
        return nrOfPassengersAtStation;
    }

    public void close() {
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }

    public void done() {
        sim.showStatistics();
    }
}
