package practice09;

import java.util.Optional;

public class Student extends HasOccupation {
    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age, klass);
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
}
