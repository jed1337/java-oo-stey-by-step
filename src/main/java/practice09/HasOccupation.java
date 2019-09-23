package practice09;

public abstract class HasOccupation extends Person {
    protected Klass klass;

    public HasOccupation(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return backIntroduce(String.format(" %s. %s.", introduceOccupation(), specificDescription()));
    }

    protected String introduceOccupation(){
        return String.format("I am a %s", occupation());
    }

    protected abstract String occupation();

    protected abstract String specificDescription();
}
