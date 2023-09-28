package Ch12.SampleDevelopment;

import java.io.Serializable;

/*
Let’s see how we write Person objects to a file. First we need
to modify the definition of the Person class in order for ObjectOutputStream and
ObjectInputStream to perform object I/O. We modify the definition by adding the
phrase implements Serializable to it.
*/
class Person implements Serializable {
    // data members
    private String name, email;

    // constructors
    public Person(String name, String email) {
        init(name, email);
    }

    public Person(String name) {
        init(name, "");
    }

    public Person() {
        init("", "");
    }

    // initializer method
    private void init(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
