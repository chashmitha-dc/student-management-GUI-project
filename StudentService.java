import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    // Add student (Method Overloading - version 1)
    public void addStudent(Student student) {
        students.add(student);
    }

    // Add student (Method Overloading - version 2)
    public void addStudent(int id, String name, String dept, int marks) {
        Student s = new Student(id, name, dept, marks);
        students.add(s);
    }

    // View all students (Polymorphism)
    public String viewStudents() {
        if (students.isEmpty()) {
            return "No students available.\n";
        }

        StringBuilder sb = new StringBuilder();
        for (Person p : students) {   // polymorphism
            p.display();              // runtime binding
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    // Delete student by ID
    public void deleteStudent(int id) throws Exception {
        Student toRemove = null;

        for (Student s : students) {
            if (s.getId() == id) {
                toRemove = s;
                break;
            }
        }

        if (toRemove == null) {
            throw new Exception("Student ID not found");
        }

        students.remove(toRemove);
    }

    // Update student marks
    public void updateMarks(int id, int newMarks) throws Exception {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setMarks(newMarks);
                return;
            }
        }
        throw new Exception("Student ID not found");
    }
}

