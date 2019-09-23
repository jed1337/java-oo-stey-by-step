package practice11;

import java.util.Objects;
import java.util.Optional;

public class Student extends HasOccupation {
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
        klass.appendMember(this);
    }

    public Klass getKlass() {
        return klass;
    }

    public boolean isIn(Klass otherKlass) {
        return otherKlass.getStudentList().contains(this);
    }

    @Override
    protected String occupation() {
        return "Student";
    }

    @Override
    protected String specificDescription() {
        if (isLeader()) {
            return String.format("I am Leader of Class %d", klass.getNumber());
        }
        return String.format("I am at Class %d", klass.getNumber());
    }

    private boolean isLeader() {
        return Optional.ofNullable(klass)
                .map(Klass::getLeader)
                .map(Student::getName)
                .map(name::equals)
                .orElse(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(klass, student.klass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), klass);
    }
}
