/*
Program 6 Generic Methods
Use Generics
CS160-03
4/7/2026
@author Asher Plotsky
*/
package Program6;

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
