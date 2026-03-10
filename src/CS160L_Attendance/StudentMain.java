package CS160L_Attendance;

import java.util.Scanner;
public class StudentMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student student = new Student(input.next(), input.nextInt());
        K12Student student2 = new K12Student(input.next(), input.nextInt(), input.nextInt(), input.nextInt());
        CollegeStudent student3 = new CollegeStudent(input.next(), input.nextInt(), input.nextDouble(), input.next());
        Student[] students = {student, student2, student3};
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }
}
