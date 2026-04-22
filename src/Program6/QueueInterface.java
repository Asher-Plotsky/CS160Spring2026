package Program6;
/*
Program 6 Queue Application
Use a queue to simulate a drive through line.
CS160-03
4/16/2026
@author Asher Plotsky
*/

import java.util.Iterator;

public interface QueueInterface<T> extends Iterable<T> {
    /**
     * Adds a new entry T to the back of this queue
     * @param newEntry an object to be added.
     */
    public void enqueue(T newEntry);

    /**
     * Removes and returns the entry at the front of this queue.
     * @return The object at the front of this queue.
     * @throws EmptyQueueException if the queue is empty before this operation.
     */
    public T dequeue() throws EmptyQueueException;

    /**
     * Retrieves the object at the front of this queue.
     * @return The object at the front of this queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public T getFront() throws EmptyQueueException;

    /**
     * Detects whether the queue is empty.
     * @return True if queue empty, False otherwise.
     */
    public boolean isEmpty();

    /**
     * Removes all entries from this queue.
     */
    public void clear();

    public Object[] toArray();

    /**
     * Allows the Queue to be Iterated upon
     * @return
     */

    public Iterator<T> iterator();
}
