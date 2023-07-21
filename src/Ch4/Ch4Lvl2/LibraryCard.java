/*
Chapter 4 Exercise 11

Extend the LibraryCard class by adding the expiration date as a new property
of a library card. Define the following four methods:
    //sets the expiration date
    public void setExpDate(GregorianCalendar date) {...}
    //returns the expiration year
    public int getExpYear( ) { ... }
    //returns the expiration month
    public int getExpMonth( ) { ... }
    //returns the expiration day
    public int getExpDay( ) { ... }
*/

package Ch4.Ch4Lvl2;

import java.util.*;

public class LibraryCard {
    // data members
    private Student owner; // student owner of this card
    private int borrowCnt; // number of books borrowed
    private GregorianCalendar expDate; // expiration date of this card

    // constructor
    public LibraryCard() {
        owner = null;
        borrowCnt = 0;
        expDate = null;
    }

    // main method
    public static void main(String[] args) {
        // sample

        // declaring and creating LibraryCard instance
        LibraryCard lc = new LibraryCard();

        // expiration date
        GregorianCalendar date = new GregorianCalendar(1972, 1, 30);

        // setting the expiration date
        lc.setExpDate(date);

        // printing out the expiration date
        System.out.println(lc.getExpDay() + "." + lc.getExpMonth() + "." + lc.getExpYear());
    }

    // returns the number of books borrowed
    public int getBorrowCnt() {
        return borrowCnt;
    }
    // returns the owner of this card
    public Student getOwner() {
        return owner;
    }
    //returns the expiration year
    public int getExpYear( ) {
        return expDate.get(Calendar.YEAR);
    }
    //returns the expiration month
    public int getExpMonth( ) {
        return expDate.get(Calendar.MONTH);
    }
    //returns the expiration day
    public int getExpDay( ) {
        return expDate.get(Calendar.DAY_OF_MONTH);
    }


    //sets the expiration date
    public void setExpDate(GregorianCalendar date) {
        expDate = date;
    }
    // adds one to the number of books that are checked out
    public void checkOut(int numOfBooks) {
        borrowCnt += numOfBooks;
    }
    // sets owner to this card
    public void setOwner(Student student) {
        owner = student;
    }

    //returns the string representation of this card
    public String toString(){
        return "     Owner Name: " + owner.getName( ) + "\n" +
                "         Email: " + owner.getEmail( ) + "\n" +
                "Books Borrowed: " + borrowCnt;
    }
}
class Student {
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
}

