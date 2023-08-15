package Ch8.Ch8KeylessEntrySystem;

import java.io.*;

public class Resident implements Serializable {
    // data members
    private String name;
    private String room;
    private String password;

    // constructors
    public Resident(){
        this("unassigned", "000", "XY12#$ab");
    }
    public Resident(String name, String room, String password) throws IllegalArgumentException {
        setName(name);
        setRoom(room);
        setPassword(password);
    }

    // main method
    public static void main(String[] args) {

    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getRoom(){
        return room;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        int length = password.length();
        if (length < 8 || length > 64) {
            throw new IllegalArgumentException();
        } else {
            this.password = password;
        }
    }
    public void setRoom(String room) {
        this.room = room;
    }
}
