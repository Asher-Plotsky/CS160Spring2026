package Program6;

public class Driver {
    public static void main(String[] args) throws EmptyQueueException {
        WaitLine line = new WaitLine();
        line.simulate(20, 0.5, 5, 6);
        line.displayResults();
    }
}
