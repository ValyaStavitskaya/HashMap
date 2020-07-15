package students;

public class Student {
    final static int NUM_OF_LESSONS = 7;
    String surname;
    boolean[] visits;
    int[] marks;

    public Student(String surname){
        this.surname = surname;
        this.visits = new boolean[NUM_OF_LESSONS];
        this.marks = new int[NUM_OF_LESSONS];
    }
    public void setMarks(int mark, int lessonNum) {
        marks[lessonNum - 1] = mark;
    }

    public void setVisits(boolean visit, int lessonNum) { visits[lessonNum - 1] = visit;
    }

    @Override
    public String toString() {
        return surname;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null|| obj.getClass()!=this.getClass())
            return false;
        Student student = (Student) obj;
        return surname!=null ? surname.equals(student.surname) : student.surname == null;
    }
}







