package CS160L_Attendance;
import java.util.Scanner;
public class VowelCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'a':
                    count++;
                    break;
                case 'A':
                    count++;
                    break;
                case 'e':
                    count++;
                    break;
                case 'E':
                    count++;
                case 'i':
                    count++;
                    break;
                case 'I':
                    count++;
                    break;
                case 'o':
                    count++;
                    break;
                case 'O':
                    count++;
                    break;
                case 'u':
                    count++;
                    break;
                case 'U':
                    count++;
                    break;
                default:
                    break;
            }
        }
        System.out.println(count);
    }
}
