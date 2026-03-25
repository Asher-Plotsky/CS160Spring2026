package CS160L_Attendance;
import java.util.LinkedList;
public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        LinkedList reverseList = new LinkedList();
        for (int i = list.size() - 1; i >= 0; i--) {
            reverseList.add(list.get(i));
        }
        System.out.println(list);
        System.out.println(reverseList);
    }
}
