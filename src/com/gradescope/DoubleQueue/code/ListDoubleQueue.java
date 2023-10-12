/*
    Team Members:
    - Nathan Goller-Deitsch
    - Adrian Colaianni
    - Russell Welch
    - Eden Sharp
 */

package com.gradescope.DoubleQueue.code;

import java.util.ArrayList;

/**
 * ListDoubleQueueContract
 *
 * ArrayList implementation for the generic queue.
 *
 * @invariant LQueue != null
 *
 * @corresponds to LQueue as the underlying data structure for the generic queue.
 *
 */
public class ListDoubleQueue<T> implements IDoubleQueue<T> {
    private ArrayList<T> LQueue;
    private int maxListSize;

    /**
     * ListDoubleQueueConstructorContract
     *
     * Constructor for the ListDouble queue.
     *
     * @param maxSize Maximum size of the ListDouble queue.
     *
     * @pre maxSize > 0
     * @post LQueue is initialized AND maxListSize = maxSize
     *
     */
    public ListDoubleQueue(int maxSize) {
        this.LQueue = new ArrayList<T>();
        this.maxListSize = maxSize;
    }

    /**
     * enqueueContract
     *
     * Enqueue adds a value to the queue. If the queue is full, it replaces the last
     * value.
     *
     * @param val The item to be added.
     *
     * @pre val != null
     * @post If |LQueue| < maxListSize, val is added to the end of LQueue.
     *       Otherwise, the last value in LQueue is replaced with val.
     *
     */
    @Override
    public void enqueue(T val) {
        if (LQueue.size() == this.maxListSize)
            LQueue.set(this.maxListSize - 1, val);
        else
            LQueue.add(val);
    }

    // Note: The below 3 functions intentionally do not have contracts. You do not
    // need to add them.

    @Override
    public T dequeue() {
        return LQueue.remove(0);
    }

    @Override
    public int length() {
        return LQueue.size();
    }

    public String toString() {
        String ret = "";
        for (T d : LQueue) {
            ret += ("[" + d + "] ");
        }
        return ret;
    }

}
