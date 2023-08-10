package Ch7.Ch7Lvl1.myutil;

public class Student {
    // data members
    private String name;

    // constructors
    public Student() {
        this("Unknown");
    }
    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
