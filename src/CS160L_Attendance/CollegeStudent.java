package CS160L_Attendance;

public class CollegeStudent extends Student {
    private double gpa;
    private String year;
    public CollegeStudent(String name, int age, double gpa, String year) {
        super(name, age);
        this.gpa = gpa;
        this.year = year;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(int gpa) {
        this.gpa = gpa;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String toString(){
        String value = super.toString();
        value += ", GPA" + gpa + ", Year " + year;
        return value;
    }
}
