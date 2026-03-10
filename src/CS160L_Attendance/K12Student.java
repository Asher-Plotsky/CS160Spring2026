package CS160L_Attendance;

public class K12Student extends Student {
    private int grade;
    private int gradeLevel;
    public K12Student(String name, int age, int grade,  int gradeLevel) {
        super(name, age);
        this.grade = grade;
        this.gradeLevel = gradeLevel;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public int getGradeLevel() {
        return gradeLevel;
    }
    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    public String toString() {
        String value = super.toString();
        value += ", Grade " + grade + ", Grade level " + gradeLevel;
        return value;
    }
}
