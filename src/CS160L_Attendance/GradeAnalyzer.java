package CS160L_Attendance;
import java.util.InputMismatchException;
import java.util.Scanner;
public class GradeAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] grades = new int[5];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = input.nextInt();
        }
        try {
            int index = input.nextInt();
            int divisor = input.nextInt();
            System.out.println(grades[index] / divisor);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index");
        }
        catch (ArithmeticException e) {
            System.out.println("Division by zero");
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        }
    }
}
