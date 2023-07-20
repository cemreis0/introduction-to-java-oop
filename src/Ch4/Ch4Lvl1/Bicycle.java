/*
Chapter 4 Exercise 10

Modify the Bicycle class so instead of assigning the name of an owner
(Student), you can assign the owner object itself. Model this new Bicycle
class after the LibraryCard class.
*/

package Ch4.Ch4Lvl1;

public class Bicycle {
    // data members
    private Student owner; // student owner of this bicycle
    private int bicycleTagNo; // tag no of the bicycle of this student

    // constructor
    public Bicycle(int tagNo) {
        owner = null; // a Bicycle can have no owner
        bicycleTagNo = tagNo; // a bicycle must have a tag no
    }

    // main method
    public static void main(String[] args) {
        // sample

        // Student instance
        Student student = new Student("Cem Reis", "cemmreis@gmail.com");

        // Bicycle object
        Bicycle bicycle = new Bicycle(1);

        // set an owner to the bicycle
        bicycle.setOwner(student);

        // print out the bicycle's info
        System.out.println(
                "Bicycle Registration" + "\n" +
                "Owner:  " + bicycle.getOwner().getName() + "\n" +
                "Tag No: " + bicycle.getBicycleTagNo()
                );

    }

    // returns the owner of this bicycle
    public Student getOwner() {
        return owner;
    }

    // returns the tag no of this bicycle
    public int getBicycleTagNo() {
        return bicycleTagNo;
    }

    // assigns the owner to this bicycle
    public void setOwner(Student student) {
        owner = student;
    }
}

class Student {
    // data members
    private String name;
    private String email;

    // constructor
    public Student(String studentName, String studentEmail) {
        name = studentName;
        email = studentEmail;
    }

    // main method
    public static void main(String[] args) {

    }

    // returns the email of this student
    public String getEmail() {
        return email;
    }

    // returns the name of this student
    public String getName() {
        return name;
    }

    // assigns the email to this student
    public void setEmail(String emailAddress) {
        email = emailAddress;
    }

    // assigns the name to this student
    public void setName(String studentName) {
        name = studentName;
    }
}