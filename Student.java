public class Student extends Person {

    // -------- Encapsulation --------
    private int id;
    private String department;
    private int marks;
    private Grade grade;

    // -------- Constructor --------
    public Student(int id, String name, String department, int marks) {
        super(name); // calling Person constructor
        this.id = id;
        this.department = department;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    // -------- Getters --------
    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public int getMarks() {
        return marks;
    }

    public Grade getGrade() {
        return grade;
    }

    // -------- Setters --------
    public void setMarks(int marks) {
        this.marks = marks;
        this.grade = calculateGrade(); // recalculate grade
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // -------- Grade Calculation --------
    private Grade calculateGrade() {
        if (marks >= 90) {
            return Grade.A;
        } else if (marks >= 75) {
            return Grade.B;
        } else if (marks >= 50) {
            return Grade.C;
        } else {
            return Grade.FAIL;
        }
    }

    // -------- Method Overriding --------
    @Override
    public void display() {
        System.out.println(
            "ID: " + id +
            ", Name: " + name +
            ", Department: " + department +
            ", Marks: " + marks +
            ", Grade: " + grade
        );
    }

    // -------- String Representation --------
    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Department: " + department +
               ", Marks: " + marks +
               ", Grade: " + grade;
    }
}
