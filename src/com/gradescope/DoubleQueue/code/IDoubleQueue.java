/*
    Team Members:
    - Nathan Goller-Deitsch
    - Adrian Colaianni
    - Russell Welch
    - Eden Sharp
 */

package com.gradescope.DoubleQueue.code;

/**IDoubleQueueContract
 * @param <T> the Type tha the queue works with.
 *
 *
 *@initialization Ensures: self != null
 *
 *@defines: self: Object
 *
 *@constraints: The queue is initialized and is empty
 *
 */
public interface IDoubleQueue<T>
{

    //This function's contracts are in the individual classes
    public void enqueue(T val);

    /**dequeueContract
    *
    *@return The first element in the queue
    *@pre The queue is not empty
    *@post The first element in the queue is removed and returned
    */
    public T dequeue();

    /**lengthContract
     *
     * Returns the number of items in the queue.
     *
     * @return The number of items in the queue.
     * @pre None.
     * @post result = number of items in the queue.
     */
    public int length();

    /**peekContract
     *
     * Returns the number of items in the queue.
     *
     * @return The item at the front of the list
     * @pre None.
     * @post The first element in the queue is only returned. The entire queue object is unchanged.
     */
    default T peek() {
        T temp = dequeue();
        enqueue(temp);
        for (int i = 0; i < length() - 1;i++) {
            enqueue(dequeue());
        }
        return temp;
    }

    /**toStringContract
     *
     * Print the status of the queue to the command line.
     *
     *@return representation of the queue as a string
     *
     *@pre None
     *
     *@post None
     *
     */
    public String toString();
}
