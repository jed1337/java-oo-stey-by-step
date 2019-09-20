package practice07;

public abstract class HasOccupation extends Person {
    protected Klass klass;

    public HasOccupation(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    protected String introduceWithOccupation() {
        return String.format("%s I am a %s", super.backIntroduce(), occupation());
    }

    protected abstract String occupation();
}
