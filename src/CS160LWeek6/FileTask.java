package CS160LWeek6;

public class FileTask extends TaskProcessor{
    public FileTask() {

    }
    @Override
    public void processTask() {
        System.out.println("Processing File Task");
    }
    public void runTask() {
        this.startTask();
        this.processTask();
        this.endTask();
    }
}
