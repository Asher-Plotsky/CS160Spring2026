package CS160LWeek6;

import java.util.ArrayList;

public interface Observer{
    public void registerObserver(ArrayList group, String name);




    public void notifyObservers(ArrayList group);
}
