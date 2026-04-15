/*
Program 6 Generic Methods
Use Generics
CS160-03
4/7/2026
@author Asher Plotsky
*/
package Program6;

public interface QueueInterface<T> {
    public void enqueue(T newEntry);
    public void dequeue() throws EmptyQueueException;
    public T getFront() throws EmptyQueueException;
    public boolean isEmpty();
    public void clear();
}
