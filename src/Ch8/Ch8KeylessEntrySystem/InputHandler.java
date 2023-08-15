package Ch8.Ch8KeylessEntrySystem;

import java.util.*;

public class InputHandler {
    // data members
    private static final String BLANK = "";
    private String name;
    private String room;
    private String password;
    private Scanner scanner;

    // constructors
    public InputHandler(){
        name = BLANK;
        room = BLANK;
        password = BLANK;
        scanner = new Scanner(System.in);
    }

    // main method
    public static void main(String[] args) {

    }

    public void getInput(){
        System.out.print("Enter Name:");
        name = scanner.next();
        System.out.print("Enter Room No.:");
        room = scanner.next();
        System.out.print("Enter Password:");
        password = scanner.next();
    }

    public String getName(){
        return name;
    }
    public String getRoom(){
        return room;
    }
    public String getPassword(){
        return password;
    }
}
