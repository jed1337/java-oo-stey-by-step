package practice09;

import java.util.Objects;

public class Person {
    protected final int id;
    protected final String name;
    protected final int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String introduce() {
        return backIntroduce("");
    }

    public String backIntroduce(String specificIntroduction){
        return String.format("My name is %s. I am %d years old.%s", name, age, specificIntroduction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
