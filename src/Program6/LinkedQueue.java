package Program6;
/*
Program 6 Queue Application
Use a queue to simulate a drive through line.
CS160-03
4/16/2026
@author Asher Plotsky
*/

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedQueue<T> implements QueueInterface<T>, Iterable<T> {
    private LinkedList<T> list;
    public LinkedQueue() {
        list = new LinkedList<T>();
    }
    @Override
    public void enqueue(T newEntry) {
        list.addLast(newEntry);
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (list.isEmpty()) {
            throw new EmptyQueueException();
        }
        return list.removeFirst();
    }

    @Override
    public T getFront() throws EmptyQueueException {
        if (list.isEmpty()) {
            throw new EmptyQueueException(" ");
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }
}
