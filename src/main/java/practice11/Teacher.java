package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends HasOccupation implements Observer{
    protected List<Klass> klasses;

    public Teacher(int id, String name, int age) {
        this(id, name, age, new ArrayList<>());
    }

    public Teacher(int id, String name, int age, List<Klass> klasses) {
        super(id, name, age);
        this.klasses = klasses;

        for (Klass klass : this.klasses) {
            klass.addObserver(this);
        }
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
        if (klasses.isEmpty()) {
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

    @Override
    public void update(String message) {
        System.out.println(String.format("I am %s. I know %s.", name, message));
    }
}
