/*
Write a program that creates an ArrayList of pets. An item in the list is either a
Dog or a Cat. For each pet, enter its name and type (‘c’ for cat and ‘d’ for
dog). Stop the input when the string STOP is entered for the name. After the
input is complete, output the name and type for each pet in the list.
*/

package Ch13.Ch13Lvl1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CatsAndDogs {
    public static void main(String[] args) {
        Pet pet = null;
        String name, type; // name for the pet, type of the pet (c - cat, d - dog)
        Scanner scanner = new Scanner(System.in);
        List<Pet> pets = new ArrayList<>(); // list of pets

        while (true) {
            try {
                // get the type and name of pet from the user
                System.out.print("Enter name of pet (STOP to stop): ");
                name = scanner.nextLine();

                if (name.equals("STOP")) {
                    break;
                }

                System.out.print("Enter type of pet: ");
                type = scanner.nextLine();

                // create the pet object
                if (type.equals("c")) {
                    pet = new Cat(name);
                } else if (type.equals("d")) {
                    pet = new Dog(name);
                } else {
                    System.out.println("Invalid type.");
                }

                // if created, add the new pet to the list
                if (pet != null) {
                    pets.add(pet);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (Pet apet : pets) {
            System.out.println(apet.getName() + " says " + apet.speak());
        }

        /*
        Repeat Exercise 4, but this time group the output by printing out the names
        of all cats first and then the names of all dogs.
        */

        for (Pet cat : pets) {
            if (cat instanceof Dog) {
                System.out.println(cat.getName());
            }
        }

        for (Pet dog : pets) {
            if (dog instanceof Cat) {
                System.out.println(dog.getName());
            }
        }
    }
}

abstract class Pet {
    // data members
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract String speak();
}

class Cat extends Pet {
    // constructors
    public Cat() {
        super();
    }
    public Cat(String name) {
        super();
        this.name = name;
    }

    @Override
    public String speak() {
        return "meow meow";
    }
}

class Dog extends Pet {
    // constructors
    public Dog() {
        super();
    }
    public Dog(String name) {
        super();
        this.name = name;
    }

    @Override
    public String speak() {
        return "rawr rawr";
    }
}