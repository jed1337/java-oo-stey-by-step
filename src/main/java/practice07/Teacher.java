package practice07;

import java.util.Objects;

public class Teacher extends HasOccupation {
    public Teacher(String name, int age) {
        this(name, age, null);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age, klass);
    }

    @Override
    public String introduce() {
        return String.format("%s. I teach %s.",introduceWithOccupation(), getKlassMessage());
    }

    private String getKlassMessage() {
        if(klass == null){
            return "No Class";
        }
        return "Class " + klass.getNumber();
    }

    public String introduceWith(Student student) {
        return String.format("%s. I %s %s.", introduceWithOccupation(), teachVerb(student), student.getName());
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

}
