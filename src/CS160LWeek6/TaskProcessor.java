package CS160LWeek6;

public abstract class TaskProcessor {
    public void startTask(){
        System.out.println("Task Started");
    }
    public abstract void processTask();
    public void endTask(){
        System.out.println("Task Completed");
    }
}
