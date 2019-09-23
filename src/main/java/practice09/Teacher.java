package practice09;

import java.util.Objects;

public class Teacher extends HasOccupation {
    public Teacher(int id, String name, int age) {
        this(id, name, age, null);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age, klass);
    }

    public String introduceWith(Student student) {
        return backIntroduce(String.format(" %s. I %s %s.",
                introduceOccupation(), teachVerb(student), student.getName()));
    }

    private String teachVerb(Student student) {
        if(sameKlass(student)){
            return "teach";
        }
        return "don't teach";
    }

    private boolean sameKlass(Student student) {
        return Objects.equals(student.getKlass(), this.klass);
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
        if(klass == null){
            return "No Class";
        }
        return "Class " + klass.getNumber();
    }
}
