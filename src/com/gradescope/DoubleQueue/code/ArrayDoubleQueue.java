/*
            Team Members:
            - Nathan Goller-Deitsch
            - Adrian Colaianni
            - Russell Welch
            - Eden Sharp
         */

        package com.gradescope.DoubleQueue.code;

/**
 * ArrayDoubleQueueContract
 * Array implementation for the Double queue.
 *
 * @invariant: queueMaxSize > 0
 *
 * @corresponds: max_queue_size = queueMaxSize
 *
 */
public class ArrayDoubleQueue implements IDoubleQueue {
    private Double[] queue;
    private int queueMaxSize;
    private int currentSize = 0; // Added this to keep track of current size of the queue.

    /**
     * ArrayDoubleQueueConstructorContact
     * Constructor for the arrayListDouble queue.
     *
     * @param maxSize max size of the array
     * @pre maxSize > 0
     * @post queueMaxSize = maxSize AND self = new Double[queueMaxSize].
     *
     */
    public ArrayDoubleQueue(int maxSize) {
        this.queueMaxSize = maxSize;
        this.queue = new Double[queueMaxSize];
    }

    /**
     * enqueueContact
     * Enqueue adds an item to the queue.
     *
     * @param val the Double to be added
     * @pre |self| < queueMaxSize
     * @post [self = #self with val added to left-most unoccupied index] AND
     *       queueMaxSize = #queueMaxSize
     *
     */
    @Override
    public void enqueue(Double val) {
        if (currentSize < queueMaxSize) {
            queue[currentSize] = val;
            currentSize++;
        }
    }

    @Override
    public Double dequeue() {
        if (currentSize == 0) {
            return null; // Queue is empty.
        }
        Double firstItem = queue[0];
        // Shift all elements to the left.
        for (int i = 1; i < currentSize; i++) {
            queue[i - 1] = queue[i];
        }
        currentSize--;
        queue[currentSize] = null; // Clear the last item since it's dequeued.
        return firstItem;
    }

    @Override
    public int length() {
        return currentSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentSize; i++) {
            sb.append("[").append(queue[i]).append("]");
            if (i != currentSize - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // -----------------Ignore the functions below this line-----------------------
    public int getQueueMaxSize() {
        return this.queueMaxSize;
    }

    public Double[] getQueue() {
        return this.queue;
    }
}
