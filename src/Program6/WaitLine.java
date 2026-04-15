/*
Program 6 Generic Methods
Use Generics
CS160-03
4/7/2026
@author Asher Plotsky
*/
package Program6;

public class WaitLine {
    private QueueInterface<Customer> line;
    private int numberOfArrivals;
    private int numberServed;
    private int totalTimeWaited;
    public WaitLine(){
        reset();
    }
    final public void reset(){
        System.out.println();
        numberOfArrivals = 0;
        numberServed = 0;
        totalTimeWaited = 0;
    }
    public void simulate(int duration, double arrivalProbability, int maxTransactionTime, long seed) throws EmptyQueueException{

    }
    public void displayResults(){
        System.out.print("Served: " + numberServed);
        System.out.print("Wait time: " + totalTimeWaited);
        System.out.print("Average wait time: " + (totalTimeWaited/numberOfArrivals));
        System.out.print("Left in line: " + (numberOfArrivals - numberServed));
    }
}
