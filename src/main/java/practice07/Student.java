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
    public String introduce() {
        return String.format("%s. I am at Class %d.",introduceWithOccupation(), klass.getNumber());
    }
}
