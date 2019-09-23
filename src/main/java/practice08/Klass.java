package practice08;

public class Klass {
    private final int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public void assignLeader(Student leader) {
        this.leader = leader;
    }

    public Student getLeader() {
        return leader;
    }
}
