/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Laurens
 *
 * this buffer is implemented using a first in first out queue
 */
public class Buffer<E> {

    private E[] items;
    private int size;
    private int head;
    private int tail;
    private int amount;
    private Lock itemsLock;
    private Condition full;
    private Condition empty;

    public Buffer(int size) {
        this.items = (E[])new Object[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.amount = 0;
        this.itemsLock = new ReentrantLock();
    }

    public void put(E toPut) throws InterruptedException {
        itemsLock.lock();
        try {
            while (amount == items.length){
                full.await();
            }
            this.items[tail] = toPut;
            tail = (tail + 1) % size;
            amount++;
            empty.signal();
        } finally {
            itemsLock.unlock();
        }
    }

    public E get() throws InterruptedException {
        itemsLock.lock();
        try {
            while(amount == 0) {
                empty.await();
            }
            E retBuf = items[head];
            head = (head + 1) % size;
            amount--;
            full.signal();
            return retBuf;
        } finally {
            itemsLock.unlock();
        }
    }
}
