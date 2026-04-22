package Program6;
/*
Program 6 Queue Application
Use a queue to simulate a drive through line.
CS160-03
4/16/2026
@author Asher Plotsky
*/

public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        System.out.println("Illegal operation on an empty queue");
    }
    public EmptyQueueException(String front) {
        System.out.println("Front not defined in an empty queue");
    }
}
