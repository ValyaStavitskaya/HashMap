package students;

import java.util.Arrays;

public class Group {
    public Student[] students;

    public Group() {
        students = new Student[0];
    }

    public void addStudent(String newStudentsSurname) {
        Integer studentsCount = students.length;
        Student[] newStudentsArray = new Student[studentsCount + 1];
        for (int i = 0; i < studentsCount; i++) {
            newStudentsArray[i] = students[i];
        }
        newStudentsArray[studentsCount] = new Student(newStudentsSurname);
        students = newStudentsArray;
    }

    public void print() {
        System.out.println("Surname\tMarks\t\t\t\t\tVisits");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].surname + "\t" + Arrays.toString(students[i].marks) + Arrays.toString(students[i].visits));
        }
    }

    public void deleteStudent(String studentToDelete) {
        Student[] result = new Student[students.length - 1];
        Integer k = 0;
        for (Integer i = 0; i < students.length - 1; i++) {

            if (students[i].surname.equalsIgnoreCase(studentToDelete)) {
                k = 1;
                // Если нашли студента которого нужно удалить, устанавливаем k = 1
                // Чтоб при копировании в новый массив пропустить этого студента
            }

            result[i] = students[i + k];
        }
        students = result;
    }

    public Student findStudent(String surname) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].surname.equalsIgnoreCase(surname))
                return students[i];
        }
        return null;
    }

    public void contains(String surname) {
        if (findStudent(surname) == null)
            System.out.println("Student is not in this group.");
        else
            System.out.println("Student is in a group");
    }

    public void sortStudent() {
        Arrays.sort(students, (a, b) -> a.surname.compareTo(b.surname));
    }

    public void clear() {
        students = new Student[0];
    }


}

