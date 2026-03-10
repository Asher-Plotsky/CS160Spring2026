package CS160L_Attendance;
import java.util.Scanner;

public class StringCompressor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String compressedstr = "";
        for (int i = 0; i < str.length();  i++) {
            int count = 1;
            compressedstr += str.charAt(i);
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1) ) {
                count++;
                i++;
            }
            compressedstr += count;
        }
        System.out.println(compressedstr);
    }
}
