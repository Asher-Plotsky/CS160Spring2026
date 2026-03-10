package CS160LWeek6;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskSystem implements Observer {
    public static void main(String[] args) {
        TaskSystem taskSystem = new TaskSystem();
        FileTask fileTask = new FileTask();
        ArrayList observers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int users = input.nextInt();
        for (int i = 0; i < users; i++) {
            taskSystem.registerObserver(observers, input.next());
        }
        fileTask.runTask();
        taskSystem.notifyObservers(observers);

    }


    @Override
    public void registerObserver(ArrayList group, String name) {
        group.add(name);
    }

    @Override
    public void notifyObservers(ArrayList group) {
        for (int i = 0; i < group.size(); i++) {
            System.out.println("Notifying user " + group.get(i));
        }
    }
}
