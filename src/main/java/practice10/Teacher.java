package practice10;

import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends HasOccupation {
    protected List<Klass> klasses;

    public Teacher(int id, String name, int age) {
        this(id, name, age, null);
    }

    public Teacher(int id, String name, int age, List<Klass> klass) {
        super(id, name, age);
        this.klasses = klass;
    }

    public String introduceWith(Student student) {
        return backIntroduce(String.format(" %s. I %s %s.",
                introduceOccupation(), teachVerb(student), student.getName()));
    }

    private String teachVerb(Student student) {
        if (isTeaching(student)) {
            return "teach";
        }
        return "don't teach";
    }

    public List<Klass> getClasses() {
        return klasses;
    }

    @Override
    protected String occupation() {
        return "Teacher";
    }

    @Override
    protected String specificDescription() {
        return String.format("I teach %s", getKlassMessage());
    }

    private String getKlassMessage() {
        if (klasses == null) {
            return "No Class";
        }
        return "Class " + getKlassNumbers();
    }

    private String getKlassNumbers() {
        return klasses.stream()
                .map(Klass::getNumber)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public boolean isTeaching(Student student) {
        return klasses.contains(student.getKlass());
    }
}
