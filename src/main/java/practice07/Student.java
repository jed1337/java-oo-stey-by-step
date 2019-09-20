package practice07;

public class Student extends HasOccupation {
    public Student(String name, int age, Klass klass) {
        super(name, age, klass);
    }

    @Override
    protected String occupation() {
        return "Student";
    }

    @Override
    protected String specificDescription() {
        return String.format("I am at Class %d", klass.getNumber());
    }
}
