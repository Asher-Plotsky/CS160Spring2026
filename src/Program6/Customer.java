package Program6;
/*
Program 6 Queue Application
Use a queue to simulate a drive through line.
CS160-03
4/16/2026
@author Asher Plotsky
*/

public class Customer {
    private int arrivalTime;
    private int transactionTime;
    private int customerNumber;
    public Customer(int arrivalTime, int transactionTime, int customerNumber) {
        this.arrivalTime = arrivalTime;
        this.transactionTime = transactionTime;
        this.customerNumber = customerNumber;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getTransactionTime() {
        return transactionTime;
    }
    public int getCustomerNumber() {
        return customerNumber;
    }
}
