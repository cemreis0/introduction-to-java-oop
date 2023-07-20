package Ch4.Student;

public class Student {
    public static void main(String[] args) {
        // declare and create the LibraryCard and Student objects
        LibraryCard lc = new LibraryCard();
        Student st = new Student();

        // assign values to the LibraryCard object
        st.setName("Cem Reis");
        st.setEmail("cemmreis@gmail.com");
        lc.setOwner(st);
        lc.checkOut(12);
        lc.checkOut(124);

        System.out.println(lc.toString());
        librarian();
    }

    // data members
    private String name;
    private String email;

    // constructor
    public Student() {
        name = "Unassigned";
        email = "Unassigned";
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
    public static void librarian() {
        // creating two LibraryCard objects with the same owner
        Student student;
        LibraryCard card1, card2;

        student = new Student();
        student.setName("Cem Reis");
        student.setEmail("cemmreis@gmail.com");

        card1 = new LibraryCard();
        card1.setOwner(student);
        card1.checkOut(12);

        card2 = new LibraryCard();
        card2.setOwner(student);
        card2.checkOut(7);

        System.out.println(card1.toString());
        System.out.println(card2.toString());
    }
}

class LibraryCard {
    // data members
    private Student owner; // student owner of this card
    private int borrowCnt; // number of books borrowed

    // constructor
    public LibraryCard() {
        owner = null;
        borrowCnt = 0;
    }

    // numOfBooks are checked out
    public void checkOut(int numOfBooks) {
        borrowCnt += numOfBooks;
    }

    // returns the number of books borrowed
    public int getBorrowCnt() {
        return borrowCnt;
    }

    // returns the owner of this card
    public Student getOwner() {
        return owner;
    }

    // sets owner to this card
    public void setOwner(Student student) {
        owner = student;
    }

    //Returns the string representation of this card
    public String toString(){
        return "     Owner Name: " + owner.getName( ) + "\n" +
                "         Email: " + owner.getEmail( ) + "\n" +
                "Books Borrowed: " + borrowCnt;
    }
}
