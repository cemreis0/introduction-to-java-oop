/*
Suppose you have a list of Dog and Cat objects from Exercise 6 and want to
find the average, minimum, and maximum weight of dogs. To compute these
values, you must scan the whole list. It would be more efficient if you could
get the results by traversing only Dog objects in the list. One approach to
achieve this improvement is to create another list that includes only Dog
objects (actually references to Dog objects).
*/

package Ch13.Ch13Lvl3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatsAndDogsVer3 {
    public static void main(String[] args) {
        PetVer3 pet = null;
        String name, type; // name for the pet, type of the pet (c - cat, d - dog)
        String coatColor; // coat color for cat
        double weight; // weight for dog
        Scanner scanner = new Scanner(System.in);
        List<PetVer3> pets = new ArrayList<>(); // list of pets
        List<DogVer3> dogs = new ArrayList<>(); // list of dogs

        while (true) {
            try {
                // Display menu options
                System.out.println("Menu Options:");
                System.out.println("1. Add Cat");
                System.out.println("2. Add Dog");
                System.out.println("3. Remove Cat");
                System.out.println("4. Remove Dog");
                System.out.println("0. Quit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        // Add Cat
                        System.out.print("Enter name of cat: ");
                        name = scanner.nextLine();
                        System.out.print("Enter coat color of cat: ");
                        coatColor = scanner.nextLine();
                        pet = new CatVer3(name, coatColor);
                        pets.add(pet);
                        break;
                    case 2:
                        // Add Dog
                        System.out.print("Enter name of dog: ");
                        name = scanner.nextLine();
                        System.out.print("Enter weight of dog: ");
                        weight = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        pet = new DogVer3(name, weight);
                        pets.add(pet);
                        break;
                    case 3:
                        // Remove Cat
                        System.out.print("Enter the name of the cat to remove: ");
                        String catNameToRemove = scanner.nextLine();

                        // Iterate through the pets list to find and remove the cat by name
                        boolean catRemoved = false;
                        for (int i = 0; i < pets.size(); i++) {
                            PetVer3 currentPet = pets.get(i);
                            if (currentPet instanceof CatVer3 && currentPet.getName().equals(catNameToRemove)) {
                                pets.remove(i);
                                catRemoved = true;
                                System.out.println("Cat named '" + catNameToRemove + "' has been removed.");
                                break; // Exit the loop after removing the cat
                            }
                        }

                        if (!catRemoved) {
                            System.out.println("Cat named '" + catNameToRemove + "' not found in the list.");
                        }
                        break;
                    case 4:
                        // Remove Dog
                        System.out.print("Enter the name of the dog to remove: ");
                        String dogNameToRemove = scanner.nextLine();

                        // Iterate through the pets list to find and remove the dog by name
                        boolean dogRemoved = false;
                        for (int i = 0; i < pets.size(); i++) {
                            PetVer3 currentPet = pets.get(i);
                            if (currentPet instanceof DogVer3 && currentPet.getName().equals(dogNameToRemove)) {
                                pets.remove(i);
                                dogRemoved = true;
                                System.out.println("Dog named '" + dogNameToRemove + "' has been removed.");
                                break; // Exit the loop after removing the dog
                            }
                        }

                        if (!dogRemoved) {
                            System.out.println("Dog named '" + dogNameToRemove + "' not found in the list.");
                        }
                        break;
                    case 0:
                        // Quit
                        System.out.println("Exiting the program.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Consume the newline character to prevent infinite loop
            }


            for (PetVer3 apet : pets) {
                // if apet is a dog, append it to dogs
                if (apet instanceof DogVer3) {
                    dogs.add((DogVer3) apet);
                }
            }

            // now iterate over dogs and get the minimum, maximum and average weights
            if (dogs.size() > 0) {
                double min, max, avr;
                min = max = dogs.get(0).getWeight();
                avr = 0;
                for (DogVer3 dog : dogs) {
                    if (dog.getWeight() < min) {
                        min = dog.getWeight();
                    }

                    if (dog.getWeight() > max) {
                        max = dog.getWeight();
                    }

                    avr += dog.getWeight();
                }

                avr = avr / dogs.size();

                System.out.println("min: " + min + " max: " + max + " avr: " + avr);
            }
        }
    }
}

abstract class PetVer3 {
    // data members
    protected String name;

    // constructors
    public PetVer3() {
        this("no name");
    }
    public PetVer3(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract String speak();
}

class CatVer3 extends PetVer3 {
    // data members
    private String coatColor;

    // constructors
    public CatVer3() {
        super();
        coatColor = "no name";
    }
    public CatVer3(String name) {
        super(name);
        coatColor = "no color";
    }
    public CatVer3(String name, String coatColor) {
        super(name);
        this.coatColor = coatColor;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    @Override
    public String speak() {
        return "meow meow";
    }
}

class DogVer3 extends PetVer3 {
    // data members
    private double weight;

    // constructors
    public DogVer3() {
        super();
        weight = 0.0;
    }
    public DogVer3(String name) {
        super(name);
        weight = 0.0;
    }
    public DogVer3(String name, double weight) {
        super(name);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String speak() {
        return "rawr rawr";
    }
}