package practice11;

import practice10.Person;

public abstract class HasOccupation extends Person {
    public HasOccupation(int id, String name, int age) {
        super(id, name, age);
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
