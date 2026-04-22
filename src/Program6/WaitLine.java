package Program6;
/*
Program 6 Queue Application
Use a queue to simulate a drive through line.
CS160-03
4/16/2026
@author Asher Plotsky
*/

import java.util.Random;

public class WaitLine {
    private QueueInterface<Customer> line;
    private int numberOfArrivals;
    private int numberServed;
    private int totalTimeWaited;
    public WaitLine(){
        line = new LinkedQueue();
        reset();
    }
    final public void reset(){
        numberOfArrivals = 0;
        numberServed = 0;
        totalTimeWaited = 0;
        line.clear();
    }
    public void simulate(int duration, double arrivalProbability, int maxTransactionTime, long seed) throws EmptyQueueException{
        Random rand = new Random(seed);
        int clockTime = 0;
        int transactionTimeLeft = 0;
        while(clockTime < duration){
            if(rand.nextDouble() < arrivalProbability){
                numberOfArrivals++;
                int transactionTime = (int) (rand.nextDouble() * maxTransactionTime + 1);
                line.enqueue(new Customer(clockTime, transactionTime, numberOfArrivals));
                System.out.println("Customer " + numberOfArrivals + " enters line at time " + clockTime + ", Transaction time is " + transactionTime);
            }
            if (transactionTimeLeft > 0){
                --transactionTimeLeft;
            }
            else if (!line.isEmpty()){
                Customer nextCustomer = line.dequeue();
                transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
                int waitTime = clockTime - nextCustomer.getArrivalTime();
                totalTimeWaited = totalTimeWaited + waitTime;
                numberServed++;
                System.out.println("Customer " + nextCustomer.getCustomerNumber() + " begins service at time " + clockTime + ". Time waited is " + waitTime);
            }
            clockTime++;
        }
    }
    public void displayResults(){
        System.out.println();
        System.out.println("Number served = " + numberServed);
        System.out.println("Total time waited = " + totalTimeWaited);
        System.out.printf("Average time waited = %.1f\n", (double) totalTimeWaited/numberServed);
        System.out.println("Number left in inline " + (numberOfArrivals - numberServed));
    }
}
