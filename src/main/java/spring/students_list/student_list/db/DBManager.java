package spring.students_list.student_list.db;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Long id = 6L;

    static {
        students.add(new Student(1L, "Bexultan", "Kuralbay", 49, "F"));
        students.add(new Student(2L, "Asylhan", "Abdiashim", 60,"C"));
        students.add(new Student(3L, "Ersultan", "Nurmakhanbetov", 70, "C"));
        students.add(new Student(4L, "Bekzat", "Rakhman", 90, "A"));
        students.add(new Student(5L, "Bekzat", "Kudaibergen", 75, "B"));
    }

    public static ArrayList<Student> getStudents(){
        return students;
    }

    public static void addStudent(Student student){
        student.setId(id);
        students.add(student);
        id++;
    }
}
