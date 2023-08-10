package Ch7.Ch7Lvl1.myutil;

public class Person {
    // data members
    private String name;

    // constructors
    public Person(){
        name = "Unknown";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}