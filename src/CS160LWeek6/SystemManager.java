package CS160LWeek6;

public class SystemManager {
    private static SystemManager instance = new SystemManager();
    private SystemManager(){

    }
    public static SystemManager getInstance(){
        return instance;
    }
}
