package Ch12.SampleDevelopment;

import java.io.*;

public class Ch12TestObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // set up streams
        File inFile = new File("files/objects.dat");
        FileInputStream inStream = new FileInputStream(inFile);
        ObjectInputStream inObjectStream = new ObjectInputStream(inStream);

        Person person;
        person = (Person) inObjectStream.readObject();

        System.out.println("Person");
        System.out.println("Name: " + person.getName());
        System.out.println("Email: " + person.getEmail());

        // input done, so close the stream
        inObjectStream.close();
    }
}
