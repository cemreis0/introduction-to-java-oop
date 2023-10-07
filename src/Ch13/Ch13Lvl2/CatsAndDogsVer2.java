/*
Modify the Dog class to include a new instance variable weight (double) and
the Cat class to include a new instance variable coatColor (string). Add the
corresponding accessors and mutators for the new instance variables.
Modify Exercise 4 by inputting additional information appropriate for the
type. First you input name and type, as before. If the type is a cat, then input
its coat color. If the type is a dog, then input its weight. After the input is
complete, output the name, type, and coat color for the cats and the name,
type, and weight for the dogs.
*/

package Ch13.Ch13Lvl2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatsAndDogsVer2 {
    public static void main(String[] args) {
        PetVer2 pet = null;
        String name, type; // name for the pet, type of the pet (c - cat, d - dog)
        String coatColor; // coat color for cat
        double weight; // weight for dog
        Scanner scanner = new Scanner(System.in);
        List<PetVer2> pets = new ArrayList<>(); // list of pets

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
                    System.out.print("Enter coat color of cat: ");
                    coatColor = scanner.nextLine();

                    pet = new CatVer2(name, coatColor);
                } else if (type.equals("d")) {
                    System.out.print("Enter weight of dog: ");
                    weight = scanner.nextDouble();

                    pet = new DogVer2(name, weight);
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

        for (PetVer2 apet : pets) {
            if (apet instanceof CatVer2) {
                System.out.println(apet.getName() + ", coat color: " + ((CatVer2) apet).getCoatColor());
            } else if (apet instanceof  DogVer2) {
                System.out.println(apet.getName() + ", weight: " + ((DogVer2) apet).getWeight());
            }
        }
    }
}

abstract class PetVer2 {
    // data members
    protected String name;

    // constructors
    public PetVer2() {
        this("no name");
    }
    public PetVer2(String name) {
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

class CatVer2 extends PetVer2 {
    // data members
    private String coatColor;

    // constructors
    public CatVer2() {
        super();
        coatColor = "no name";
    }
    public CatVer2(String name) {
        super(name);
        coatColor = "no color";
    }
    public CatVer2(String name, String coatColor) {
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

class DogVer2 extends PetVer2 {
    // data members
    private double weight;

    // constructors
    public DogVer2() {
        super();
        weight = 0.0;
    }
    public DogVer2(String name) {
        super(name);
        weight = 0.0;
    }
    public DogVer2(String name, double weight) {
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