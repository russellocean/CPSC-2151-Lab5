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
 * Array implementation for the generic queue.
 *
 * @invariant: queueMaxSize > 0
 *
 * @corresponds: max_queue_size = queueMaxSize
 *
 */
public class ArrayDoubleQueue<T> implements IDoubleQueue<T> {
    private T[] queue;
    private int queueMaxSize;
    private int currentSize = 0; // Added this to keep track of current size of the queue.

    /**
     * ArrayDoubleQueueConstructorContact
     * Constructor for the arrayList queue.
     *
     * @param maxSize max size of the array
     * @pre maxSize > 0
     * @post queueMaxSize = maxSize AND self = new Object[queueMaxSize].
     *
     */
    public ArrayDoubleQueue(int maxSize) {
        this.queueMaxSize = maxSize;
        this.queue = (T[]) new Object[queueMaxSize];
    }

    /**
     * enqueueContact
     * Enqueue adds an item to the queue.
     *
     * @param val the item to be added
     * @pre |self| < queueMaxSize
     * @post [self = #self with val added to left-most unoccupied index] AND
     *       queueMaxSize = #queueMaxSize
     *
     */
    @Override
    public void enqueue(T val) {
        if (currentSize < queueMaxSize) {
            queue[currentSize] = val;
            currentSize++;
        }
    }

    @Override
    public T dequeue() {
        if (currentSize == 0) {
            return null; // Queue is empty.
        }
        T firstItem = queue[0];
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

    public T[] getQueue() {
        return this.queue;
    }
}
