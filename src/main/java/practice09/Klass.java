package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private final int number;
    private Student leader;
    private List<Student> studentList;

    public Klass(int number) {
        this.number = number;
        this.studentList = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public void assignLeader(Student leader) {
        if(studentList.contains(leader)){
            this.leader = leader;
        }
        else{
            System.out.println("It is not one of us.");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student jerry) {
        studentList.add(jerry);
    }
}
