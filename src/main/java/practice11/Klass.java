package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass implements Observable{
    private final int number;
    private Student leader;
    private List<Student> studentList;

    private List<Observer> observers;

    public Klass(int number) {
        this.number = number;
        this.studentList = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void assignLeader(Student leader) {
        if(studentList.contains(leader)){
            this.leader = leader;
            updateObservers(String.format("%s become Leader of Class %d",
                    leader.getName(),
                    this.getNumber()));
        }
        else{
            System.out.println("It is not one of us.");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        studentList.add(student);
        updateObservers(String.format("%s has joined Class %d",
                student.getName(),
                this.getNumber()));
    }

    private void updateObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number &&
                Objects.equals(leader, klass.leader) &&
                Objects.equals(studentList, klass.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, leader, studentList);
    }
}
