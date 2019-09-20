package practice06;

public class Teacher extends Person{
    private Integer klass;

    public Teacher(String name, int age) {
        this(name, age, null);
    }

    public Teacher(String name, int age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    public int getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return String.format("%s I am a Teacher. I teach %s.",super.backIntroduce(), getKlassMessage());
    }

    private String getKlassMessage() {
        if(klass == null){
            return "No Class";
        }
        return "Class " + klass;
    }
}
